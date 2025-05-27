package eapli.base.persistence.impl.inmemory;

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
    public Iterable<ShowProposal> findByStatus(ShowStatus status) {
        return this.match(e -> e.status().equals(status));
    }

    @Override
    public Iterable<ShowProposal> findByStatusAndEmptyDroneList(ShowStatus status) {
        return this.match(e -> e.status().equals(status) && e.allDroneModels_Quantity() == 0);
    }

}
