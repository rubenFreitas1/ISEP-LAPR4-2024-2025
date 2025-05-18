package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCustomerRepository extends JpaAutoTxRepository<Customer, Long, Long> implements CustomerRepository {

    public JpaCustomerRepository(TransactionalContext autoTx){super(autoTx, "customerId");}

    public JpaCustomerRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "customerId");
    }

    @Override
    public Iterable<Customer> findByActive() {
        return match("e.status != :deleted", "deleted", Customer.CustomerStatus.DELETED);
    }


    @Override
    public boolean isVatNumberUsed(String vatNumber) {
        final Map<String, Object> params = new HashMap<>();
        params.put("vatNumber", vatNumber);
        return matchOne("e.customerVatNumber = :vatNumber", params).isPresent();
    }
    @Override
    public boolean isEmailUsed(String customerEmail) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", customerEmail);
        return matchOne("e.customerEmail = :email", params).isPresent();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.customerId = :id", params);
    }
}
