package eapli.base.droneModelManagement.domain;

import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DroneModelBuilderTest {

    private SystemUser user;
    private final Calendar now = Calendar.getInstance();

    @BeforeEach
    void setUp() {
        PasswordPolicy policy = new ExemploPasswordPolicy();
        PasswordEncoder encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("jsmith", "Password1", "John", "Smith", "jsmith@email.com")
                .withRoles(Roles.ADMIN)
                .build();
    }

    @Test
    void build_validData_createsDroneModel() {
        DroneModel model = new DroneModelBuilder()
                .withModelName("Falcon")
                .withManufacturer("DJI")
                .createdOn(now)
                .createdBy(user)
                .build();

        assertNotNull(model);
        assertEquals("Falcon", model.modelName());
        assertEquals("DJI", model.manufacturer());
        assertEquals(user, model.createdBy());
        assertEquals(now, model.createdOn());
    }

    @Test
    void build_nullModelName_throwsException() {
        DroneModelBuilder builder = new DroneModelBuilder()
                .withManufacturer("DJI")
                .createdOn(now)
                .createdBy(user);

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void build_emptyManufacturer_throwsException() {
        DroneModelBuilder builder = new DroneModelBuilder()
                .withModelName("Falcon")
                .withManufacturer("")
                .createdOn(now)
                .createdBy(user);

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void build_nullCreatedOn_throwsException() {
        DroneModelBuilder builder = new DroneModelBuilder()
                .withModelName("Falcon")
                .withManufacturer("DJI")
                .createdBy(user);

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void build_nullCreatedBy_throwsException() {
        DroneModelBuilder builder = new DroneModelBuilder()
                .withModelName("Falcon")
                .withManufacturer("DJI")
                .createdOn(now);

        assertThrows(IllegalArgumentException.class, builder::build);
    }

}