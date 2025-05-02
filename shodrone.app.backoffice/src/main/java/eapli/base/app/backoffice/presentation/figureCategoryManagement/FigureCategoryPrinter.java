package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.visitor.Visitor;

import java.text.SimpleDateFormat;

public class FigureCategoryPrinter implements Visitor<FigureCategory> {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public void visit(FigureCategory visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s%-30s", visitee.name(), visitee.description(), visitee.isActive() ? "Active" : "Inactive", visitee.createdOn() != null ? sdf.format(visitee.createdOn().getTime()) : "N/A", visitee.changedOn() != null ? sdf.format(visitee.changedOn().getTime()) : "N/A");
    }
}
