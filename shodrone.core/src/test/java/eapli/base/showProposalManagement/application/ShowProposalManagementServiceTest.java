package eapli.base.showProposalManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
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
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ShowProposalManagementServiceTest {

    @Mock
    private ShowProposalRepository repo;

    @InjectMocks
    private ShowProposalManagementService service;

    private ShowProposal proposal;
    private DroneModel modelA;
    private SystemUser user;

    private FigureCategory category;
    private DroneWindBehavior behavior;

    private Customer customer;

    private List<Figure> figures;
    private Template template;
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
        Figure figure = new Figure("Alien figure", keywords, category, false, null, user);
        figures = new ArrayList<>(List.of(figure));
        GeoLocation location = new GeoLocation(40.0, -8.0, 30);
        ShowRequest request = new ShowRequest(location,Calendar.getInstance(),20,30,figures,customer, "Aniversário", user);
        template = new Template("template", "content");
        proposal = new ShowProposal(request, location, Calendar.getInstance(), LocalTime.now(),30, 5,1, user, template, 50);
        modelA = new DroneModel("DJI", "Phantom 4", Calendar.getInstance(), user,behavior);
    }

    @Test
    void registerShowProposal_success() {
        when(repo.countByShowRequest(proposal.showRequest())).thenReturn(0L);
        when(repo.save(any(ShowProposal.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ShowProposal result = service.registerShowProposal(
                proposal.showRequest(),
                proposal.location(),
                proposal.date(),
                proposal.time(),
                proposal.duration(),
                proposal.totalDroneNumber(),
                user,
                proposal.template(),
                proposal.insuranceAmount()
        );

        assertNotNull(result);
        assertEquals(proposal.showRequest(), result.showRequest());
        assertEquals(proposal.location(), result.location());
        assertEquals(proposal.date(), result.date());
        assertEquals(proposal.time(), result.time());
        assertEquals(proposal.duration(), result.duration());
        assertEquals(proposal.totalDroneNumber(), result.totalDroneNumber());
        assertEquals(1, result.proposalNumber());  // since countByShowRequest returns 0L
        assertEquals(user, result.createdBy());

        verify(repo).countByShowRequest(proposal.showRequest());
        verify(repo).save(any(ShowProposal.class));
    }

    @Test
    void findByShowRequest_returnsProposals() {
        List<ShowProposal> expected = List.of(proposal);
        when(repo.findByShowRequest(proposal.showRequest())).thenReturn(expected);

        Iterable<ShowProposal> result = service.findByShowRequest(proposal.showRequest());

        assertNotNull(result);
        assertEquals(expected, result);

        verify(repo).findByShowRequest(proposal.showRequest());
    }

    @Test
    void findByPendingAndEmptyVideo_returnsProposals() {
        ShowStatus status = ShowStatus.PENDING;
        List<ShowProposal> expected = List.of(proposal);

        when(repo.findByPendingAndEmptyVideo(customer, status)).thenReturn(expected);

        Iterable<ShowProposal> result = service.findByPendingAndEmptyVideo(customer, status);

        assertNotNull(result);
        assertEquals(expected, result);
        verify(repo).findByPendingAndEmptyVideo(customer, status);
    }
}