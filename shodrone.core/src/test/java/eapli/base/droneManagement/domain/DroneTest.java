package eapli.base.droneManagement.domain;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DroneTest {


    private  Calendar now;

    private SystemUser user;

    private DroneModel droneModel;

    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();
        var policy = new ExemploPasswordPolicy();
        PasswordEncoder encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("joe", "StrongPass123", "John", "Doe", "joe@email.com")
                .withRoles(Roles.ADMIN).build();
        droneModel = new DroneModel("Falcon", "Amazon", now, user);
    }

    @Test
    void constructor_validData_shouldCreateDrone() {
        Drone drone = new Drone("DRONE1101", droneModel, now, user);

        assertEquals("DRONE1101", drone.serialNumber());
        assertEquals(droneModel, drone.droneModel());
        assertEquals(user, drone.createdBy());
        assertEquals(now, drone.acquisitionDate());
        assertTrue(drone.isActive());
    }

    @Test
    void constructor_nullSerialNumber_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Drone(null, droneModel, now, user));
    }

    @Test
    void constructor_nullDroneModel_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Drone("dr123132", null, now, user));
    }

    @Test
    void constructor_nullAcquisitionDate_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Drone("dr123132", droneModel, null, user));
    }

    @Test
    void constructor_nullSystemUser_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Drone("dr123132", droneModel, now, null));
    }

    @Test
    void remove_shouldChangeActiveStatusToFalse() {
        Drone drone = new Drone("DRONE1101", droneModel, now, user);

        assertTrue(drone.isActive());
        drone.remove(Calendar.getInstance(), "Test reason");
        assertFalse(drone.isActive());
        assertNotNull(drone.deactivatedOn());
    }

    @Test
    void remove_withDateBeforeAcquisition_shouldThrowException() {
        Drone drone = new Drone("DRONE1101", droneModel, now, user);
        Calendar before = (Calendar) now.clone();
        before.add(Calendar.DAY_OF_YEAR, -1);
        assertThrows(IllegalArgumentException.class, () -> drone.remove(before, "Test reason"));
    }

    @Test
    void remove_whenAlreadyInactive_shouldThrowException() {
        Drone drone = new Drone("DRONE1101", droneModel, now, user);
        drone.remove(Calendar.getInstance(), "Test reason");

        assertThrows(IllegalStateException.class, () -> drone.remove(Calendar.getInstance(), "Test reason"));
    }

    @Test
    void activate_shouldChangeActiveStatusToTrue() {
        Drone drone = new Drone("DRONE1101", droneModel, now, user);
        drone.remove(Calendar.getInstance(), "Test reason");
        assertFalse(drone.isActive());
        drone.activate();
        assertTrue(drone.isActive());
        assertNull(drone.deactivatedOn());
    }

    @Test
    void remove_shouldStoreRemoveReasonCorrectly() {
        Drone drone = new Drone("DRONE1101", droneModel, now, user);
        Calendar removalDate = Calendar.getInstance();
        String reason = "Test removal reason";
        drone.remove(removalDate, reason);

        String toString = drone.toString();
        assertTrue(toString.contains(reason));
    }

}