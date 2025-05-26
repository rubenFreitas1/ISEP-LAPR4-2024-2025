package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.framework.visitor.Visitor;

import java.text.SimpleDateFormat;

public class ShowProposalPrinter implements Visitor<ShowProposal> {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // DESCRIPTION, CUSTOMER NAME, DATE, DURATION
    @Override
    public void visit(ShowProposal visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s%-30s", visitee.showRequest().description(), visitee.proposalNumber(), visitee.showRequest().customer().customerName(), visitee.date() != null ? sdf.format(visitee.date().getTime()) : "N/A", visitee.duration());
    }
}
