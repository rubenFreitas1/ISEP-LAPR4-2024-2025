package eapli.base.showProposalManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.DSL;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.domain.PluginType;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddDroneModelsToProposalServiceTest {

    @Mock
    private DroneRepository repo;

    @InjectMocks
    private AddDroneModelsToProposalService service;

    private ShowProposal proposal;
    private DroneModel modelA;
    private SystemUser user;

    private FigureCategory category;
    private DroneWindBehavior behavior;

    private Customer customer;
    private Template template;

    private List<Figure> figures;
    @BeforeEach
    void setup() {
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
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Alien figure", keywords, category, false, null, user, dsl, dslBody);
        figures = new ArrayList<>(List.of(figure));
        GeoLocation location = new GeoLocation(40.0, -8.0, 30);
        ShowRequest request = new ShowRequest(location,Calendar.getInstance(),20,30,figures,customer, "Aniversário", user);
        template = new Template("template", "content");
        proposal = new ShowProposal(request, location, Calendar.getInstance(), LocalTime.now(),30, 5,1, user, template, 50);
        modelA = new DroneModel("DJI", "Phantom 4", Calendar.getInstance(), user,behavior);

    }

    @Test
    void addDroneModelToProposal_success() {
        Drone drone1 = mock(Drone.class);
        Drone drone2 = mock(Drone.class);
        Drone drone3 = mock(Drone.class);
        when(repo.findByDroneModel(modelA)).thenReturn(List.of(drone1, drone2, drone3));
        boolean result = service.addDroneModelToProposal(proposal, modelA, 1);
        assertTrue(result);
    }

    @Test
    void addDroneModelToProposal_notEnoughDrones_throwsException() {
        Drone drone1 = mock(Drone.class);
        when(repo.findByDroneModel(modelA)).thenReturn(List.of(drone1));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                service.addDroneModelToProposal(proposal, modelA, 3));
        assertEquals("Not enough Drones with this Drone Model Registered in the System!", ex.getMessage());
    }

    @Test
    void addDroneModelToProposal_nullProposal_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.addDroneModelToProposal(null, modelA, 3));
    }

    @Test
    void addDroneModelToProposal_nullDroneModel_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.addDroneModelToProposal(proposal, null, 3));
    }

}