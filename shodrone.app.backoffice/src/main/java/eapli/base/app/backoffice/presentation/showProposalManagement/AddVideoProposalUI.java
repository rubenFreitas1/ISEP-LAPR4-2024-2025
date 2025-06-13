package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerDTOPrinter;
import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.base.showProposalManagement.application.AddVideoProposalController;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class AddVideoProposalUI extends AbstractUI {
    private final AddVideoProposalController controller = new AddVideoProposalController();
    @Override
    protected boolean doShow() {
        Iterable<CustomerDTO> customers = controller.listCustomers();
        if (!customers.iterator().hasNext()) {
            System.out.println("\nThere are no registered Customers in the system!\n");
            return false;
        }
        ShowProposalDTO showProposal = null;
        String headerModelCustomer = String.format("Select Customer\n#  %-30s%-30s%-30s%-30s", "NAME", "STATUS", "PHONE NUMBER", "EMAIL");
        String headerModelRequest = String.format("\nSelect Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION","PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
        boolean validRequestSelected = false;
        while (!validRequestSelected) {
            final SelectWidget<CustomerDTO> selectWidgetCustomer = new SelectWidget<>(headerModelCustomer, customers, new CustomerDTOPrinter());
            selectWidgetCustomer.show();
            CustomerDTO customer = selectWidgetCustomer.selectedElement();

            if (customer == null) {
                return true;
            }
            Iterable<ShowProposalDTO> showProposals = this.controller.listShowProposals(customer);
            if (!showProposals.iterator().hasNext()) {
                System.out.println("\nThere are no Show Proposals without a video simulation!\n");
                continue;
            }
            while (true) {
                final SelectWidget<ShowProposalDTO> selectWidgetProposal = new SelectWidget<>(headerModelRequest, showProposals, new ShowProposalDTOPrinter());
                selectWidgetProposal.show();
                showProposal = selectWidgetProposal.selectedElement();

                if (showProposal == null) {
                    break;
                }
                boolean exits = false;

                if (!exits) {
                    validRequestSelected = true;
                    break;
                }
            }
        }
        String video = requestVideo();
        try {
            if(controller.addVideoToProposal(video, showProposal)) {
                System.out.println("Show Proposal video simulation was successfully added!");
            } else {
                System.out.println("Error adding video simulation to Show Proposal!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }

        return true;
    }

    private String requestVideo() {
        String videoLink;

        final String videoLinkPattern = "^(https?://|www\\.)[a-zA-Z0-9][-a-zA-Z0-9&',./_=?%#:~]*$";

        while (true) {
            videoLink = Console.readLine("Enter the video link (starting with http://, https://, or www.): ");

            if (videoLink.trim().isEmpty()) {
                System.out.println("Video link cannot be empty. Please enter a valid video link.");
            }
            if (videoLink.matches(videoLinkPattern)) {
                return videoLink;
            } else {
                System.out.println("Invalid video link! Make sure it starts with http://, https://, or www. and only includes valid URL characters.");
            }
        }
    }
    @Override
    public String headline() {
        return "";
    }
}
