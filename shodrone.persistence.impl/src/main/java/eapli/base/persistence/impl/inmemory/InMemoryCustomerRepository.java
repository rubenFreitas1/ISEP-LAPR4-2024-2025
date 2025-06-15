package eapli.base.persistence.impl.inmemory;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, Long>
        implements CustomerRepository {


    @Override
    public Optional<Customer> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }

    @Override
    public Iterable<Customer> findByActive() {
        return this.match(e -> e.status() != Customer.CustomerStatus.DELETED);
    }

    @Override
    public boolean isCustomerPhoneNumberUsed(String customerPhoneNumber) {
        return matchOne(e -> e.customerPhoneNumber().equals(customerPhoneNumber)).isPresent();
    }


    @Override
    public boolean isVatNumberUsed(String vatNumber) {
        return matchOne(e -> e.customerVatNumber().equalsIgnoreCase(vatNumber)).isPresent();
    }
    @Override
    public boolean isEmailUsed(String customerEmail) {
        return matchOne(e -> e.customerEmail().equals(customerEmail)).isPresent();
    }

}
