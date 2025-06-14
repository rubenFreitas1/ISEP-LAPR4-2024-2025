package eapli.base.showRequestManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.DSL;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.domain.PluginType;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShowRequestManagementServiceTest {

    @Mock
    private ShowRequestRepository showRequestRepository;

    @InjectMocks
    private ShowRequestManagementService service;

    private SystemUser systemUser;
    PasswordPolicy policy = new ExemploPasswordPolicy();
    PasswordEncoder encoder = new PlainTextEncoder();
    private FigureCategory category;
    private Customer customer;
    private List<Figure> figures;
    private GeoLocation geoLocation;
    private String description;

    private ShowRequest showRequest;
    private Calendar date;

    @BeforeEach
    void setUp() {
        date = Calendar.getInstance();
        category = new FigureCategory("Geometria", "Estudo de figuras geométricas", Calendar.getInstance());
        Set<String> keywords = new HashSet<>(Set.of("triângulo", "ângulo", "figura"));
        systemUser = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles( Roles.ADMIN).build();

        Name name = Name.valueOf("Pedrão", "Pedrão");
        EmailAddress email = EmailAddress.valueOf("pedrao.email@gmail.com");
        Optional<Password> password = Password.encodedAndValid("123456", policy, encoder);
        customer = new Customer(name, "rua do pedrao", email, password, "123456789", "123456789", systemUser, Customer.CustomerStatus.CREATED, Calendar.getInstance());
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Star", keywords, category, false, null, systemUser, dsl, dslBody);
        figures = List.of(figure);
        geoLocation = new GeoLocation(41.1579, -8.6291, 100);
        description = "Light drone show at the city park";
        showRequest = new ShowRequest(geoLocation, date, 5, 30, figures, customer, description, systemUser);
    }

    @Test
    void registerShowRequest_success() {
        when(showRequestRepository.save(any(ShowRequest.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ShowRequest result = service.registerShowRequest(customer, geoLocation, date, 5, 30, figures, description, systemUser);

        assertNotNull(result);
        assertEquals(geoLocation, result.location());
        assertEquals(date, result.date());
        assertEquals(30, result.droneNumber());
        assertEquals(5, result.duration());
        assertEquals(figures, result.requestedFigures());
        assertEquals(customer, result.customer());
        assertEquals(description, result.description());

        verify(showRequestRepository).save(any(ShowRequest.class));
    }


    @Test
    void findByCustomer_returnsRequests() {
        List<ShowRequest> expected = List.of(showRequest);
        when(showRequestRepository.findByCustomer(customer)).thenReturn(expected);

        Iterable<ShowRequest> result = service.findByCustomer(customer);

        assertNotNull(result);
        assertEquals(expected, result);
        verify(showRequestRepository).findByCustomer(customer);
    }

    @Test
    void editShowRequestLocation_success() {
        GeoLocation newLocation = new GeoLocation(41.545, -8.426, 102);
        showRequest.changeLocation(newLocation);

        when(showRequestRepository.save(any(ShowRequest.class)))
                .thenReturn(showRequest);

        ShowRequest updated = service.editShowRequestLocation(showRequest, newLocation);

        assertNotNull(updated);
        assertEquals(newLocation, updated.location());
        verify(showRequestRepository).save(showRequest);
    }


    @Test
    void editShowRequestDate_success() {
        Calendar newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_MONTH, 10);
        showRequest.changeDate(newDate);

        when(showRequestRepository.save(any(ShowRequest.class)))
                .thenReturn(showRequest);

        ShowRequest updated = service.editShowRequestDate(showRequest, newDate);

        assertNotNull(updated);
        assertEquals(newDate, updated.date());
        verify(showRequestRepository).save(showRequest);
    }

    @Test
    void editShowRequestDroneNumber_success() {
        int newDroneNumber = 8;
        showRequest.changeDroneNumber(newDroneNumber);

        when(showRequestRepository.save(any(ShowRequest.class)))
                .thenReturn(showRequest);

        ShowRequest updated = service.editShowRequestDroneNumber(showRequest, newDroneNumber);

        assertNotNull(updated);
        assertEquals(newDroneNumber, updated.droneNumber());
        verify(showRequestRepository).save(showRequest);
    }

    @Test
    void editShowRequestDuration_success() {
        int newDuration = 45;
        showRequest.changeDuration(newDuration);

        when(showRequestRepository.save(any(ShowRequest.class)))
                .thenReturn(showRequest);

        ShowRequest updated = service.editShowRequestDuration(showRequest, newDuration);

        assertNotNull(updated);
        assertEquals(newDuration, updated.duration());
        verify(showRequestRepository).save(showRequest);
    }

    @Test
    void editShowRequestSequenceOfFigures_success() {
        Set<String> keywords = new HashSet<>(Set.of("circle", "round"));
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure newFigure = new Figure("Circle", keywords, category, true, null, systemUser, dsl, dslBody);
        List<Figure> newFigures = List.of(newFigure);

        showRequest.changeRequestedFigures(newFigures);

        when(showRequestRepository.save(any(ShowRequest.class)))
                .thenReturn(showRequest);

        ShowRequest updated = service.editShowRequestSequenceOfFigures(showRequest, newFigures);

        assertNotNull(updated);
        assertEquals(newFigures, updated.requestedFigures());
        verify(showRequestRepository).save(showRequest);
    }
    @Test
    void editShowRequestDescription_success() {
        String newDescription = "Show noturno com figuras novas";
        showRequest.changeDescription(newDescription);

        when(showRequestRepository.save(any(ShowRequest.class)))
                .thenReturn(showRequest);

        ShowRequest updated = service.editShowRequestDescription(showRequest, newDescription);

        assertNotNull(updated);
        assertEquals(newDescription, updated.description());
        verify(showRequestRepository).save(showRequest);
    }
}