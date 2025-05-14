package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.droneModelManagement.application.AddDroneModelController;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroneModelBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            DroneModelBootstrapper.class);

    private final AddDroneModelController addDroneModelController = new AddDroneModelController();

    @Override
    public boolean execute() {
        addDroneModel("DJI Mavic 2 Pro", "DJI");
        addDroneModel("Yuneec Typhoon H", "Yuneec");
        addDroneModel("Autel Robotics EVO Lite", "Autel Robotics");
        return true;
    }

    private DroneModel addDroneModel(final String modelName, final String manufacturer){
        DroneModel droneModel = null;
        DroneWindBehavior windBehavior = new DroneWindBehavior();
        windBehavior.addTolerance(Axis.X, 0.0, 10.0, 0.3);
        windBehavior.addTolerance(Axis.X, 10.1, 20.0, 0.6);
        windBehavior.addTolerance(Axis.Y, 0.0, 10.0, 0.3);
        windBehavior.addTolerance(Axis.Y, 10.1, 20.0, 0.6);
        windBehavior.addTolerance(Axis.Z, 0.0, 10.0, 0.3);
        windBehavior.addTolerance(Axis.Z, 10.1, 20.0, 0.6);
        try {
            droneModel = addDroneModelController.addDroneModel(modelName, manufacturer, windBehavior);
        } catch (final Exception e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", modelName);
            LOGGER.trace("Assuming existing record", e);
        }
        return droneModel;
    }
}
