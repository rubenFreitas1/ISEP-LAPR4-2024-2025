package eapli.base.showProposalManagement.repositories;

import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.domain.repositories.DomainRepository;

public interface ShowProposalRepository extends DomainRepository<Long, ShowProposal> {
    long countByShowRequest(ShowRequest showRequest);

    Iterable<ShowProposal> findByShowRequest(ShowRequest showRequest);

    Iterable<ShowProposal> findByStatus(ShowStatus status);

    Iterable<ShowProposal> findByStatusAndEmptyDroneList(ShowStatus status);
}
