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

    private DroneWindBehavior behavior;

    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();
        var policy = new ExemploPasswordPolicy();
        PasswordEncoder encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN).build();
        behavior = new DroneWindBehavior();
        behavior.addTolerance(Axis.X,0,10, 0.5);
        behavior.addTolerance(Axis.X,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Y,0,10, 0.5);
        behavior.addTolerance(Axis.Y,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Z,0,10, 0.5);
        behavior.addTolerance(Axis.Z,10.0001,20, 0.8);
    }

    @Test
    void constructor_validData_shouldCreateDroneModel() {
        DroneModel model = new DroneModel("Falcon", "DJI", now, user, behavior);
        assertEquals("Falcon", model.modelName());
        assertEquals("DJI", model.manufacturer());
        assertEquals(user, model.createdBy());
        assertEquals(now, model.createdOn());
        assertEquals(behavior, model.windBehavior());
        assertTrue(model.isActive());
    }

    @Test
    void constructor_nullModelName_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new DroneModel(null, "DJI", now, user, behavior));
    }

    @Test
    void constructor_nullManufacturer_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new DroneModel("Falcon", null, now, user, behavior));
    }

    @Test
    void constructor_nullBehavior_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new DroneModel("Falcon", "DJI", now, user, null));
    }

    @Test
    void remove_shouldChangeActiveStatusToFalse() {
        DroneModel model = new DroneModel("Falcon", "DJI", now, user, behavior);
        assertTrue(model.isActive());
        model.deactivate(Calendar.getInstance());
        assertFalse(model.isActive());
        assertNotNull(model.deactivatedOn());
    }

    @Test
    void activate_shouldChangeActiveStatusToTrue() {
        DroneModel model = new DroneModel("Falcon", "DJI", now, user, behavior);
        model.deactivate(Calendar.getInstance());

        assertFalse(model.isActive());
        model.activate();
        assertTrue(model.isActive());
        assertNull(model.deactivatedOn());
    }

    @Test
    void remove_withDateBeforeCreatedOn_shouldThrowException() {
        Calendar past = Calendar.getInstance();
        past.setTimeInMillis(now.getTimeInMillis() - 10000);
        DroneModel model = new DroneModel("Falcon", "DJI", now, user, behavior);

        assertThrows(IllegalArgumentException.class, () -> model.deactivate(past));
    }

    @Test
    void remove_whenAlreadyInactive_shouldThrowException() {
        DroneModel model = new DroneModel("Falcon", "DJI", now, user, behavior);
        model.deactivate(Calendar.getInstance());

        assertThrows(IllegalStateException.class, () -> model.deactivate(Calendar.getInstance()));
    }

}