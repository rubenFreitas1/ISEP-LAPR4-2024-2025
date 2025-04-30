package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.base.figureManagement.domain.Figure;
import eapli.framework.visitor.Visitor;

public class FigurePrinter implements Visitor<Figure> {
    @Override
    public void visit(Figure visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.description(), visitee.figureCategory().name(), visitee.isActive() ? "Active" : "Inactive", visitee.isExclusive() ? "Exclusive" : "Non-exclusive");
    }
}
