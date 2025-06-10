package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaShowRequestRepository extends JpaAutoTxRepository<ShowRequest, Long, Long> implements ShowRequestRepository {
    public JpaShowRequestRepository(TransactionalContext autoTx) { super(autoTx, "showRequestId"); }

    public JpaShowRequestRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(), "showRequestId");
    }

    @Override
    public Iterable<ShowRequest> findByCustomer(Customer customer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("customer", customer);
        return match("e.customer = :customer", params);
    }

    @Override
    public Optional<ShowRequest> findById(final Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.showRequestId = :id", params);
    }
}
