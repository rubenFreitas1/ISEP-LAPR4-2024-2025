package eapli.base.showRequestManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
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
    private GeoLocation geoLocation;

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
        Figure figure = new Figure("Alien figure", keywords, category, false, null, user);
        figures = new ArrayList<>(List.of(figure));

        Name name = Name.valueOf("Alice", "Smith");
        EmailAddress email = EmailAddress.valueOf("alice@mail.com");
        Optional<Password> password = Password.encodedAndValid("987654321", policy, encoder);
        customer = new Customer(name, "Wonderland Street", email,
                password, "123123123", "456456456", user, Customer.CustomerStatus.CREATED, now);

        geoLocation = new GeoLocation(38.7169, -9.1399, 100);
    }


    @Test
    void constructor_initializesCorrectly() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_MONTH, 5);

        ShowRequest request = new ShowRequest(geoLocation, futureDate, 5, 30, figures, customer, "Test show", user);

        assertEquals(geoLocation, request.location());
        assertEquals(futureDate, request.date());
        assertEquals(5, request.droneNumber());
        assertEquals(30, request.duration());
        assertEquals(figures, request.requestedFigures());
        assertEquals(ShowStatus.PENDING, request.status());
        assertEquals(customer, request.customer());
        assertNotNull(request.createdOn());
    }

    @Test
    void changeLocation_updatesLocation() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        GeoLocation newLocation = new GeoLocation(40.7128, -74.0060, 55); // New York

        request.changeLocation(newLocation);
        assertEquals(newLocation, request.location());
    }

    @Test
    void changeLocation_null_throwsException() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        assertThrows(IllegalArgumentException.class, () -> request.changeLocation(null));
    }

    @Test
    void changeDate_updatesDate() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        Calendar newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_MONTH, 10);

        request.changeDate(newDate);
        assertEquals(newDate, request.date());
    }

    @Test
    void changeDate_null_throwsException() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        assertThrows(IllegalArgumentException.class, () -> request.changeDate(null));
    }

    @Test
    void changeDroneNumber_valid_updatesNumber() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        request.changeDroneNumber(7);
        assertEquals(7, request.droneNumber());
    }

    @Test
    void changeDroneNumber_invalid_throwsException() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        assertThrows(IllegalArgumentException.class, () -> request.changeDroneNumber(0));
    }

    @Test
    void changeDuration_valid_updatesDuration() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        request.changeDuration(50);
        assertEquals(50, request.duration());
    }

    @Test
    void changeDuration_null_throwsException() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        assertThrows(IllegalArgumentException.class, () -> request.changeDuration(null));
    }

    @Test
    void changeRequestedFigures_valid_updatesFigures() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        Set<String> newKeywords = new HashSet<>(Set.of("robot", "AI"));
        Figure newFigure = new Figure("Robot figure", newKeywords, category, true, customer, user);
        List<Figure> newFigures = List.of(newFigure);

        request.changeRequestedFigures(newFigures);
        assertEquals(newFigures, request.requestedFigures());
    }

    @Test
    void changeRequestedFigures_null_throwsException() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        assertThrows(IllegalArgumentException.class, () -> request.changeRequestedFigures(null));
    }

    @Test
    void changeDescription_valid_updatesDescription() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial description", user);
        request.changeDescription("New description");
        assertEquals("New description", request.description());
        assertNotNull(request.editedOn());
    }

    @Test
    void changeDescription_null_throwsException() {
        ShowRequest request = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial description", user);
        assertThrows(IllegalArgumentException.class, () -> request.changeDescription(null));
    }

}
