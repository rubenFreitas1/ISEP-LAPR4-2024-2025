package eapli.base.persistence.impl.inmemory;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryShowRequestRepository extends InMemoryDomainRepository<ShowRequest, Long> implements ShowRequestRepository {
    @Override
    public Iterable<ShowRequest> findByCustomer(Customer customer) {
        return match(e -> e.customer().equals(customer));
    }
    @Override
    public Optional<ShowRequest> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }
}
