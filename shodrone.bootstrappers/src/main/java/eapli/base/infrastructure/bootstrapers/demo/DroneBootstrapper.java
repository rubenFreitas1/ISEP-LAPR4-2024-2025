package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.droneManagement.application.AddDroneController;
import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class DroneBootstrapper implements Action {


    private static final Logger LOGGER = LoggerFactory.getLogger(
            DroneBootstrapper.class);

    private final AddDroneController addDroneController = new AddDroneController();

    private final DroneModelRepository droneModelRepository = PersistenceContext.repositories().droneModels();

    @Override
    public boolean execute() {
        Optional<DroneModel> dM1 = droneModelRepository.findById(1L);
        Optional<DroneModel> dM2 = droneModelRepository.findById(2L);
        Optional<DroneModel> dM3 = droneModelRepository.findById(3L);
        DroneModel droneModel = dM1.orElseThrow(() -> new IllegalArgumentException("DroneModel with ID 1 not found"));
        DroneModel droneModel2 = dM2.orElseThrow(() -> new IllegalArgumentException("DroneModel with ID 2 not found"));
        DroneModel droneModel3 = dM3.orElseThrow(() -> new IllegalArgumentException("DroneModel with ID 3 not found"));
        addDrone("DJI123456", droneModel);
        addDrone("Yuneec123456", droneModel2);
        addDrone("Autel123456", droneModel3);
        return true;
    }


    private Drone addDrone(final String serialNumber, final DroneModel droneModel) {
        Drone drone = null;
        try {
            drone = addDroneController.addDrone(serialNumber, droneModel);
        } catch (final Exception e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", serialNumber);
            LOGGER.trace("Assuming existing record", e);
        }
        return drone;
    }
}
