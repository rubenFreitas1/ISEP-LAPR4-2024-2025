package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.base.figureCategoryManagement.application.AddFigureCategoryController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddFigureCategoryUI extends AbstractUI {

    private final AddFigureCategoryController controller = new AddFigureCategoryController();

    @Override
    protected boolean doShow() {
        final String categoryName = requestCategoryName();
        final String categoryDescription = requestDescription();

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

    private String requestCategoryName() {
        String categoryName;
        do {
            categoryName = Console.readLine("Enter the Category Name:");
            if (categoryName.trim().isEmpty()) {
                System.out.println("Category Name cannot be empty. Please enter a valid name.");
            }
        } while (categoryName.trim().isEmpty());
        return categoryName;
    }

    private String requestDescription() {
        String description;
        do {
            description = Console.readLine("Enter the description:");
            if (description.trim().isEmpty()) {
                System.out.println("Description cannot be empty. Please enter a valid description.");
            }
        } while (description.trim().isEmpty());
        return description;
    }


}
