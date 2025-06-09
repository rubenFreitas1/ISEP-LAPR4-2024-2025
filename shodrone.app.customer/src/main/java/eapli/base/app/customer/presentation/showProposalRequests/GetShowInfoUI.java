package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import rcomp.client.TcpClient;

import java.util.List;

public class GetShowInfoUI extends AbstractUI {
    private final String customerEmail;

    public GetShowInfoUI(String customerEmail){
        this.customerEmail = customerEmail;
    }
    @Override
    protected boolean doShow() {
        try {
            List<ShowProposalDTO> shows =
                    TcpClient.listAcceptedShows(customerEmail);

            if (shows.isEmpty()) {
                System.out.println("\nYou have no accepted shows.");
                return false;
            }

            System.out.println("\n=== Your accepted shows ===");
            int idx = 1;
            for (ShowProposalDTO s : shows)
                System.out.printf("%2d) %s – %s%n",
                        idx++, s.getDate(), s.getLocation());

            int sel = Console.readInteger("\nSelect a show (0 to exit) > ");
            if (sel == 0) return false;

            ShowProposalDTO details = TcpClient.showDetails(shows.get(sel - 1).getShowProposalId());

            prettyPrint(details);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }

    private void prettyPrint(ShowProposalDTO d) {
        System.out.println("\n========== Show details ==========");
        System.out.printf("Date/time:         %s %s%n", d.getDate(), d.getTime());
        System.out.printf("Duration:          %d min%n", d.getDuration());
        System.out.printf("Total drones:      %d%n", d.getTotalDroneNumber());
        System.out.printf("Insurance amount:  €%.2f%n", d.getInsuranceAmount());

        System.out.println("\nDrone models:");
        d.getListItemDTOS().forEach(m ->
                System.out.printf("  – %s ×%d%n", m.getDroneModelName(), m.getNumberOfDrones()));
        /*
        System.out.println("\nFigures:");
        d.figures.forEach(f -> System.out.println("  – " + f));


         */
        if (d.getVideoLink() != null && !d.getVideoLink().isBlank())
            System.out.println("\nTeaser video: " + d.getVideoLink());

        System.out.println("==================================");
    }

    @Override
    public String headline() {
        return "";
    }
}
