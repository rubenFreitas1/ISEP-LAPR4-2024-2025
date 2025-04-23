package eapli.base.droneModelManagement.application;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneModelBuilder;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DroneModelManagementServiceTest {

    @Mock
    private DroneModelRepository repo;

    @InjectMocks
    private DroneModelManagementService service;

    PasswordPolicy policy = new ExemploPasswordPolicy();
    PasswordEncoder encoder = new PlainTextEncoder();

    private SystemUser user;

    @BeforeEach
    public void setup(){
        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles( Roles.ADMIN).build();
    }

    @Test
    public void registerNewDroneModel_success() {
        String name = "Falcon";
        String manufacturer = "DJI";



        when(repo.isDroneModelNameUsed(name)).thenReturn(false);
        when(repo.save(any(DroneModel.class))).thenAnswer(i -> i.getArguments()[0]);

        DroneModel model = service.registerNewDroneModel(name, manufacturer, user);

        Assertions.assertEquals(name, model.modelName());
        verify(repo).save(any(DroneModel.class));
    }

    @Test
    void registerNewDroneModel_duplicateName_throwsException() {
        String name = "Falcon";
        when(repo.isDroneModelNameUsed(name)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewDroneModel(name, "DJI", user)
        );
    }


    @Test
    void registerNewDroneModel_null_modelName_throwsException() {

        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewDroneModel(null, "DJI", user)
        );
    }

    @Test
    void registerNewDroneModel_null_manufacturer_throwsException() {
        String name = "Falcon";
        when(repo.isDroneModelNameUsed(name)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewDroneModel(name, null, user)
        );
    }

    @Test
    void registerNewDroneModel_null_user_throwsException() {
        String name = "Falcon";
        when(repo.isDroneModelNameUsed(name)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewDroneModel(name, "DJI", null)
        );
    }

    @Test
    void findAll_returnsAllDroneModels() {
        Iterable<DroneModel> expected = List.of(
                new DroneModelBuilder().withModelName("Falcon").withManufacturer("DJI").createdBy(user).createdOn(CurrentTimeCalendars.now()).build(),
                new DroneModelBuilder().withModelName("Eagle").withManufacturer("DJI").createdBy(user).createdOn(CurrentTimeCalendars.now()).build()
        );
        when(repo.findAll()).thenReturn(expected);

        Iterable<DroneModel> result = service.findAll();

        Assertions.assertIterableEquals(expected, result);
        verify(repo).findAll();
    }

    @Test
    void deactivateDroneModel_savesDeactivatedModel() {
        DroneModel model = new DroneModelBuilder().withModelName("Falcon").withManufacturer("DJI").createdBy(user).createdOn(CurrentTimeCalendars.now()).build();
        when(repo.save(model)).thenReturn(model);

        DroneModel result = service.deactivateDroneModel(model);

        Assertions.assertFalse(result.isActive());
        verify(repo).save(model);
    }

    @Test
    void activateDroneModel_savesActivatedModel() {
        DroneModel model = new DroneModelBuilder().withModelName("Falcon").withManufacturer("DJI").createdBy(user).createdOn(CurrentTimeCalendars.now()).build();
        model.deactivate(CurrentTimeCalendars.now());
        when(repo.save(model)).thenReturn(model);

        DroneModel result = service.activateDroneModel(model);

        Assertions.assertTrue(result.isActive());
        verify(repo).save(model);
    }

    @Test
    void findByManufacturer_returnsCorrectDroneModels() {
        String manufacturer = "DJI";
        Iterable<DroneModel> expected = List.of(
                new DroneModelBuilder().withModelName("Falcon").withManufacturer(manufacturer).createdBy(user).createdOn(CurrentTimeCalendars.now()).build(),
                new DroneModelBuilder().withModelName("Eagle").withManufacturer(manufacturer).createdBy(user).createdOn(CurrentTimeCalendars.now()).build()
        );
        when(repo.findByManufacturer(manufacturer)).thenReturn(expected);

        Iterable<DroneModel> result = service.findByManufacturer(manufacturer);

        Assertions.assertIterableEquals(expected, result);
    }

    @Test
    void findById_existingId_returnsDroneModel() {
        Long id = 150L;
        DroneModel expectedModel = new DroneModelBuilder()
                .withModelName("Falcon").withManufacturer("DJI").createdBy(user).createdOn(CurrentTimeCalendars.now()).build();
        when(repo.findById(id)).thenReturn(Optional.of(expectedModel));

        Optional<DroneModel> result = service.findById(id);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(expectedModel, result.get());
    }

    @Test
    void findById_nonExistingId_returnsEmptyOptional() {
        Long id = 1L;
        when(repo.findById(id)).thenReturn(Optional.empty());

        Optional<DroneModel> result = service.findById(id);

        Assertions.assertTrue(result.isEmpty());
    }
}