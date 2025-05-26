package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.ShowProposalStatus;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaShowProposalRepository extends JpaAutoTxRepository<ShowProposal, Long, Long> implements ShowProposalRepository {
    public JpaShowProposalRepository(TransactionalContext autoTx) { super(autoTx, "showProposalId"); }

    public JpaShowProposalRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(), "showProposalId");
    }

    @Override
    public long countByShowRequest(ShowRequest showRequest) {
        return entityManager()
                .createQuery("SELECT COUNT(sp) FROM ShowProposal sp WHERE sp.showRequest = :showRequest", Long.class)
                .setParameter("showRequest", showRequest)
                .getSingleResult();
    }

    @Override
    public Iterable<ShowProposal> findByStatus(ShowProposalStatus status) {
        return match("e.status = :status", "status", status);
    }

    @Override
    public Iterable<ShowProposal> findByStatusAndEmptyDroneList(ShowProposalStatus status) {
        return entityManager()
                .createQuery(
                        "SELECT sp FROM ShowProposal sp WHERE sp.status = :status AND SIZE(sp.droneModelList) = 0",
                        ShowProposal.class)
                .setParameter("status", status)
                .getResultList();
    }
}
