package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.showRequestManagement.dto.ShowRequestDTO;
import eapli.framework.visitor.Visitor;

import java.text.SimpleDateFormat;

public class ShowRequestDTOPrinter implements Visitor<ShowRequestDTO>{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void visit(ShowRequestDTO visitee) {
        System.out.printf("%-80s%-30s%-30d%-30d%-30s", visitee.getLocation(), visitee.getDate()!= null ? sdf.format(visitee.getDate().getTime()) : "N/A", visitee.getDroneNumber(),visitee.getDuration() , visitee.getCustomer().getCustomerName());
    }
}
