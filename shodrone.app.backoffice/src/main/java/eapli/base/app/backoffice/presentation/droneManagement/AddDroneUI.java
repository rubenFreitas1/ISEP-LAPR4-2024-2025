package eapli.base.app.backoffice.presentation.droneManagement;

import eapli.base.app.backoffice.presentation.droneModelManagement.DroneModelPrinter;
import eapli.base.droneManagement.application.AddDroneController;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class AddDroneUI extends AbstractUI {

    private final AddDroneController controller = new AddDroneController();
    @Override
    protected boolean doShow() {
        final String serialNumber = Console.readLine("Serial Number");
        final Iterable<DroneModel> iterable = controller.listDroneModels();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered Drone Models!");
        } else {
            final SelectWidget<DroneModel> selector = new SelectWidget<>("Select Drone Model", iterable, new DroneModelPrinter());
            System.out.printf("%-30s%-30s%-30s%-30s", "Model Name", "Manufacturer", "Status", "Created By");
            selector.show();
            final DroneModel droneModel = selector.selectedElement();
            if(droneModel == null){
                System.out.println("No Drone Model Selected!\n");
            }else{
                try{
                    this.controller.addDrone(serialNumber, droneModel);
                } catch(IllegalArgumentException e){
                    System.out.println("\nERROR: " + e.getMessage() + "\n");
                }
            }

        }
        return true;
    }

    @Override
    public String headline() {
        return "Add Drone";
    }
}
