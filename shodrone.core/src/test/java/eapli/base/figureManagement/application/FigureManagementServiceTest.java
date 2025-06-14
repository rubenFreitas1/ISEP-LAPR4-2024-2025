package eapli.base.figureManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.DSL;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.domain.PluginType;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FigureManagementServiceTest {
    @Mock
    private FigureRepository repo;

    @InjectMocks
    private FigureManagementService service;

    private FigureCategory category;
    private Figure figure;
    private Customer customer;
    private SystemUser systemUser;
    private final Calendar now = CurrentTimeCalendars.now();
    @BeforeEach
    public void setup() {
        PasswordPolicy policy = new ExemploPasswordPolicy();
        PlainTextEncoder encoder = new PlainTextEncoder();
        systemUser = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN)
                .build();

        category = new FigureCategory("Geometria", "Estudo de figuras geométricas", now);
        Set<String> keywords = new HashSet<>(Set.of("triângulo", "ângulo", "figura"));
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        figure = new Figure("Triângulo equilátero", keywords, category, false, null, systemUser, dsl, dslBody);

        Name name = Name.valueOf("Client", "Name");
        EmailAddress email = EmailAddress.valueOf("client@email.com");
        Optional<Password> password = Password.encodedAndValid("VAT123", policy, encoder);
        customer = new Customer(
                name,
                "Client Address",
                email,
                password,
                "910000000",
                "CC123456",
                systemUser,
                Customer.CustomerStatus.CREATED,
                Calendar.getInstance()
        );
    }

    @Test
    public void registerNewFigure_success() {
        when(repo.save(any(Figure.class))).thenAnswer(i -> i.getArguments()[0]);

        String dslPath = "DSL body content";
        Figure result = service.registerNewFigure(
                "Triângulo equilátero",
                Set.of("triângulo", "ângulo", "figura"),
                category,
                false,
                null,
                systemUser,
                dslPath
        );

        assertEquals("Triângulo equilátero", result.description());
        verify(repo).save(any(Figure.class));
    }

    @Test
    public void decommissionFigure_setsInactive() {
        when(repo.save(figure)).thenReturn(figure);

        Figure result = service.decommissionFigure(figure);

        assertFalse(result.isActive());
        assertNotNull(result.deactivatedOn());
        verify(repo).save(figure);
    }

    @Test
    public void activateFigure_setsActive() {
        figure.deactivate(CurrentTimeCalendars.now());
        when(repo.save(figure)).thenReturn(figure);

        Figure result = service.activateFigure(figure);

        assertTrue(result.isActive());
        assertNull(result.deactivatedOn());
        verify(repo).save(figure);
    }

    @Test
    public void activeFigures_returnsOnlyActive() {
        List<Figure> expected = List.of(figure);
        when(repo.findByActive(true)).thenReturn(expected);

        Iterable<Figure> result = service.activeFigures();

        assertEquals(expected, result);
        verify(repo).findByActive(true);
    }

    @Test
    public void inactiveFigures_returnsOnlyInactive() {
        List<Figure> expected = List.of(figure);
        when(repo.findByActive(false)).thenReturn(expected);

        Iterable<Figure> result = service.inactiveFigures();

        assertEquals(expected, result);
        verify(repo).findByActive(false);
    }

    @Test
    public void findByCategory_returnsCorrectFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByFigureCategory(category)).thenReturn(expected);

        Iterable<Figure> result = service.findByCategory(category);

        assertEquals(expected, result);
        verify(repo).findByFigureCategory(category);
    }
    @Test
    public void findByKeyword_returnsCorrectFigures() {
        when(repo.findByKeyword("triângulo")).thenReturn(List.of(figure));

        Iterable<Figure> result = service.findByKeyword("triângulo");

        assertNotNull(result);

        List<Figure> figures = new ArrayList<>();
        result.forEach(figures::add);

        assertEquals(1, figures.size());
        assertEquals(figure, figures.get(0));
    }

    @Test
    public void findByNonExclusivity_returnsCorrectFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByExclusivity(false)).thenReturn(expected);

        Iterable<Figure> result = service.findByExclusivity(false);

        assertEquals(expected, result);
        verify(repo).findByExclusivity(false);
    }
    @Test
    public void findByKeywordAndCategory_returnsCorrectFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByKeywordAndCategory("triângulo", category)).thenReturn(expected);

        Iterable<Figure> result = service.findByKeywordAndCategory("triângulo", category);

        assertNotNull(result);
        List<Figure> figures = new ArrayList<>();
        result.forEach(figures::add);

        assertEquals(1, figures.size());
        assertEquals(figure, figures.get(0));
        verify(repo).findByKeywordAndCategory("triângulo", category);
    }

    @Test
    public void listPublicFigures_returnsNonExclusiveFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByExclusivity(false)).thenReturn(expected);

        Iterable<Figure> result = service.listPublicFigures();

        assertNotNull(result);
        assertEquals(expected, result);
        verify(repo).findByExclusivity(false);
    }

    @Test
    public void findByExclusivityAndCustomer_returnsCorrectFigures() {

        List<Figure> expected = List.of(figure);
        when(repo.findByExclusivityAndCustomer(false, customer)).thenReturn(expected);

        Iterable<Figure> result = service.findByExclusivityAndCustomer(false, customer);

        assertNotNull(result);
        List<Figure> resultList = new ArrayList<>();
        result.forEach(resultList::add);

        assertEquals(1, resultList.size());
        assertEquals(figure, resultList.get(0));
        verify(repo).findByExclusivityAndCustomer(false, customer);
    }


}