package eapli.base.app.backoffice.presentation.droneManagement;

import eapli.base.app.backoffice.presentation.droneModelManagement.DroneModelPrinter;
import eapli.base.droneManagement.application.ListActiveDronesController;
import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

public class ListActiveDronesUI extends AbstractUI {

    private final ListActiveDronesController controller = new ListActiveDronesController();


    @Override
    public String headline() {
        return "List Active Drones";
    }

    @Override
    protected boolean doShow() {
        final Iterable<DroneModel> droneModels = this.controller.activeDroneModel();
        if (!droneModels.iterator().hasNext()) {
            System.out.println("There are no registered Drone Models in the system");
        } else {
            String headerModel = String.format("List of Active Drone Models\n#  %-30s%-30s%-30s%-30s", "MODEL NAME", "MANUFACTURER", "STATUS", "CREATED BY");
            final SelectWidget<DroneModel> selector = new SelectWidget<>(headerModel, droneModels, new DroneModelPrinter());
            selector.show();
            final DroneModel droneModel = selector.selectedElement();
            if (droneModel == null) {
                System.out.println("No drone Model selected");
            } else {
                final Iterable<Drone> drones = this.controller.findByDroneModel(droneModel);
                if(!drones.iterator().hasNext()) {
                    System.out.println("There are no registered Drones in the system");
                } else {
                    String headerDrone = String.format("List of Active Drones\n#  %-30s%-30s%-30s%-30s", "SERIAL NUMBER", "MODEL NAME", "STATUS", "CREATED BY");
                    final ListWidget<Drone> listWidget = new ListWidget<>(headerDrone, drones, new DronePrinter());
                    listWidget.show();
                }
            }
        }
        return true;
    }

}
