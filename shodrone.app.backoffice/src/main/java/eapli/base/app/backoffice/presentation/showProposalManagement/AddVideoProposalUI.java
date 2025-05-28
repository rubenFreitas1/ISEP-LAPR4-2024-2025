package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.app.backoffice.presentation.showRequestManagement.ShowRequestPrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.application.AddVideoProposalController;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class AddVideoProposalUI extends AbstractUI {
    private final AddVideoProposalController controller = new AddVideoProposalController();
    @Override
    protected boolean doShow() {
        Iterable<Customer> customers = controller.listCustomers();
        if (!customers.iterator().hasNext()) {
            System.out.println("\nThere are no registered Customers in the system!\n");
            return false;
        }
        ShowProposal showProposal = null;
        String headerModelCustomer = String.format("Select Customer\n#  %-30s%-30s%-30s%-30s", "NAME", "STATUS", "PHONE NUMBER", "EMAIL");
        String headerModelRequest = String.format("\nSelect a Show Requests\n#  %-80s%-30s%-30s%-30s%-30s", "LOCATION", "DATE", "NUMBER OF DRONES", "DURATION", "CUSTOMER");
        boolean validRequestSelected = false;
        while (!validRequestSelected) {
            final SelectWidget<Customer> selectWidgetCustomer = new SelectWidget<>(headerModelCustomer, customers, new CustomerPrinter());
            selectWidgetCustomer.show();
            Customer customer = selectWidgetCustomer.selectedElement();

            if (customer == null) {
                return true;
            }
            Iterable<ShowProposal> showProposals = this.controller.listShowProposals(customer);
            if (!showProposals.iterator().hasNext()) {
                System.out.println("\nThere are no Show Proposals without a video simulation!\n");
                continue;
            }
            while (true) {
                final SelectWidget<ShowProposal> selectWidgetProposal = new SelectWidget<>(headerModelRequest, showProposals, new ShowProposalPrinter());
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
            controller.addVideoToProposal(video, showProposal);
            System.out.println("Show Proposal video simulation was successfully added!");
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
