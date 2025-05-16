package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.base.figureCategoryManagement.application.AddFigureCategoryController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddFigureCategoryUI extends AbstractUI {

    private final AddFigureCategoryController controller = new AddFigureCategoryController();

    @Override
    protected boolean doShow() {
        final String categoryName = Console.readLine("Category Name: ");
        final String categoryDescription = Console.readLine("Description: ");

        try {
            this.controller.addFigureCategory(categoryName, categoryDescription);
            System.out.println("\nFigure Category added successfully!\n");
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Add Figure Category";
    }
}
