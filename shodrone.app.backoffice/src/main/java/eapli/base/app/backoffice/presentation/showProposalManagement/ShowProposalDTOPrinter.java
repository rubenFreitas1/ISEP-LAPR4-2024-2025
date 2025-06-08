package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.visitor.Visitor;

import java.text.SimpleDateFormat;

public class ShowProposalDTOPrinter implements Visitor<ShowProposalDTO> {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void visit(ShowProposalDTO visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s%-30s", visitee.getShowRequestDescription(), visitee.getProposalNumber(), visitee.getCustomerName(), visitee.getDate() != null ? sdf.format(visitee.getDate().getTime()) : "N/A", visitee.getDuration());
    }
}
