package eapli.base.showProposalManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShowProposalTest {
    private ShowProposal proposal;
    private DroneModel modelA;
    private DroneModel modelB;
    private SystemUser user;

    private FigureCategory category;
    private DroneWindBehavior behavior;

    private Customer customer;

    private List<Figure> figures;

    @BeforeEach
    void setUp() {

        behavior = new DroneWindBehavior();
        behavior.addTolerance(Axis.X,0,10, 0.5);
        behavior.addTolerance(Axis.X,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Y,0,10, 0.5);
        behavior.addTolerance(Axis.Y,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Z,0,10, 0.5);
        behavior.addTolerance(Axis.Z,10.0001,20, 0.8);

        var encoder = new PlainTextEncoder();
        var policy = new eapli.base.usermanagement.domain.ExemploPasswordPolicy();
        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN)
                .build();

        Name name = Name.valueOf("Alice", "Smith");
        EmailAddress email = EmailAddress.valueOf("alice@mail.com");
        Optional<Password> password = Password.encodedAndValid("987654321", policy, encoder);
        customer = new Customer(name, "Wonderland Street", email,
                password, "123123123", "456456456", user, Customer.CustomerStatus.CREATED, Calendar.getInstance());
        category = new FigureCategory("Sci-fi", "Sci-fi figures", Calendar.getInstance());
        Set<String> keywords = new HashSet<>(Set.of("alien", "space"));
        Figure figure = new Figure("Alien figure", keywords, category, false, null, user);
        figures = new ArrayList<>(List.of(figure));
        GeoLocation location = new GeoLocation(40.0, -8.0, 30);
        ShowRequest request = new ShowRequest(location,Calendar.getInstance(),20,30,figures,customer, "Aniversário", user);
        proposal = new ShowProposal(request, location, Calendar.getInstance(), LocalTime.now(),30, 5,1, user);
        modelA = new DroneModel("DJI", "Phantom 4", Calendar.getInstance(), user,behavior);
        modelB = new DroneModel("Parrot", "Anafi",Calendar.getInstance(), user, behavior);
    }

    @Test
    void addDroneToList_Succeed() {
        boolean result1 = proposal.addDroneToList(modelA, 3);
        assertTrue(result1);
        assertEquals(3, proposal.allDroneModels_Quantity());

        boolean result2 = proposal.addDroneToList(modelB, 2);
        assertTrue(result2);
        assertEquals(5, proposal.allDroneModels_Quantity());
    }

    @Test
    void addDroneToList_Fail_DroneModelIsNull() {
        boolean result = proposal.addDroneToList(null, 2);
        assertFalse(result);
    }

    @Test
    void addDroneToList_Fail_QuantityIsNonPositive() {
        boolean resultZero = proposal.addDroneToList(modelA, 0);
        boolean resultNegative = proposal.addDroneToList(modelA, -1);

        assertFalse(resultZero);
        assertFalse(resultNegative);
    }

    @Test
    void addDroneToList_Fail_ExceedingTotalLimit() {
        assertTrue(proposal.addDroneToList(modelA, 4));
        assertFalse(proposal.addDroneToList(modelB, 2)); // Total é 5
    }

    @Test
    void addDroneToList_Fail_ModelAlreadyAdded() {
        assertTrue(proposal.addDroneToList(modelA, 3));
        assertFalse(proposal.addDroneToList(modelA, 1));
    }
}