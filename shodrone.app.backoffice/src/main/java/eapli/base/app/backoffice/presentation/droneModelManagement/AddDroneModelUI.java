package eapli.base.app.backoffice.presentation.droneModelManagement;

import eapli.base.droneModelManagement.application.AddDroneModelController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddDroneModelUI extends AbstractUI {

    private final AddDroneModelController theController = new AddDroneModelController();

    @Override
    protected boolean doShow() {
        final String modelName = Console.readLine("Model Name");
        final String manufacturer = Console.readLine("Manufacturer");

        try{
            this.theController.addDroneModel(modelName, manufacturer);
        } catch(IllegalArgumentException e){
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Add Drone Model";
    }
}
