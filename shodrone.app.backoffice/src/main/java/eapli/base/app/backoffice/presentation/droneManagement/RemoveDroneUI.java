package eapli.base.app.backoffice.presentation.droneManagement;


import eapli.base.droneManagement.application.RemoveDroneController;
import eapli.base.droneManagement.domain.Drone;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class RemoveDroneUI extends AbstractUI {

    private final RemoveDroneController controller = new RemoveDroneController();

    @Override
    protected boolean doShow() {
        final Iterable<Drone> drones = this.controller.activeDrones();
        if (!drones.iterator().hasNext()) {
            System.out.println("There are no registered Drones");
        } else {
            final SelectWidget<Drone> selector = new SelectWidget<>("Select Drone to Remove", drones, new DronePrinter());
            selector.show();
            final Drone drone = selector.selectedElement();
            if (drone == null) {
                System.out.println("No drone selected");
            } else {
                final String reason = Console.readLine("Reason for removing the drone: ");
                if (reason.isEmpty()) {
                    System.out.println("Reason cannot be empty");
                }else {
                    this.controller.removeDrone(drone, reason);
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Remove Drone";
    }


}
