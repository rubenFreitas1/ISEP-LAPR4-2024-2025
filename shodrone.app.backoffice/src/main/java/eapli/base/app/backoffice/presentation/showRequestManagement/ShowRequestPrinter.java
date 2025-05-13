package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.visitor.Visitor;

import java.text.SimpleDateFormat;

public class ShowRequestPrinter implements Visitor<ShowRequest> {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void visit(ShowRequest visitee) {
        System.out.printf("%-30s%-30s%-30d%-30d%-30s", visitee.location(), visitee.date()!= null ? sdf.format(visitee.createdOn().getTime()) : "N/A", visitee.droneNumber(),visitee.duration() , visitee.customer().customerName());
    }
}
