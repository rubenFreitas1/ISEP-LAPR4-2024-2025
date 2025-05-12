package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.base.figureCategoryManagement.application.EditFigureCategoryController;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;

public class EditFigureCategoryUI extends AbstractListUI<FigureCategory> {

    private final EditFigureCategoryController theController = new EditFigureCategoryController();
    @Override
    public String headline() {
        return "Edit Figure Category";
    }

    @Override
    protected String listHeader() {
        return String.format(" #  %-30s%-30s%-30s%-30s%-30s", "NAME", "DESCRIPTION", "STATUS", "CREATED ON", "CHANGED ON");
    }

    @Override
    protected String emptyMessage() {
        return "No figure categories found";
    }

    @Override
    protected String elementName() {
        return "Figure Category";
    }

    @Override
    protected Iterable<FigureCategory> elements() {
        return null;
    }

    @Override
    protected Visitor elementPrinter() {
        return new FigureCategoryPrinter();
    }

    @Override
    protected boolean doShow() {
        final Iterable<FigureCategory> figureCategories = this.theController.allActiveFigureCategories();
        if (!figureCategories.iterator().hasNext()) {
            System.out.println("There are no registered Figure Categories in the system");
        } else {
            final SelectWidget<FigureCategory> selector = new SelectWidget<>(listHeader(), figureCategories, elementPrinter());
            selector.show();
            final FigureCategory figureCategory = selector.selectedElement();
            if (figureCategory == null) {
                System.out.println("No figure category selected");
            } else {
                final String name = Console.readLine("Name: ");
                final String description = Console.readLine("Description: ");
                this.theController.editFigureCategory(figureCategory, name, description);
                System.out.println("Figure Category edited successfully");
                }
            }
        return true;
        }
}
