package eapli.base.persistence.impl.inmemory;

import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowRequest;
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
}
