package eapli.base.app.backoffice.presentation.droneModelManagement;

import eapli.base.droneModelManagement.application.AddDroneModelController;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Scanner;

public class AddDroneModelUI extends AbstractUI {

    private final AddDroneModelController theController = new AddDroneModelController();


    @Override
    protected boolean doShow() {
        final String modelName = Console.readLine("Model Name");
        final String manufacturer = Console.readLine("Manufacturer");
        final DroneWindBehavior windBehavior = new DroneWindBehavior();
        for (Axis axis : Axis.values()) {
            requestWindBehavior(windBehavior, axis);
        }
        try{
            this.theController.addDroneModel(modelName, manufacturer, windBehavior);
        } catch(IllegalArgumentException e){
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Add Drone Model";
    }


    public void requestWindBehavior(DroneWindBehavior windBehavior, Axis axis) {
        double min = 0.0;
        boolean addedAtLeastOne = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Define tolerances for axis " + axis + " ---");

        while (true) {
            if (!addedAtLeastOne) {
                System.out.println("\nYou must add at least one tolerance.");
            }

            System.out.println("\nCurrent minimum wind speed: " + min + " m/s (fixed)");
            System.out.println("1 - Add a new tolerance");
            if (addedAtLeastOne) {
                System.out.println("2 - Finish adding tolerances for this axis");
            }

            System.out.print("Option: ");
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (option == 2 && addedAtLeastOne) {
                //windBehavior.addTolerance(axis,min, Double.MAX_VALUE,);
                break;
            }

            if (option != 1) {
                System.out.println("Invalid option!");
                continue;
            }

            double max = Console.readDouble("Maximum wind speed (m/s): ");
            if (max <= min) {
                System.out.println("Maximum wind speed must be greater than the current minimum!");
                continue;
            }

            double tolerance = Console.readDouble("Tolerance (meters): ");
            boolean success = windBehavior.addTolerance(axis, min, max, tolerance);
            if (success) {
                System.out.println("Tolerance added successfully!");
                min = max + 0.0001;
                addedAtLeastOne = true;
            } else {
                System.out.println("Tolerance not added. It might overlap with an existing interval!");
            }
        }
        System.out.println("Finished adding tolerances for axis " + axis + ".");
    }

}
