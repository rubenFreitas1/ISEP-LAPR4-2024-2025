package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.app.backoffice.presentation.figureCategoryManagement.FigureCategoryPrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.application.AddFigureController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.HashSet;
import java.util.Set;

public class AddFigureUI extends AbstractUI {

    private final AddFigureController controller = new AddFigureController();

    @Override
    protected boolean doShow() {
        final Iterable<FigureCategory> iterable = controller.listFigureCategories();

        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered Figure Categories!");
            return false;
        }
        String headerFigureCategoryModel = String.format("Select Figure Category\n#  %-30s%-30s%-30s%-30s%-30s", "NAME", "DESCRIPTION", "STATUS", "CREATED ON", "CHANGED ON");
        final SelectWidget<FigureCategory> selector = new SelectWidget<>(headerFigureCategoryModel, iterable, new FigureCategoryPrinter());
        selector.show();

        final FigureCategory figureCategory = selector.selectedElement();
        if (figureCategory == null) {
            System.out.println("No Figure Category Selected!\n");
            return false;
        }

        final String description = Console.readLine("Enter figure description:").trim();

        System.out.println("\nInsert keywords:");
        final Set<String> keywords = new HashSet<>();
        boolean addMore = true;

        while (addMore) {
            final String kw = Console.readLine("Enter a keyword:");
            if (!kw.trim().isEmpty()) {
                keywords.add(kw.trim());
            }else {
                System.out.println("Keyword cannot be empty. Please enter a valid keyword.");
            }

            final String response = Console.readLine("Do you want to add another keyword? (yes/no):").trim().toLowerCase();
            addMore = response.equals("yes");
        }

        if (keywords.isEmpty()) {
            System.out.println("No keywords added. Figure will not be added.");
            return false;
        }

        try {
            if(excluviseMenu()){
                boolean exclusive = true;
                String headerModel = String.format("List of Active Customers\n#  %-30s%-30s%-30s%-30s", "CUSTOMER NAME", "STATUS", "PHONE NUMBER", "EMAIL");
                SelectWidget<Customer> selectorCustomer = new SelectWidget<>(headerModel, controller.listCustomers(), new CustomerPrinter());
                selectorCustomer.show();
                Customer customer = selectorCustomer.selectedElement();
                if (customer == null) {
                    System.out.println("No Customer Selected!\n");
                    return false;
                }
                controller.addFigure(description, keywords, figureCategory, exclusive, customer);
            }else{
                boolean exclusive = false;
                controller.addFigure(description, keywords, figureCategory, exclusive, null);
            }
            System.out.println("Figure added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }


    @Override
    public String headline() {
        return "Add Figure";
    }


    public boolean excluviseMenu(){
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
}
