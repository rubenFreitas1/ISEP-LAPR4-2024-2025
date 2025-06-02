package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.showProposalManagement.application.MarkShowProposalController;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class MarkShowProposalUI extends AbstractUI {

    private MarkShowProposalController controller = new MarkShowProposalController();

    @Override
    protected boolean doShow() {
       Iterable<ShowProposal> listShowProposalAccepted = controller.getAnsweredShowProposals();
       if(!listShowProposalAccepted.iterator().hasNext()){
           System.out.println("\nThere are no Show Proposals Accepted by the Customers Representatives!\n");
           return false;
       }
        String headerModel = String.format("Select Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION","PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
        SelectWidget<ShowProposal> selector = new SelectWidget<>(headerModel, listShowProposalAccepted, new ShowProposalPrinter());
        selector.show();
        ShowProposal showProposal = selector.selectedElement();
        if(showProposal == null){
            System.out.println("Show Proposal cannot be null!");
            return false;
        }
        if(controller.markShowProposal(showProposal)){
            System.out.println("Show Proposal updated as Accepted!");
            return true;
        }
        System.out.println("Show Proposal was not updated as Accepted!");
        return false;
    }

    @Override
    public String headline() {
        return "Mark Show Proposal";
    }
}
