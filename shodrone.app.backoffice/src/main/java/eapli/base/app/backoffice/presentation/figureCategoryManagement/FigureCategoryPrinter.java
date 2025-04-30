package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.visitor.Visitor;

public class FigureCategoryPrinter implements Visitor<FigureCategory> {
    @Override
    public void visit(FigureCategory visitee) {
        System.out.printf("%-30s%-30s%-30s", visitee.name(), visitee.description(), visitee.isActive() ? "Active" : "Inactive");
    }
}
