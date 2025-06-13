package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import rcomp.client.TcpClient;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class GetShowInfoUI extends AbstractUI {
    private final String customerEmail;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
            for (ShowProposalDTO s : shows) {
                String dateStr = s.getDate() instanceof GregorianCalendar
                        ? sdf.format(((GregorianCalendar) s.getDate()).getTime())
                        : s.getDate().toString();
                String timeStr = s.getTime() != null ? s.getTime().toString() : "??:??";
                System.out.printf("%2d) %s %s – %s%n", idx++, dateStr, timeStr, s.getLocation());
            }
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
        String dateStr = d.getDate() instanceof GregorianCalendar
                ? sdf.format(((GregorianCalendar) d.getDate()).getTime())
                : d.getDate().toString();
        String timeStr = d.getTime() != null ? d.getTime().toString() : "??:??";
        System.out.println("\n========== Show details ==========");
        System.out.printf("Date/time:         %s %s%n", dateStr, timeStr);
        System.out.printf("Duration:          %d min%n", d.getDuration());
        System.out.printf("Total drones:      %d%n", d.getTotalDroneNumber());
        System.out.printf("Insurance amount:  €%.2f%n", d.getInsuranceAmount());

        System.out.println("\nDrone models:");
        d.getListItemDTOS().forEach(m ->
                System.out.printf("  – %s ×%d%n", m.getDroneModelName(), m.getNumberOfDrones()));

        System.out.println("\nFigures:");
        d.getListFigureDTOS().forEach(f -> System.out.printf("  –> " + f.getFigureDescription()));



        if (d.getVideoLink() != null && !d.getVideoLink().isBlank())
            System.out.println("\nTeaser video: " + d.getVideoLink());

        System.out.println("==================================");
    }

    @Override
    public String headline() {
        return "";
    }
}
