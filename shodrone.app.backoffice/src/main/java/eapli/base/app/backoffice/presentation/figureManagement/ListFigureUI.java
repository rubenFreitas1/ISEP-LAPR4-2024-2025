package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.base.figureManagement.application.ListFigureController;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListFigureUI extends AbstractListUI<Figure> {
    private final ListFigureController controller = new ListFigureController();

    @Override
    protected Iterable<Figure> elements() {
        return controller.listPublicFigures();
    }

    @Override
    protected Visitor<Figure> elementPrinter() {
        return new FigurePrinter();
    }

    @Override
    protected String elementName() {
        return "Figure";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-30s%-30s%-30s", "DESCRIPTION", "CATEGORY", "ACTIVE", "EXCLUSIVE");
    }

    @Override
    protected String emptyMessage() {
        return "There no public figures!";
    }

    @Override
    public String headline() {
        return "List Public Figures";
    }
}
