package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.base.app.backoffice.presentation.figureCategoryManagement.FigureCategoryPrinter;
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

        final SelectWidget<FigureCategory> selector = new SelectWidget<>("Select Figure Category", iterable, new FigureCategoryPrinter());
        System.out.printf("%-30s%-30s%-30s%n", "Name", "Description", "Status");
        selector.show();

        final FigureCategory figureCategory = selector.selectedElement();
        if (figureCategory == null) {
            System.out.println("No Figure Category Selected!\n");
            return false;
        }

        final String exclusiveInput = Console.readLine("Is this Figure exclusive to a customer? (yes/no):").trim().toLowerCase();
        final boolean exclusive = exclusiveInput.equals("yes");

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
            controller.addFigure(description, keywords, figureCategory, exclusive);
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
}
