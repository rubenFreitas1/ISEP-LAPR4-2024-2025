package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.app.backoffice.presentation.figureManagement.FigurePrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showRequestManagement.application.RegisterShowRequestController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegisterShowRequestUI extends AbstractUI {
    private final RegisterShowRequestController controller = new RegisterShowRequestController();
    @Override
    protected boolean doShow() {
        final Iterable<Customer> customers = this.controller.customers();
        final SelectWidget<Customer> selectWidgetCustomer = new SelectWidget<>("Select a Customer", customers, new CustomerPrinter());
        selectWidgetCustomer.show();
        final Customer customer = selectWidgetCustomer.selectedElement();
        System.out.println("\n");

        String location = requestLocation();
        Calendar date = requestDate();
        int droneNumber = requestDroneNumber();
        int duration = requestDuration();

        boolean inputAnswer = true;
        while (inputAnswer) {
            final Iterable<Figure> figures = this.controller.figures();
            final SelectWidget<Figure> selectWidgetFigure = new SelectWidget<>("Public figures", figures, new FigurePrinter());
            selectWidgetFigure.show();

            inputAnswer = verifyAddFigure();
            if (inputAnswer) {

            }
        }
        List<Figure> figureSequence = new ArrayList<>();
        final Iterable<Figure> figures = this.controller.figures();
        final SelectWidget<Figure> selectWidgetFigure = new SelectWidget<>("Public figures (Enter 0 to finish)", figures, new FigurePrinter());
        System.out.println("Select the following figures in the pretended sequence.");
        boolean addingFigures = true;
        while (addingFigures) {
            selectWidgetFigure.show();
            Figure selected = selectWidgetFigure.selectedElement();

            if (selected == null) {
                addingFigures = false;
            } else {
                figureSequence.add(selected);
                System.out.println("Figure added to sequence: " + selected.description());
            }
            for (Figure figure : figureSequence) {
                System.out.printf("%-20s", figure.description());
            }
            System.out.println("\n");
        }
        try {
            controller.registerShowRequest(customer, location, date, duration, droneNumber, figureSequence);
            System.out.println("Show Request successfully registered!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }

        return true;
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
    private boolean verifyAddFigure() {
        String newFigureInput;
        boolean inputAnswer;

        do {
            newFigureInput = Console.readLine("Do you wish to add another figure? (yes/no):").trim().toLowerCase();
            if (newFigureInput.isEmpty() || (!newFigureInput.equals("yes") && !newFigureInput.equals("no"))) {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }
        } while (newFigureInput.isEmpty() || (!newFigureInput.equals("yes") && !newFigureInput.equals("no")));

        inputAnswer = newFigureInput.equals("yes");
        return inputAnswer;
    }
}
