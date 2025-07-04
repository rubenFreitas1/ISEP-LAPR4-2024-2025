package eapli.base.showProposalManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.LPROGConnection.ProposalWriter;
import eapli.base.showProposalManagement.LPROGConnection.plugins.ShowProposalValidator;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Random;

public class ShowProposalManagementService {
    private final ShowProposalRepository showProposalRepository;
    private final ProposalWriter proposalWriter;

    public ShowProposalManagementService(final ShowProposalRepository showProposalRepository,
                                         final ProposalWriter proposalWriter) {
        this.showProposalRepository = showProposalRepository;
        this.proposalWriter = proposalWriter;
    }

    public ShowProposal registerShowProposal(ShowRequest showRequest, GeoLocation location, Calendar date, LocalTime time, int duration, int totalDroneNumber, SystemUser user, Template template, double insurance) {
        long proposalCount = showProposalRepository.countByShowRequest(showRequest);
        int proposalNumber = (int) proposalCount + 1;

        ShowProposal showProposal = new ShowProposal(showRequest, location, date, time, duration, totalDroneNumber, proposalNumber, user, template, insurance);
        return (ShowProposal) this.showProposalRepository.save(showProposal);
    }

    public Iterable<ShowProposal> findByShowRequest(ShowRequest showRequest) {
        return this.showProposalRepository.findByShowRequest(showRequest);
    }

    public Iterable<ShowProposal> findByPendingAndEmptyVideo(Customer customer, ShowStatus status) {
        return this.showProposalRepository.findByPendingAndEmptyVideo(customer, status);
    }

    public Iterable<ShowProposal> findByCompletedProposal () {
        return this.showProposalRepository.findByCompletedProposal();
    }

    public boolean sendShowProposal (ShowProposal showProposal) {
        try {
            String content = proposalWriter.proposalWriter(showProposal, showProposal.template());
            if (content == null) {
                System.err.println("ERROR: proposalWriter returned null content");
                return false;
            }
            String code = generateUniqueCode();
            if (!isValidProposalContent(content)) {
                System.out.println("ERROR: Document Content invalid!");
                return false;
            }

            Document document = new Document(content, code);
            System.out.println("\n");
            System.out.println(document.finalContent());
            System.out.println("\n");
            showProposal.addDocument(document);
            showProposal.changeStatus(ShowStatus.SENT);
            this.showProposalRepository.save(showProposal);
            return true;

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return false;
        }catch (Exception e){
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean isValidProposalContent(String content) {
        return ShowProposalValidator.validateShowProposalRealData(content);
    }


    public String generateUniqueCode() {
        Random random = new Random();
        String code;

        do {
            int number = random.nextInt(1_000_000);
            code = String.format("SP%06d", number);
        } while (documentCodeExists(code));

        return code;
    }

    private boolean documentCodeExists(String code) {
        Document doc = this.showProposalRepository.findDocumentByCode(code);
        if (doc == null){
            return false;
        }
        return true;
    }

    public boolean generateShow(ShowProposal showProposal) {
        StringBuilder sb = new StringBuilder();

        sb.append("SHOW PROPOSAL SUMMARY\n");
        sb.append("---------------------\n");

        GeoLocation location = showProposal.location();
        sb.append(String.format("Location: Latitude %.6f, Longitude %.6f, Altitude %d m\n",
                location.latitude(), location.longitude(), location.altitude()));

        Calendar date = showProposal.date();
        LocalTime time = showProposal.time();
        sb.append(String.format("Date: %1$td/%1$tm/%1$tY at %2$tH:%2$tM\n", date, time));

        sb.append("Duration: ").append(showProposal.duration()).append(" minutes\n");
        sb.append("Total Drones: ").append(showProposal.totalDroneNumber()).append("\n");
        sb.append("\n");

        sb.append("---------------------\n");
        sb.append("SHOW SEQUENCE\n");

        showProposal.figureListItems().stream()
                .sorted(Comparator.comparingInt(f -> f.figureListItemID().sequenceNumber()))
                .forEach(item -> {
                    sb.append("-------------\n");
                    sb.append("Figure ").append(item.figureListItemID().sequenceNumber()).append(":\n");
                    sb.append("- Figure: ").append(item.figure().description()).append("\n");
                    sb.append("- Drone Model: ").append(item.droneModel().modelName()).append("\n");
                    sb.append("- DSL:\n").append(item.figure().dslBody()).append("\n\n");
                });

        String finalCode = sb.toString();

        System.out.println("\n");
        System.out.println(finalCode);
        System.out.println("\n");

        showProposal.addShowCode(finalCode);
        this.showProposalRepository.save(showProposal);
        return true;
    }

}
