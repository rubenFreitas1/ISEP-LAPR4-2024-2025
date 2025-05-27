package eapli.base.showProposalManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DroneListItemTest {

    @InjectMocks
    private DroneListItem droneListItem;

    private Calendar now;

    private FigureCategory category;

    private SystemUser user;
    private DroneModel droneModel;

    private DroneModel droneModel2;

    private DroneWindBehavior behavior;

    private ShowRequest showRequest;

    private GeoLocation geoLocation;

    private Customer customer;

    private LocalTime localTime = LocalTime.MIDNIGHT;

    private List<Figure> figures;


    private ShowProposal showProposal;
    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();
        var policy = new ExemploPasswordPolicy();
        PasswordEncoder encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("joe", "StrongPass123", "John", "Doe", "joe@email.com")
                .withRoles(Roles.ADMIN).build();
        behavior = new DroneWindBehavior();
        behavior.addTolerance(Axis.X,0,10, 0.5);
        behavior.addTolerance(Axis.X,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Y,0,10, 0.5);
        behavior.addTolerance(Axis.Y,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Z,0,10, 0.5);
        behavior.addTolerance(Axis.Z,10.0001,20, 0.8);
        droneModel = new DroneModel("Falcon", "Amazon", now, user, behavior);
        droneModel2 = new DroneModel("Vitality", "Apple", now, user, behavior);
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


        showRequest = new ShowRequest(geoLocation,now,40,40, figures,customer,"aniversario", user);

        showProposal = new ShowProposal(showRequest, geoLocation,now, localTime,50,50,4,user);

    }


    @Test
    void testValidConstruction() {
        DroneListItem item = new DroneListItem(droneModel, showProposal, 5);

        assertEquals(droneModel, item.droneModel());
        assertEquals(showProposal, item.showProposal());
        assertEquals(5, item.numberOfDrones());
    }

    @Test
    void testInvalidNumberOfDronesThrowsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new DroneListItem(droneModel, showProposal, 0));
        assertEquals("Number of drones can't be negative!", ex.getMessage());
    }


    @Test
    void testNullArgumentsThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new DroneListItem(null, showProposal, 5));
        assertThrows(IllegalArgumentException.class, () -> new DroneListItem(droneModel, null, 5));
    }


    @Test
    void testEqualsAndHashCode() {

        DroneListItem item1 = new DroneListItem(droneModel, showProposal, 5);
        DroneListItem item2 = new DroneListItem(droneModel2,showProposal, 10);

        assertNotEquals(item1, item2);
        assertNotEquals(item1.hashCode(), item2.hashCode());
    }



}