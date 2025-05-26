package eapli.base.showProposalManagement.repositories;

import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.ShowProposalStatus;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.domain.repositories.DomainRepository;

public interface ShowProposalRepository extends DomainRepository<Long, ShowProposal> {
    long countByShowRequest(ShowRequest showRequest);

    Iterable<ShowProposal> findByStatus(ShowProposalStatus status);

    Iterable<ShowProposal> findByStatusAndEmptyDroneList(ShowProposalStatus status);
}
