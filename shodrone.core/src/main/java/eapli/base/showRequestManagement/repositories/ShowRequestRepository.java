package eapli.base.showRequestManagement.repositories;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ShowRequestRepository extends DomainRepository<Long, ShowRequest> {

    Iterable<ShowRequest> findByCustomer(Customer customer);

    Optional<ShowRequest> findById(Long id);
}
