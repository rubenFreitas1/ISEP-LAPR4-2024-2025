package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.showRequestManagement.domain.GenericSelector;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.visitor.Visitor;

import java.text.SimpleDateFormat;

public class ShowRequestPrinter implements Visitor<ShowRequest>, GenericSelector.ItemPrinter<ShowRequest> {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void visit(ShowRequest visitee) {
        System.out.printf("%-30s%-30s%-30d%-30d%-30s", visitee.location(), visitee.date()!= null ? sdf.format(visitee.date().getTime()) : "N/A", visitee.droneNumber(),visitee.duration() , visitee.customer().customerName());
    }

    @Override
    public String print(ShowRequest item) {
        return String.format("%-30s%-30s%-30d%-30d%-30s", item.location(), item.date() != null ? sdf.format(item.date().getTime()) : "N/A", item.droneNumber(), item.duration(), item.customer().customerName());
    }
}
