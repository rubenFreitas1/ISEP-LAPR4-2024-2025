package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.showRequestManagement.application.RegisterShowRequestController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterShowRequestUI extends AbstractUI {
    private final RegisterShowRequestController controller = new RegisterShowRequestController();
    @Override
    protected boolean doShow() {
        final Iterable<Customer> customers = this.controller.customers();
        final SelectWidget<Customer> selectWidget = new SelectWidget<>("Select a Customer", customers, new CustomerPrinter());
        selectWidget.show();
        final Customer customer = selectWidget.selectedElement();
        System.out.println("\n");

        String location = requestLocation();
        Calendar date = requestDate();
        int droneNumber = requestDroneNumber();
        int duration = requestDuration();


        return false;
    }

    @Override
    public String headline() {
        return "";
    }

    private String requestLocation() {
        String location;
        do {
            location = Console.readLine("Enter the show location:");
            if (location.trim().isEmpty() || location.matches("\\d+")) {
                System.out.println("Invalid location. It cannot be empty or consist only of numbers. Please enter a valid location.");
            }
        } while (location.trim().isEmpty() || location.matches("\\d+"));
        return location;
    }
    private Calendar requestDate() {
        Calendar date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while (date == null) {
            String dateInput = Console.readLine("Enter the show date (yyyy-MM-dd):");
            try {
                Date parsedDate = sdf.parse(dateInput);
                date = Calendar.getInstance();
                date.setTime(parsedDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        return date;
    }
    private int requestDroneNumber() {
        int droneNumber = -1;
        while (droneNumber <= 0) {
            try {
                droneNumber = Integer.parseInt(Console.readLine("Enter number of drones:"));
                if (droneNumber <= 0) {
                    System.out.println("The number must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
        return droneNumber;
    }

    private int requestDuration() {
        int duration = -1;
        while (duration <= 0) {
            try {
                duration = Integer.parseInt(Console.readLine("Enter duration (in minutes):"));
                if (duration <= 0) {
                    System.out.println("Duration must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
        return duration;
    }
}
