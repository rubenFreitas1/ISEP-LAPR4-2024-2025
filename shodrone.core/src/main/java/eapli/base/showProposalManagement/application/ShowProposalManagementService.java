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
import java.util.Random;

public class ShowProposalManagementService {
    private final ShowProposalRepository showProposalRepository;

    public ShowProposalManagementService(final ShowProposalRepository showProposalRepository){
        this.showProposalRepository = showProposalRepository;
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
            ProposalWriter proposalWriter = new ProposalWriter();
            String content = proposalWriter.proposalWriter(showProposal, showProposal.template());
            if (content == null) {
                System.err.println("ERROR: proposalWriter returned null content");
                return false;
            }
            String code = generateUniqueCode();
            if (!ShowProposalValidator.validateShowProposalRealData(content)) {
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

    private String generateUniqueCode() {
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
}
