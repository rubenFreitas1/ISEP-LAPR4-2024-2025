package eapli.base.representativeManagement.repositories;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.representativeManagement.domain.Representative;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface RepresentativeRepository extends DomainRepository<Long, Representative> {

    Optional<Representative> findById(Long id);

    Iterable<Representative> findByActive(boolean active);

    boolean isEmailUsed(String representativeEmail);

    Iterable<Representative> findByAssociatedCustomer(Customer associatedCustomer);
}
