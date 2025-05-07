package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaRepresentativeRepository extends JpaAutoTxRepository<Representative, Long, Long> implements RepresentativeRepository {

    public JpaRepresentativeRepository(final TransactionalContext autoTx) {super(autoTx, "representativeId");}

    public JpaRepresentativeRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "representativeId");
    }

    @Override
    public Iterable<Representative> findByActive(boolean active) {
        return this.match("e.active=:active", new Object[]{"active", active});
    }

    @Override
    public boolean isEmailUsed(String representativeEmail) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", representativeEmail);
        return matchOne("e.representativeEmail = :email", params).isPresent();
    }
    @Override
    public Optional<Representative> findById(final Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.representativeId = :id", params);
    }
    @Override
    public Iterable<Representative> findByAssociatedCustomer(Customer associatedCustomer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("customer", associatedCustomer);
        return match("e.associatedCustomer = :customer", params);
    }
}
