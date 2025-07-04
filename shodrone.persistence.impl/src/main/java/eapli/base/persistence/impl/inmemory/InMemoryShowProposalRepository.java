package eapli.base.persistence.impl.inmemory;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ProposalAnswerFeedback;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryShowProposalRepository extends InMemoryDomainRepository<ShowProposal, Long> implements ShowProposalRepository {

    private final List<ShowProposal> proposals = new ArrayList<>();

    @Override
    public Optional<ShowProposal> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }

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
    public Iterable<ShowProposal> findByAcceptedProposals(Customer customer) {
        List<ShowProposal> result = new ArrayList<>();
        for (ShowProposal proposal : proposals) {
            var feedback = proposal.proposalAnswerFeedback();
            if (feedback != null && feedback.answer() == ProposalAnswerFeedback.Answer.ACCEPTED && proposal.showRequest().customer() == customer && proposal.status() == ShowStatus.ANSWERED) {
                result.add(proposal);
            }
        }
        return result;
    }

    @Override
    public Iterable<ShowProposal> findByEmailAndStatus(EmailAddress email, ShowStatus status) {
        List<ShowProposal> result = new ArrayList<>();

        for (ShowProposal proposal : proposals) {
            var showRequest = proposal.showRequest();
            var customer = showRequest.customer();
            EmailAddress customerEmail = customer.customerEmail();

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
    public Iterable<ShowProposal> findScheduledShowsByEmail(EmailAddress email) {
        List<ShowProposal> result = new ArrayList<>();

        for (ShowProposal proposal : proposals) {
            var showRequest = proposal.showRequest();
            var customer = showRequest.customer();
            EmailAddress customerEmail = customer.customerEmail();

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

            if (emailMatches && proposal.status() == ShowStatus.ACCEPTED && proposal.date().getClass().equals(java.util.Date.class) && proposal.date().after(new java.util.Date())) {
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
    public Iterable<ShowProposal> findByStatusAndFilledDroneList(ShowStatus status) {
        return this.match(e -> e.status().equals(status) && e.allDroneModels_Quantity() > 0 && e.figureListItems().isEmpty());
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

    @Override
    public Iterable<ShowProposal> findByCompletedProposal() {
        List<ShowProposal> result = new ArrayList<>();
        for (ShowProposal proposal : proposals) {
            if (!proposal.droneListItem().isEmpty() && proposal.videoLink() != null && !proposal.figureListItems().isEmpty() && proposal.status() == ShowStatus.PENDING) {
                result.add(proposal);
            }
        }
        return result;
    }

}
