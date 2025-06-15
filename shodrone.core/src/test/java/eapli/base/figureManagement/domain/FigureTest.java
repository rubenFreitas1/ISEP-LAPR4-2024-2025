package eapli.base.figureManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FigureTest {

    private FigureCategory category;
    private Set<String> keywords;

    private final Calendar now = CurrentTimeCalendars.now();

    private Customer customer;

    private SystemUser user;


    @BeforeEach
    void setup() {
        var policy = new ExemploPasswordPolicy();
        PasswordEncoder encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN).build();
        category = new FigureCategory("Fantasy", "Fantasy figures", now);
        keywords = new HashSet<>();
        keywords.add("dragon");
        keywords.add("magic");

        Name name = Name.valueOf("Pedro", "Pereira");
        EmailAddress email = EmailAddress.valueOf("pedro.email@gmail.com");
        Optional<Password> password = Password.encodedAndValid("123456789", policy, encoder);
        customer = new Customer(name, "rua do pedro", email,password, "123456789","123456789",user, Customer.CustomerStatus.CREATED,now);
    }

    @Test
    void constructor_createsActiveFigure() {
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("A dragon figure", keywords, category, true, customer, user, dsl, dslBody);
        assertEquals("A dragon figure", figure.description());
        assertEquals(category, figure.figureCategory());
        assertEquals(customer, figure.customer());
        assertTrue(figure.isActive());
        assertTrue(figure.keywords().contains("dragon"));
    }

    @Test
    void constructor_allowsNullCustomer() {
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Figure without customer", keywords, category, false, null, user, dsl, dslBody);
        assertNull(figure.customer());
    }

    @Test
    void constructor_nullKeywords_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
            DSL dsl = new DSL("DSL body content", plugin, "1.2");
            String dslBody = "DSL body content";
            new Figure("Invalid figure", null, category, false, null, user, dsl, dslBody);
        });
    }

    @Test
    void constructor_nullCreatedBy_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
            DSL dsl = new DSL("DSL body content", plugin, "1.2");
            String dslBody = "DSL body content";
            new Figure("Invalid figure", keywords, category, false, null, null, dsl, dslBody);
        });
    }

    @Test
    void constructor_nullCategory_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
            DSL dsl = new DSL("DSL body content", plugin, "1.2");
            String dslBody = "DSL body content";
            new Figure("Invalid figure", keywords, null, false, null, user, dsl, dslBody);
        });
    }

    @Test
    void deactivate_setsInactiveAndStoresDate() {
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Alien sculpture", keywords, category, false, null, user, dsl, dslBody);
        Calendar today = Calendar.getInstance();

        figure.deactivate(today);

        assertFalse(figure.isActive());
        assertEquals(today, figure.deactivatedOn());
    }

    @Test
    void deactivate_alreadyInactive_throwsException() {
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Alien sculpture", keywords, category, false,null, user, dsl, dslBody);
        Calendar today = Calendar.getInstance();
        figure.deactivate(today);

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> figure.deactivate(today));

        assertEquals("Cannot deactivate an inactive Figure!", exception.getMessage());
    }

    @Test
    void deactivate_nullDate_throwsException() {
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Alien sculpture", keywords, category, false,null, user, dsl, dslBody);

        assertThrows(IllegalArgumentException.class, () -> figure.deactivate(null));
    }

    @Test
    void activate_reactivatesFigureAndClearsDeactivationDate() {
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Alien sculpture", keywords, category, false,null, user, dsl, dslBody);
        Calendar today = Calendar.getInstance();
        figure.deactivate(today);

        figure.activate();

        assertTrue(figure.isActive());
        assertNull(figure.deactivatedOn());
    }


}