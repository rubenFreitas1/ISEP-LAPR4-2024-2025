package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.presentation.console.AbstractUI;
import rcomp.client.TcpClient;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class ScheduledShowsUI extends AbstractUI {

    private final String customerEmail;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ScheduledShowsUI(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    protected boolean doShow() {
        try {
            List<ShowProposalDTO> shows = TcpClient.listScheduledShows(customerEmail);

            if (shows.isEmpty()) {
                System.out.println("\nYou have no scheduled shows.");
                return false;
            }

            System.out.println("\n=== Your scheduled shows ===");
            for (ShowProposalDTO s : shows) {
                String dateStr = s.getDate() instanceof GregorianCalendar
                        ? sdf.format(((GregorianCalendar) s.getDate()).getTime())
                        : s.getDate().toString();
                System.out.printf("Date: %s | Location: %s | Duration: %d min%n",
                        dateStr, s.getLocation(), s.getDuration());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Scheduled Shows";
    }
}
