package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.presentation.console.AbstractUI;
import rcomp.client.TcpClient;
import java.util.List;

public class ScheduledShowsUI extends AbstractUI {

    private final String customerEmail;

    public ScheduledShowsUI(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    protected boolean doShow() {
        try {
            List<ShowProposalDTO> showProposalList = TcpClient.listScheduledShows(customerEmail);

            if (showProposalList == null || showProposalList.isEmpty()) {
                System.out.println("There are no Scheduled Shows!");
                return false;
            }

            System.out.println("\n=== Scheduled Shows ===");
            int idx = 1;
            for (ShowProposalDTO show : showProposalList) {
                System.out.printf("%2d) %s – %s%n", idx++, show.getDate(), show.getLocation());
            }

            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String headline() {
        return "Scheduled Shows";
    }
}
