package eapli.base.droneManagement.application;

import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.application.DroneModelManagementService;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DroneManagementServiceTest {

    @Mock
    private DroneRepository repo;

    @Mock
    private DroneModelRepository repoModel;

    @InjectMocks
    private DroneManagementService service;

    @InjectMocks
    private DroneModelManagementService serviceModel;

    PasswordPolicy policy = new ExemploPasswordPolicy();
    PasswordEncoder encoder = new PlainTextEncoder();

    private final Calendar now = Calendar.getInstance();

    private SystemUser user;

    private DroneModel droneModel;

    private DroneWindBehavior behavior;

    @BeforeEach
    public void setup(){
        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles( Roles.ADMIN).build();
        behavior = new DroneWindBehavior();
        behavior.addTolerance(Axis.X,0,10, 0.5);
        behavior.addTolerance(Axis.X,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Y,0,10, 0.5);
        behavior.addTolerance(Axis.Y,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Z,0,10, 0.5);
        behavior.addTolerance(Axis.Z,10.0001,20, 0.8);
        droneModel = new DroneModel("Falcon", "Amazon", now, user, behavior);
    }


    @Test
    public void registerNewDrone_success() {
        String serialNumber = "DRONE10001";

        when(repo.isSerialNameUsed(serialNumber)).thenReturn(false);
        when(repo.save(any(Drone.class))).thenAnswer(i -> i.getArguments()[0]);

        Drone drone = service.registerNewDrone(serialNumber, droneModel, user);

        Assertions.assertEquals(serialNumber, drone.serialNumber());
        verify(repo).save(any(Drone.class));
    }


    @Test
    void registerNewDrone_duplicateSerialNumber_throwsException() {
        String serialNumber = "DRONE10001";
        when(repo.isSerialNameUsed(serialNumber)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewDrone(serialNumber, droneModel, user)
        );
    }


    @Test
    void removeDrone_savesDeactivatedDrone() {
        Drone drone = new Drone("DRONE10001", droneModel, now, user);
        when(repo.save(drone)).thenReturn(drone);

        Drone result = service.removeDrone(drone, "Test reason");

        Assertions.assertFalse(result.isActive());
        verify(repo).save(drone);
    }

    @Test
    void activateDrone_savesActivatedDrone() {
        Drone drone = new Drone("DRONE10001", droneModel, now, user);
        drone.remove(CurrentTimeCalendars.now(), "Test reason");
        when(repo.save(drone)).thenReturn(drone);
        Drone result = service.activateDrone(drone);
        Assertions.assertTrue(result.isActive());
        verify(repo).save(drone);
    }

    @Test
    void findById_existingDrone_returnsDrone() {
        Drone drone = new Drone("DRONE20001", droneModel, now, user);
        when(repo.findById(1L)).thenReturn(Optional.of(drone));

        Optional<Drone> result = service.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(drone, result.get());
    }

    @Test
    void isSerialNumberUsed_trueAndFalse() {
        String usedSerial = "USED123";
        String unusedSerial = "NEW123";

        when(repo.isSerialNameUsed(usedSerial)).thenReturn(true);
        when(repo.isSerialNameUsed(unusedSerial)).thenReturn(false);

        assertTrue(service.isSerialNumberUsed(usedSerial));
        assertFalse(service.isSerialNumberUsed(unusedSerial));
    }

    @Test
    void removeDrone_setsCorrectDeactivationDate() {
        Drone drone = new Drone("DRONE10003", droneModel, now, user);
        service.removeDrone(drone, "Test reason");
        assertNotNull(drone.deactivatedOn());
    }

    @Test
    void activateDrone_ensureItsNull() {
        Drone drone = new Drone("DRONE10003", droneModel, now, user);
        assertNull(drone.deactivatedOn());
        service.removeDrone(drone, "Test reason");
        assertNotNull(drone.deactivatedOn());
        service.activateDrone(drone);
        assertNull(drone.deactivatedOn());
    }

    @Test
    void listActiveDroneModels_returnsOnlyActiveModels() {
        DroneModel active1 = new DroneModel("Alpha", "DJI", CurrentTimeCalendars.now(), user, behavior);
        DroneModel active2 = new DroneModel("Beta", "DJI", CurrentTimeCalendars.now(), user, behavior);

        when(repoModel.findByActive(true)).thenReturn((Iterable<DroneModel>) List.of(active1, active2));


        Iterable<DroneModel> result = serviceModel.listActiveDroneModels();

        Assertions.assertIterableEquals(List.of(active1, active2), result);
        verify(repoModel).findByActive(true);
    }


}