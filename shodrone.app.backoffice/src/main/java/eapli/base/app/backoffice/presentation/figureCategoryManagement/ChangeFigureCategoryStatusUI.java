package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.base.figureCategoryManagement.application.ChangeFigureCategoryStatusController;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;

public class ChangeFigureCategoryStatusUI extends AbstractUI{

    private final ChangeFigureCategoryStatusController theController = new ChangeFigureCategoryStatusController();

    @Override
    public String headline() {
        return "Change Figure Category Status";
    }

    protected String listHeader() {
        return String.format(" #  %-30s%-30s%-30s%-30s%-30s", "NAME", "DESCRIPTION", "STATUS", "CREATED ON", "CHANGED ON");
    }

    protected String emptyMessage() {
        return "No figure categories found";
    }

    protected String elementName() {
        return "Figure Category";
    }

    protected Iterable<FigureCategory> elements() {
        return this.theController.allFigureCategories();
    }


    protected Visitor<FigureCategory> elementPrinter() {
        return new FigureCategoryPrinter();
    }


    @Override
    protected boolean doShow() {
        final Iterable<FigureCategory> figureCategories = elements();
        if (!figureCategories.iterator().hasNext()) {
            System.out.println("There are no registered Figure Categories in the system");
        } else {
            final SelectWidget<FigureCategory> selector = new SelectWidget<>(listHeader(), figureCategories, elementPrinter());
            selector.show();
            final FigureCategory figureCategory = selector.selectedElement();
            if (figureCategory == null) {
                System.out.println("No figure category selected");
            } else {
                this.theController.changeFigureCategoryStatus(figureCategory, !figureCategory.isActive());
                System.out.println("Figure Category status changed successfully");
            }
        }
        return true;
    }

}
