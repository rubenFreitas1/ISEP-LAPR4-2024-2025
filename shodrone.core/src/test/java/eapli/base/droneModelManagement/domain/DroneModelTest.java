package eapli.base.droneModelManagement.domain;

import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DroneModelTest {

    private SystemUser user;
    private Calendar now;

    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();
        var policy = new ExemploPasswordPolicy();
        PasswordEncoder encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN).build();
    }

    @Test
    void constructor_validData_shouldCreateDroneModel() {
        DroneModel model = new DroneModel("Falcon", "DJI", now, user);

        assertEquals("Falcon", model.modelName());
        assertEquals("DJI", model.manufacturer());
        assertEquals(user, model.createdBy());
        assertEquals(now, model.createdOn());
        assertTrue(model.isActive());
    }

    @Test
    void constructor_nullModelName_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new DroneModel(null, "DJI", now, user));
    }

    @Test
    void constructor_nullManufacturer_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new DroneModel("Falcon", null, now, user));
    }

    @Test
    void deactivate_shouldChangeActiveStatusToFalse() {
        DroneModel model = new DroneModel("Falcon", "DJI", now, user);

        assertTrue(model.isActive());
        model.deactivate(Calendar.getInstance());
        assertFalse(model.isActive());
        assertNotNull(model.deactivatedOn());
    }

    @Test
    void activate_shouldChangeActiveStatusToTrue() {
        DroneModel model = new DroneModel("Falcon", "DJI", now, user);
        model.deactivate(Calendar.getInstance());

        assertFalse(model.isActive());
        model.activate();
        assertTrue(model.isActive());
        assertNull(model.deactivatedOn());
    }

}