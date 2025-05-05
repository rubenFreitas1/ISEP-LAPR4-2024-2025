package eapli.base.customerManagement.repositories;

import eapli.base.customerManagement.domain.Customer;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CustomerRepository extends DomainRepository<Long, Customer> {

    Optional<Customer> findById(Long id);

    Iterable<Customer> findByActive();

    boolean isVatNumberUsed(String customerVatNumber);

    boolean isEmailUsed(String customerEmail);

}
