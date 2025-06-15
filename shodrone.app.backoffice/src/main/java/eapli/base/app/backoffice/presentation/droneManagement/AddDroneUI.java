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
        final String serialNumber = requestSerialNumber();
        final Iterable<DroneModel> iterable = controller.listDroneModels();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered Drone Models!");
        } else {
            String headerModel = String.format("Select Drone Model\n#  %-30s%-30s%-30s%-30s", "MODEL NAME", "MANUFACTURER", "STATUS", "CREATED BY");
            final SelectWidget<DroneModel> selector = new SelectWidget<>(headerModel, iterable, new DroneModelPrinter());
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

    private String requestSerialNumber() {
        String serialNumber;
        do {
            serialNumber = Console.readLine("Enter the Serial Number:");
            if (serialNumber.trim().isEmpty()) {
                System.out.println("Serial Number cannot be empty. Please enter a serial number.");
            }
        } while (serialNumber.trim().isEmpty());
        return serialNumber;
    }

    @Override
    public String headline() {
        return "Add Drone";
    }
}
