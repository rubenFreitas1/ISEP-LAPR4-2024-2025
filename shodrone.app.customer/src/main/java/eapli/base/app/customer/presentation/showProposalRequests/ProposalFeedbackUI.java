package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.base.app.backoffice.presentation.showProposalManagement.ShowProposalDTOPrinter;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import rcomp.client.TcpClient;

import java.io.IOException;
import java.util.List;

public class ProposalFeedbackUI extends AbstractUI {

    private final String customerEmail;


    public ProposalFeedbackUI(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    @Override
    protected boolean doShow() {
        try {
            List<ShowProposalDTO> showProposalList = TcpClient.listCompletedShows(customerEmail);
            boolean proposalAccepted = false;
            String aprooval, feedback;
            if (showProposalList == null || showProposalList.isEmpty()) {
                System.out.println("There are no Show Proposals to give feedback on!");
                return false;
            }
            System.out.println("Available Show Proposals for Feedback:");
            ShowProposalDTOPrinter showProposalPrinter = new ShowProposalDTOPrinter();
            String headerModel = String.format("Select Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION","PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
            final SelectWidget<ShowProposalDTO> selector = new SelectWidget<>(headerModel, showProposalList, showProposalPrinter);
            selector.show();
            final ShowProposalDTO selectedProposal = selector.selectedElement();
            if (selectedProposal == null) {
                System.out.println("No Show Proposal selected.");
                return false;
            }
            System.out.println("Selected Show Proposal: " + selectedProposal.getShowRequestDescription());
            aprooval = Console.readLine("Do you accept this Show Proposal? (yes/no)");
            if (aprooval.equalsIgnoreCase("yes")) {
                proposalAccepted = true;
            }
            feedback = Console.readLine("Please provide your feedback on the Show Proposal. If you do not desire to just type n:");
            if (feedback.equalsIgnoreCase("n")) {
                feedback = "No feedback provided.";
            }

            if (TcpClient.proposalFeedback(selectedProposal, proposalAccepted, feedback)) {
                System.out.println("Feedback successfully submitted!");
                return true;
            } else {
                System.out.println("Error submitting feedback. Please try again.");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Proposal Feedback";
    }
}
