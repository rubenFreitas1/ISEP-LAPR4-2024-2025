package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.base.app.backoffice.presentation.figureCategoryManagement.FigureCategoryPrinter;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.application.SearchFigureController;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;

import java.util.Scanner;

public class SearchFigureUI extends AbstractListUI<Figure> {
    private final SearchFigureController controller = new SearchFigureController();
    @Override
    protected Iterable<Figure> elements() {
        controller.ensureAuthenticatedUser();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
                System.out.print("\n");
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter keyword: ");
                String keyword = scanner.nextLine();
                return controller.findFiguresByKeyword(keyword);

            } else if (choice == 2) {
                final Iterable<FigureCategory> figuresCategories = this.controller.figuresCategories();
                final SelectWidget<FigureCategory> selectWidget = new SelectWidget<>("Select a Figure Category", figuresCategories, new FigureCategoryPrinter());
                selectWidget.show();
                final FigureCategory category = selectWidget.selectedElement();
                System.out.println("\n");
                return controller.findFiguresByCategory(category);

            } else if (choice == 3) {
                System.out.print("Enter keyword: ");
                String keyword = scanner.nextLine();
                System.out.print("\n");
                final Iterable<FigureCategory> figuresCategories = this.controller.figuresCategories();
                final SelectWidget<FigureCategory> selectWidget = new SelectWidget<>("Select a Figure Category", figuresCategories, new FigureCategoryPrinter());
                selectWidget.show();
                final FigureCategory category = selectWidget.selectedElement();
                System.out.print("\n");
                return controller.findFiguresByKeywordAndCategory(keyword, category);

            } else {
                System.out.println("Invalid option. Please choose a valid menu number.\n");
            }
        }
    }

    @Override
    protected Visitor<Figure> elementPrinter() {
        return new FigurePrinter();
    }

    @Override
    protected String elementName() {
        return "";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-30s%-30s%-30s", "DESCRIPTION", "CATEGORY", "ACTIVE", "EXCLUSIVE");
    }

    @Override
    protected String emptyMessage() {
        return "No figures found in the catalogue!";
    }

    @Override
    public String headline() {
        return "Search Figure Catalogue";
    }
    private void menu() {
        System.out.println("=============================================\n");
        System.out.println("Please select one of the following options:");
        System.out.println("1. Search figures by keyword");
        System.out.println("2. Search figures by category");
        System.out.println("3. Search figures by both keyword and category");
        System.out.println("\n=============================================");
        System.out.print("Select your option: ");
    }
}
