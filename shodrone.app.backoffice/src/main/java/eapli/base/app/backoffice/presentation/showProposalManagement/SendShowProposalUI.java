package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.showProposalManagement.application.SendShowProposalController;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;

public class SendShowProposalUI extends AbstractListUI<ShowProposal> {

    private SendShowProposalController controller = new SendShowProposalController();

    @Override
    protected Iterable<ShowProposal> elements() {
        return controller.allCompletedShowProposals();
    }

    @Override
    protected Visitor<ShowProposal> elementPrinter() {
        return new ShowProposalPrinter();
    }

    @Override
    protected String elementName() {
        return "Show Proposal";
    }

    @Override
    protected String listHeader() {
        return String.format("%-30s%-30s%-30s%-30s%-30s", "DESCRIPTION", "PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
    }

    @Override
    protected String emptyMessage() {
        return null;
    }

    @Override
    protected boolean doShow() {
        final Iterable<ShowProposal> showProposals = elements();
        if (!showProposals.iterator().hasNext()) {
            System.out.println("No completed show proposals available to send.");

        } else {
            final SelectWidget<ShowProposal> selector = new SelectWidget<>(listHeader(), showProposals, elementPrinter());
            selector.show();
            final ShowProposal selectedProposal = selector.selectedElement();
            if (selectedProposal != null) {
                if (controller.sendShowProposal(selectedProposal)) {
                    System.out.println("Show proposal sent successfully.");
                } else {
                    System.out.println("Failed to send show proposal.");
                }
            } else {
                System.out.println("No show proposal selected.");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Send Show Proposal";
    }
}
