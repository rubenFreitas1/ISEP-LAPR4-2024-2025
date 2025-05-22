package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.app.backoffice.presentation.figureCategoryManagement.FigureCategoryPrinter;
import eapli.base.app.backoffice.presentation.figureManagement.FigurePrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showRequestManagement.application.EditShowRequestController;
import eapli.base.showRequestManagement.domain.GenericSelector;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EditShowRequestUI extends AbstractUI {
    private final EditShowRequestController controller = new EditShowRequestController();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected boolean doShow() {
        Iterable<Customer> customers = this.controller.listCustomers();
        if (!customers.iterator().hasNext()) {
            System.out.println("There are no registered Customers in the system!");
            return false;
        }
        String headerModel = String.format("Select Customer\n#  %-30s%-30s%-30s%-30s", "NAME", "STATUS", "PHONE NUMBER", "EMAIL");
        Customer customer = GenericSelector.selectItem(customers, new CustomerPrinter(), headerModel);

        Iterable<ShowRequest> showRequests = this.controller.listCustomerShowRequests(customer);
        if (!showRequests.iterator().hasNext()) {
            System.out.println("There are no registered Show Requests associated with this Customer!");
            return false;
        }

        headerModel = String.format("\nSelect a Show Requests\n#  %-30s%-30s%-30s%-30s%-30s", "LOCATION", "DATE", "NUMBER OF DRONES", "DURATION", "CUSTOMER");
        ShowRequest showRequest = GenericSelector.selectItem(showRequests, new ShowRequestPrinter(), headerModel);
        if (showRequest == null) {
            System.out.println("Show Request cannot be null!");
            return false;
        }
        while (true) {
            menuAttributes(showRequest);
            menuSelection();
            while (true) {
                String input = Console.readLine("Enter your choice: ");
                if (!input.matches("[0-7]")) {
                    System.out.println("Invalid option. Please enter a number between 0 and 7.");
                    continue;
                }
                int choice = Integer.parseInt(input);

                if (choice == 0) {
                    return true;
                }
                switch (choice) {
                    case 1:
                        System.out.println("\nSelect a Show Request Description");
                        String description = requestDescription();
                        showRequest = this.controller.editShowRequestDescription(showRequest, description);
                        break;
                    case 2:
                        System.out.println("\nEdit Show Request Location");
                        GeoLocation location = requestLocation();
                        showRequest = this.controller.editShowRequestLocation(showRequest, location);
                        break;
                    case 3:
                        System.out.println("\nEdit Show Request Altitude");
                        int altitude = requestAltitude();
                        showRequest = this.controller.editShowRequestAltitude(showRequest, altitude);
                        break;
                    case 4:
                        System.out.println("\nEdit Show Request Date");
                        Calendar date = requestDate();
                        showRequest = this.controller.editShowRequestDate(showRequest, date);
                        break;
                    case 5:
                        System.out.println("\nEdit Show Request Drone Number");
                        int droneNumber = requestDroneNumber();
                        showRequest = this.controller.editShowRequestDroneNumber(showRequest, droneNumber);
                        break;
                    case 6:
                        System.out.println("\nEdit Show Request Duration");
                        int duration = requestDuration();
                        showRequest = this.controller.editShowRequestDuration(showRequest, duration);
                        break;
                    case 7:
                        System.out.println("\nEdit Show Request Sequence of Figures");
                        List<Figure> sequenceFigures = requestSequenceOfFigures(customer);
                        showRequest = this.controller.editShowRequestSequenceOfFigures(showRequest, sequenceFigures);
                        break;
                }
                break;
            }
        }
    }

    @Override
    public String headline() {
        return "";
    }

    private void menuAttributes(ShowRequest showRequest) {
        System.out.println("\nCurrent Show Request attributes:");
        System.out.printf("Description: %s\n", showRequest.description());
        System.out.printf("Location: %s\n", showRequest.location());
        System.out.printf("Altitude: %d\n", showRequest.altitude());
        System.out.printf("Date: %s\n", showRequest.date()!= null ? sdf.format(showRequest.date().getTime()) : "N/A");
        System.out.printf("Drone Number: %s\n", showRequest.droneNumber());
        System.out.printf("Duration: %s\n", showRequest.duration());
        List<Figure> figureSequence = showRequest.requestedFigures();
        System.out.print("Sequence of figures :");
        for (int i = 0; i < figureSequence.size(); i++) {
            Figure figure = figureSequence.get(i);
            System.out.printf("%-20s", figure.description());
            if (i != figureSequence.size() - 1) {
                System.out.print(" / ");
            } else {
                System.out.print(".\n");
            }
        }
    }
    private void menuSelection() {
        System.out.println("\nSelect the attribute you which to edit.");
        System.out.println("1. Description");
        System.out.println("2. GeoLocation");
        System.out.println("3. Altitude");
        System.out.println("4. Date");
        System.out.println("5. Drone Number");
        System.out.println("6. Duration");
        System.out.println("7. Sequence of figures");
        System.out.println("0. Exit");
    }
    private String requestDescription() {
        String description;
        do {
            description = Console.readLine("Enter a description for the show:");
            if (description.trim().isEmpty()) {
                System.out.println("Description cannot be empty. Please enter a valid description.");
            }
        } while (description.trim().isEmpty());

        return description;
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

        return new GeoLocation(latitude, longitude);
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
    private int requestDroneNumber() {
        int droneNumber = -1;
        while (droneNumber <= 0) {
            try {
                droneNumber = Integer.parseInt(Console.readLine("Enter number of drones:"));
                if (droneNumber <= 0) {
                    System.out.println("The number must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
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
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return duration;
    }

    private List<Figure> requestSequenceOfFigures(Customer customer) {
        Iterable<Figure> figures = this.controller.figures(customer);
        boolean inputAnswer = true;
        boolean start = true;
        while (inputAnswer) {
            System.out.println("Current list of available figures: ");
            for (Figure figure : figures) {
                System.out.println(figure.description());
            }
            System.out.print("\n");
            inputAnswer = verifyAddFigure(start);
            start = false;
            if (inputAnswer) {
                try {
                    FigureCategory figureCategory = requestCategory();
                    String description = requestFigureDescription();
                    Set<String> keywords = requestListKeywords();
                    if(excluviseMenu()){
                        boolean exclusive = true;
                        controller.addFigure(description, keywords, figureCategory, exclusive, customer);
                    } else {
                        boolean exclusive = false;
                        controller.addFigure(description, keywords, figureCategory, exclusive, null);
                    }
                    figures = this.controller.figures(customer);

                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR: " + e.getMessage());
                    return null;
                }
            }
        }
        List<Figure> figureSequence = new ArrayList<>();
        List<Figure> availableFigures = new ArrayList<>();
        figures.forEach(availableFigures::add);
        final SelectWidget<Figure> selectWidgetFigure = new SelectWidget<>("Available figures (Enter 0 to finish)", availableFigures, new FigurePrinter());
        System.out.println("\nSelect the following figures in the pretended order.");
        while (true) {
            if (availableFigures.isEmpty()) {
                System.out.println("No more figures available to select.");
                break;
            }

            selectWidgetFigure.show();
            Figure selected = selectWidgetFigure.selectedElement();

            if (selected == null) {
                if (figureSequence.isEmpty()) {
                    System.out.println("You must select at least one figure before exiting.");
                    continue;
                } else {
                    break;
                }
            } else {
                figureSequence.add(selected);
                availableFigures.remove(selected);
            }

            System.out.print("Current sequence of figures: ");
            for (int i = 0; i < figureSequence.size(); i++) {
                Figure figure = figureSequence.get(i);
                System.out.printf("%-20s", figure.description());
                if (i != figureSequence.size() - 1) {
                    System.out.print(" / ");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("\n");
        }
        return figureSequence;
    }
    private boolean verifyAddFigure(boolean start) {
        String newFigureInput;
        boolean inputAnswer;

        do {
            if (start) {
                newFigureInput = Console.readLine("Do you wish to add a figure? (yes/no):").trim().toLowerCase();
            } else {
                newFigureInput = Console.readLine("Do you wish to add another figure? (yes/no):").trim().toLowerCase();
            }
            if (newFigureInput.isEmpty() || (!newFigureInput.equals("yes") && !newFigureInput.equals("no"))) {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }
        } while (newFigureInput.isEmpty() || (!newFigureInput.equals("yes") && !newFigureInput.equals("no")));

        inputAnswer = newFigureInput.equals("yes");
        return inputAnswer;
    }
    private boolean excluviseMenu(){
        System.out.println("Is this Figure exclusive to a customer?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int option = Console.readInteger("Select an option: ");
        switch (option) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Invalid option. Please try again.");
                excluviseMenu();
        }
        return false;
    }
    private Set<String> requestListKeywords() {
        Set<String> keywords = requestKeyWords();

        while (keywords.isEmpty()) {
            System.out.println("No keywords added. Please enter at least one keyword.");
            keywords = requestKeyWords();
        }
        return keywords;
    }
    private Set<String> requestKeyWords(){
        Set<String> keywords = new HashSet<>();
        System.out.println("\nInsert keywords:");
        boolean addMore = true;
        while (addMore) {
            String kw = Console.readLine("Enter a keyword:").trim();
            if (!kw.isEmpty()) {
                keywords.add(kw);
            } else {
                System.out.println("ERROR: Keyword cannot be empty. Please enter a valid keyword.");
            }

            String response = Console.readLine("Do you want to add another keyword? (yes/no):").trim().toLowerCase();
            addMore = response.equals("yes");
        }
        return keywords;
    }
    private FigureCategory requestCategory() {
        FigureCategory figureCategory;
        Iterable<FigureCategory> iterable = controller.listFigureCategories();

        if (!iterable.iterator().hasNext()) {
            throw new IllegalArgumentException("No figure categories available.");
        }
        String headerFigureCategoryModel = String.format("Select Figure Category\n#  %-30s%-30s%-30s%-30s%-30s", "NAME", "DESCRIPTION", "STATUS", "CREATED ON", "CHANGED ON");
        final SelectWidget<FigureCategory> selector = new SelectWidget<>(headerFigureCategoryModel, iterable, new FigureCategoryPrinter());
        selector.show();

        figureCategory = selector.selectedElement();
        while (figureCategory == null) {
            System.out.println("No figure category selected! Please select a valid category.");
            selector.show();
            figureCategory = selector.selectedElement();
        }
        return figureCategory;
    }
    private String requestFigureDescription() {
        String description = "";
        boolean validDescription = false;
        while (!validDescription) {
            description = Console.readLine("Enter figure description:").trim();
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty. Please enter a valid description.");
            } else {
                validDescription = true;
            }
        }
        return description;
    }
}
