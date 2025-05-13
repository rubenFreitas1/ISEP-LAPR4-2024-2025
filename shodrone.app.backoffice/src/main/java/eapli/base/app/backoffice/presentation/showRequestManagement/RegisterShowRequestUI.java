package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.app.backoffice.presentation.figureCategoryManagement.FigureCategoryPrinter;
import eapli.base.app.backoffice.presentation.figureManagement.FigurePrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showRequestManagement.application.RegisterShowRequestController;
import eapli.base.showRequestManagement.domain.GenericSelector;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RegisterShowRequestUI extends AbstractUI {
    private final RegisterShowRequestController controller = new RegisterShowRequestController();
    @Override
    protected boolean doShow() {
        Customer customer = GenericSelector.selectItem(this.controller.listCustomers(), new CustomerPrinter(), "Select a Customer");

        String location = requestLocation();
        Calendar date = requestDate();
        int droneNumber = requestDroneNumber();
        int duration = requestDuration();
        Iterable<Figure> figures = this.controller.figures(customer);

        boolean inputAnswer = true;
        boolean start = true;
        while (inputAnswer) {
            System.out.println("\nCurrent list of available figures: ");
            for (Figure figure : figures) {
                System.out.println(figure.description());
            }
            System.out.print("\n");
            inputAnswer = verifyAddFigure(start);
            start = false;
            if (inputAnswer) {
                try {
                    FigureCategory figureCategory = requestCategory();
                    String description = requestDescription();
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
                    return false;
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
            location = Console.readLine("\nEnter the show location:");
            if (location.trim().isEmpty() || location.matches("\\d+")) {
                System.out.println("Invalid location. It cannot be empty or consist only of numbers. Please enter a valid location.");
            }
        } while (location.trim().isEmpty() || location.matches("\\d+"));
        return location;
    }
    private Calendar requestDate() {
        Calendar date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Calendar currentDate = Calendar.getInstance();

        String dateRegex = "\\d{4}-\\d{2}-\\d{2}";

        while (date == null) {
            String dateInput = Console.readLine("\nEnter the show date (yyyy-MM-dd):");

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
                droneNumber = Integer.parseInt(Console.readLine("\nEnter number of drones:"));
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
                duration = Integer.parseInt(Console.readLine("\nEnter duration (in minutes):"));
                if (duration <= 0) {
                    System.out.println("Duration must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return duration;
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
    private Set<String> requestListKeywords() {
        Set<String> keywords = requestKeyWords();

        while (keywords.isEmpty()) {
            System.out.println("No keywords added. Please enter at least one keyword.");
            keywords = requestKeyWords();
        }
        return keywords;
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
    private String requestDescription() {
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
