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
        final String modelName = requestModelName();
        final String manufacturer = requestManufacturer();
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
            if (tolerance <= 0){
                System.out.println("Tolerance cannot be negative!");
                continue;
            }
            boolean success = windBehavior.addTolerance(axis, min, max, tolerance);
            if (success) {
                System.out.println("Tolerance added successfully!");
                min = max + 0.0001;
                addedAtLeastOne = true;
            } else {
                System.out.println("Tolerance not added!");
            }
        }
        System.out.println("Finished adding tolerances for axis " + axis + ".");
    }



    private String requestModelName() {
        String modelName;
        do {
            modelName = Console.readLine("Enter the Model Name:");
            if (modelName.trim().isEmpty()) {
                System.out.println("Model Name cannot be empty. Please enter a valid name.");
            }
        } while (modelName.trim().isEmpty());
        return modelName;
    }

    private String requestManufacturer() {
        String manufacturer;
        do {
            manufacturer = Console.readLine("Enter the Manufacturer:");
            if (manufacturer.trim().isEmpty()) {
                System.out.println("Manufacturer cannot be empty. Please enter a valid manufacturer.");
            }
        } while (manufacturer.trim().isEmpty());
        return manufacturer;
    }

}
