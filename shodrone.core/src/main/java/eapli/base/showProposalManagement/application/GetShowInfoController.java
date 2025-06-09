package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public class GetShowInfoController {
    ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();

    public Iterable<ShowProposal> findAcceptedByCustomer(String email){
        EmailAddress emailAddress = EmailAddress.valueOf(email);
        return this.showProposalRepository.findByEmailAndStatus(emailAddress, ShowStatus.ACCEPTED);
    }
    public Optional<ShowProposal> findById(Long id){
        return this.showProposalRepository.findById(id);
    }
}
