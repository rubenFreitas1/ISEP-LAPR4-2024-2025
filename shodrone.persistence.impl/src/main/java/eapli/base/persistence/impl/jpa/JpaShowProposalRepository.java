package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ProposalAnswerFeedback;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.NoResultException;

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
    public Iterable<ShowProposal> findByShowRequest(ShowRequest showRequest) {
        return entityManager()
                .createQuery("SELECT sp FROM ShowProposal sp WHERE sp.showRequest = :showRequest", ShowProposal.class)
                .setParameter("showRequest", showRequest)
                .getResultList();
    }

    @Override
    public Iterable<ShowProposal> findByAcceptedProposals() {
        return entityManager()
                .createQuery(
                        "SELECT sp FROM ShowProposal sp " +
                                "WHERE sp.proposalAnswerFeedback IS NOT NULL " +
                                "AND sp.proposalAnswerFeedback.answer = :answer",
                        ShowProposal.class)
                .setParameter("answer", ProposalAnswerFeedback.Answer.ACCEPTED)
                .getResultList();
    }

    @Override
    public Iterable<ShowProposal> findByEmailAndStatus(EmailAddress email, ShowStatus status) {
        return entityManager()
                .createQuery(
                        "SELECT DISTINCT sp FROM ShowProposal sp " +
                                "LEFT JOIN sp.showRequest.customer.representatives reps " +
                                "WHERE (sp.showRequest.customer.customerEmail = :email " +
                                "OR reps.representativeEmail = :email) " +
                                "AND sp.status = :status",
                        ShowProposal.class)
                .setParameter("email", email)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public Document findDocumentByCode(String code) {
        try {
            return entityManager()
                    .createQuery("SELECT d FROM Document d WHERE d.code = :code", Document.class)
                    .setParameter("code", code)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Iterable<ShowProposal> findByStatus(ShowStatus status) {
        return match("e.status = :status", "status", status);
    }

    @Override
    public Iterable<ShowProposal> findByStatusAndEmptyDroneList(ShowStatus status) {
        return entityManager()
                .createQuery(
                        "SELECT sp FROM ShowProposal sp WHERE sp.status = :status AND SIZE(sp.droneModelList) = 0",
                        ShowProposal.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public Iterable<ShowProposal> findByPendingAndEmptyVideo(Customer customer, ShowStatus status) {
        return entityManager()
                .createQuery(
                        "SELECT sp FROM ShowProposal sp " +
                                "WHERE sp.status = :status " +
                                "AND sp.videoLink IS NULL " +
                                "AND sp.showRequest.customer = :customer",
                        ShowProposal.class)
                .setParameter("status", status)
                .setParameter("customer", customer)
                .getResultList();
    }

}
