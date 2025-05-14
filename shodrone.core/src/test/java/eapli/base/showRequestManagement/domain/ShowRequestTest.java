package eapli.base.showRequestManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShowRequestTest {

    private SystemUser user;
    private Customer customer;
    private List<Figure> figures;
    private Calendar now;
    private FigureCategory category;

    @BeforeEach
    void setup() {
        var policy = new ExemploPasswordPolicy();
        var encoder = new PlainTextEncoder();

        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN).build();

        now = CurrentTimeCalendars.now();
        category = new FigureCategory("Sci-fi", "Sci-fi figures", now);

        Set<String> keywords = new HashSet<>(Set.of("alien", "space"));
        Figure figure = new Figure("Alien figure", keywords, category, false, null);
        figures = new ArrayList<>(List.of(figure));

        customer = new Customer("Alice", "Wonderland Street", "alice@mail.com",
                "987654321", "123123123", "456456456", user, Customer.CustomerStatus.CREATED, now);
    }

    @Test
    void constructor_initializesCorrectly() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_MONTH, 5);

        ShowRequest request = new ShowRequest("Central Park", futureDate, 5, 30, figures, customer);

        assertEquals("Central Park", request.location());
        assertEquals(futureDate, request.date());
        assertEquals(5, request.droneNumber());
        assertEquals(30, request.duration());
        assertEquals(figures, request.requestedFigures());
        assertEquals(ShowRequestStatus.PENDING, request.status());
        assertEquals(customer, request.customer());
        assertNotNull(request.createdOn());
    }

    @Test
    void changeLocation_updatesLocation() {
        ShowRequest request = new ShowRequest("Old Place", now, 2, 20, figures, customer);
        request.changeLocation("New Place");
        assertEquals("New Place", request.location());
    }

    @Test
    void changeLocation_null_throwsException() {
        ShowRequest request = new ShowRequest("Old Place", now, 2, 20, figures, customer);
        assertThrows(IllegalArgumentException.class, () -> request.changeLocation(null));
    }

    @Test
    void changeDate_updatesDate() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        Calendar newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_MONTH, 10);
        request.changeDate(newDate);
        assertEquals(newDate, request.date());
    }

    @Test
    void changeDate_null_throwsException() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        assertThrows(IllegalArgumentException.class, () -> request.changeDate(null));
    }

    @Test
    void changeDroneNumber_validNumber_updatesNumber() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        request.changeDroneNumber(7);
        assertEquals(7, request.droneNumber());
    }

    @Test
    void changeDroneNumber_zero_throwsException() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        assertThrows(IllegalArgumentException.class, () -> request.changeDroneNumber(0));
    }

    @Test
    void changeDuration_valid_updatesDuration() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        request.changeDuration(50);
        assertEquals(50, request.duration());
    }

    @Test
    void changeDuration_null_throwsException() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        assertThrows(IllegalArgumentException.class, () -> request.changeDuration(null));
    }

    @Test
    void changeRequestedFigures_valid_updatesFigures() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        Set<String> newKeywords = new HashSet<>(Set.of("robot", "AI"));
        Figure newFigure = new Figure("Robot figure", newKeywords, category, true, customer);
        List<Figure> newFigures = List.of(newFigure);

        request.changeRequestedFigures(newFigures);
        assertEquals(newFigures, request.requestedFigures());
    }

    @Test
    void changeRequestedFigures_null_throwsException() {
        ShowRequest request = new ShowRequest("Location", now, 2, 20, figures, customer);
        assertThrows(IllegalArgumentException.class, () -> request.changeRequestedFigures(null));
    }
}
