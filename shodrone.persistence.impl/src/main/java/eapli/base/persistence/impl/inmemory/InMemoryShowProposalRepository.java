package eapli.base.persistence.impl.inmemory;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ProposalAnswerFeedback;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShowProposalRepository extends InMemoryDomainRepository<ShowProposal, Long> implements ShowProposalRepository {

    private final List<ShowProposal> proposals = new ArrayList<>();

    @Override
    public long countByShowRequest(ShowRequest showRequest) {
        return proposals.stream()
                .filter(p -> p.showRequest().equals(showRequest))
                .count();
    }

    @Override
    public Iterable<ShowProposal> findByShowRequest(ShowRequest showRequest) {
        List<ShowProposal> result = new ArrayList<>();
        for (ShowProposal proposal : proposals) {
            if (proposal.showRequest().equals(showRequest)) {
                result.add(proposal);
            }
        }
        return result;
    }

    @Override
    public Iterable<ShowProposal> findByAcceptedProposals() {
        List<ShowProposal> result = new ArrayList<>();
        for (ShowProposal proposal : proposals) {
            var feedback = proposal.proposalAnswerFeedback();
            if (feedback != null && feedback.answer() == ProposalAnswerFeedback.Answer.ACCEPTED) {
                result.add(proposal);
            }
        }
        return result;
    }

    @Override
    public Iterable<ShowProposal> findByEmailAndStatus(String email, ShowStatus status) {
        List<ShowProposal> result = new ArrayList<>();

        for (ShowProposal proposal : proposals) {
            var showRequest = proposal.showRequest();
            var customer = showRequest.customer();
            String customerEmail = customer.customerEmail().toString();

            boolean emailMatches = false;

            if (customerEmail.equals(email)) {
                emailMatches = true;
            } else {
                var representatives = customer.representatives();
                if (representatives != null) {
                    for (var rep : representatives) {
                        String repEmail = rep.representativeEmail().toString();
                        if (repEmail.equals(email)) {
                            emailMatches = true;
                            break;
                        }
                    }
                }
            }
            if (emailMatches && proposal.status() == status) {
                result.add(proposal);
            }
        }
        return result;
    }

    @Override
    public Document findDocumentByCode(String code) {
        for(ShowProposal showProposal: proposals){
            if(showProposal.document().code().equals(code)){
                return showProposal.document();
            }
        }
        return null;
    }

    @Override
    public Iterable<ShowProposal> findByStatus(ShowStatus status) {
        return this.match(e -> e.status().equals(status));
    }

    @Override
    public Iterable<ShowProposal> findByStatusAndEmptyDroneList(ShowStatus status) {
        return this.match(e -> e.status().equals(status) && e.allDroneModels_Quantity() == 0);
    }

    @Override
    public Iterable<ShowProposal> findByPendingAndEmptyVideo(Customer customer, ShowStatus status) {
        List<ShowProposal> result = new ArrayList<>();
        for (ShowProposal proposal : proposals) {
            if (proposal.status() == status &&
                    proposal.videoLink() == null &&
                    proposal.showRequest() != null &&
                    proposal.showRequest().customer().equals(customer)) {
                result.add(proposal);
            }
        }
        return result;
    }


}
