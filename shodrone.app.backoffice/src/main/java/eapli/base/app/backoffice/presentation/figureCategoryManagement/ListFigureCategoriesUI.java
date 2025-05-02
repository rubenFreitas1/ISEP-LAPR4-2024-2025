package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import eapli.base.figureCategoryManagement.application.ListFigureCategoryController;
public class ListFigureCategoriesUI extends AbstractListUI<FigureCategory> {

    private final ListFigureCategoryController theController = new ListFigureCategoryController();

    @Override
    protected Iterable<FigureCategory> elements() {
        return theController.allFigureCategories() ;
    }

    @Override
    protected Visitor elementPrinter() {
        return new FigureCategoryPrinter();
    }

    @Override
    protected String elementName() {
        return "Figure Category";
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
    public String headline() {
        return "List Figure Categories";
    }
}
