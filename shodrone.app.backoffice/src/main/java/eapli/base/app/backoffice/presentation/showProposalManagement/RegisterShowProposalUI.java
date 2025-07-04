package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerDTOPrinter;
import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.app.backoffice.presentation.showRequestManagement.ShowRequestDTOPrinter;
import eapli.base.app.backoffice.presentation.showRequestManagement.ShowRequestPrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.base.showProposalManagement.application.RegisterShowProposalController;
import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.dto.ShowRequestDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegisterShowProposalUI extends AbstractUI {
    private final RegisterShowProposalController controller = new RegisterShowProposalController();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected boolean doShow() {
        Iterable<CustomerDTO> customers = controller.listCustomers();
        if (!customers.iterator().hasNext()) {
            System.out.println("\nThere are no registered Customers in the system!\n");
            return false;
        }
        ShowRequestDTO showRequest = null;
        String headerModelCustomer = String.format("Select Customer\n#  %-30s%-30s%-30s%-30s", "NAME", "STATUS", "PHONE NUMBER", "EMAIL");
        String headerModelRequest = String.format("\nSelect a Show Requests\n#  %-80s%-30s%-30s%-30s%-30s", "LOCATION", "DATE", "NUMBER OF DRONES", "DURATION", "CUSTOMER");
        boolean validRequestSelected = false;
        while (!validRequestSelected) {
            final SelectWidget<CustomerDTO> selectWidgetCustomer = new SelectWidget<>(headerModelCustomer, customers, new CustomerDTOPrinter());
            selectWidgetCustomer.show();
            CustomerDTO customer = selectWidgetCustomer.selectedElement();

            if (customer == null) {
                return true;
            }
            Iterable<ShowRequestDTO> showRequests = this.controller.listShowRequests(customer);
            if (!showRequests.iterator().hasNext()) {
                System.out.println("\nThere are no registered Show Requests associated with this Customer!\n");
                continue;
            }
            while (true) {
                final SelectWidget<ShowRequestDTO> selectWidgetRequest = new SelectWidget<>(headerModelRequest, showRequests, new ShowRequestDTOPrinter());
                selectWidgetRequest.show();
                showRequest = selectWidgetRequest.selectedElement();

                if (showRequest == null) {
                    break;
                }
                boolean exits = false;

                if (!exits) {
                    validRequestSelected = true;
                    break;
                }
            }
        }
        Iterable<Template> templates = controller.listTemplates();
        List<Template> list = new ArrayList<>();
        templates.forEach(list::add);
        if (list.isEmpty()) {
            System.out.println("No templates available!");
            return false;
        }
        Template template = requestTemplate(list);
        GeoLocation location = showRequest.getLocation();
        Calendar date = showRequest.getDate();
        int duration = showRequest.getDuration();
        int droneNumber = showRequest.getDroneNumber();
        String input;
        while (true) {
            menuAttributes(location, date, duration, droneNumber);
            menuSelection();
            while (true) {
                input = Console.readLine("Enter your choice: ");
                if (!input.matches("[0-4]")) {
                    System.out.println("Invalid option. Please enter a number between 0 and 4.");
                    continue;
                }
                int choice = Integer.parseInt(input);

                if (choice == 0) {
                    break;
                }
                switch (choice) {
                    case 1:
                        System.out.println("\nShow Proposal Location");
                        location = requestLocation();
                        break;
                    case 2:
                        System.out.println("\nShow Proposal Date");
                        date = requestDate();
                        break;
                    case 3:
                        System.out.println("\nShow Proposal Duration");
                        duration = requestDuration();
                        break;
                    case 4:
                        System.out.println("\nShow Proposal Total Drone Number");
                        droneNumber = requestTotalDroneNumber();
                        break;
                }
                break;
            }
            if (input.matches("0")) {
                break;
            }
        }
        LocalTime time = requestTime();
        double insurance = requestInsurance();

        try {
            controller.registerShowProposal(showRequest, location, date, time, duration, droneNumber, template, insurance);
            System.out.println("Show Proposal successfully registered!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }

    @Override
    public String headline() {
        return "";
    }

    private void menuAttributes(GeoLocation location, Calendar date, int duration, int droneNumber) {
        System.out.println("\nCurrent Show Proposal attributes:");
        System.out.printf("GeoLocation: %s\n", location);
        System.out.printf("Date: %s\n", date != null ? sdf.format(date.getTime()) : "N/A");
        System.out.printf("Duration: %s\n", duration);
        System.out.printf("Drone Number: %s\n", droneNumber);
    }
    private void menuSelection() {
        System.out.println("\nSelect the attribute you which to edit.");
        System.out.println("1. GeoLocation");
        System.out.println("2. Date");
        System.out.println("3. Duration");
        System.out.println("4. Drone Number");
        System.out.println("0. Exit");
    }
    private GeoLocation requestLocation() {
        double latitude = 0;
        double longitude = 0;
        boolean valid = false;

        do {
            try {
                String latStr = Console.readLine("\nEnter the latitude (-90 to 90):");
                latitude = Double.parseDouble(latStr);
                if (latitude < -90 || latitude > 90) {
                    System.out.println("Latitude must be between -90 and 90.");
                    continue;
                }

                String lonStr = Console.readLine("Enter the longitude (-180 to 180):");
                longitude = Double.parseDouble(lonStr);
                if (longitude < -180 || longitude > 180) {
                    System.out.println("Longitude must be between -180 and 180.");
                    continue;
                }

                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values for latitude and longitude.");
            }
        } while (!valid);

        int altitude = requestAltitude();
        return new GeoLocation(latitude, longitude, altitude);
    }
    private int requestAltitude() {
        int altitude = 0;
        boolean valid = false;

        do {
            try {
                String input = Console.readLine("Enter the altitude (in meters, positive number):");
                altitude = Integer.parseInt(input);
                if (altitude <= 0) {
                    System.out.println("Altitude must be a positive number.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!valid);

        return altitude;
    }
    private Calendar requestDate() {
        Calendar date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Calendar currentDate = Calendar.getInstance();

        String dateRegex = "\\d{4}-\\d{2}-\\d{2}";

        while (date == null) {
            String dateInput = Console.readLine("Enter the show date (yyyy-MM-dd):");

            if (!dateInput.matches(dateRegex)) {
                System.out.println("Invalid date. Please ensure the date is real and follows the format yyyy-MM-dd.");
                continue;
            }

            try {
                Date parsedDate = sdf.parse(dateInput);
                Calendar enteredDate = Calendar.getInstance();
                enteredDate.setTime(parsedDate);

                if (enteredDate.before(currentDate)) {
                    System.out.println("The entered date is in the past. Please enter a future date.");
                } else {
                    date = enteredDate;
                }

            } catch (ParseException e) {
                System.out.println("Invalid date. Please ensure the date is real and follows the format yyyy-MM-dd.");
            }
        }
        return date;
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
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return duration;
    }
    private int requestTotalDroneNumber() {
        int droneNumber = -1;
        while (droneNumber <= 0) {
            try {
                droneNumber = Integer.parseInt(Console.readLine("Enter total number of drones:"));
                if (droneNumber <= 0) {
                    System.out.println("The number must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return droneNumber;
    }

    private double requestInsurance(){
        double insurance = -1;
        while(insurance <= 0){
            try{
                insurance = Console.readDouble("Enter Insurance Amount:");
                if(insurance <= 0){
                    System.out.println("The number must be greater than 0.");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid double.");

            }
        }
        return insurance;
    }

    private LocalTime requestTime() {
        LocalTime eventTime = null;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        while (eventTime == null) {
            String input = Console.readLine("Enter the event time (HH:mm): ").trim();

            if (input == null || input.isEmpty()) {
                System.out.println("Time input cannot be empty.");
                continue;
            }

            try {
                eventTime = LocalTime.parse(input, timeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use HH:mm (e.g., 18:30).");
            }
        }
        return eventTime;
    }

    private Template requestTemplate(List<Template> list) {
        int i = 0;
        while (true) {
            Template current = list.get(i);
            System.out.printf("%nTemplate %d of %d:%n%s%n", i + 1, list.size(), current);

            String cmd = Console.readLine("[y] choose  [n] next  [p] previous : ").trim().toLowerCase();

            switch (cmd) {
                case "y": case "yes":
                    return current;
                case "n": case "next":
                    if (i < list.size() - 1) {
                        i++;
                    } else {
                        System.out.println("No more templates. You are at the last one.");
                    }
                    break;
                case "p": case "prev": case "previous":
                    if (i > 0) {
                        i--;
                    } else {
                        System.out.println("No previous templates. You are at the first one.");
                    }
                    break;
                default:
                    System.out.println("Unknown option, try again.");
            }
        }
    }
}
