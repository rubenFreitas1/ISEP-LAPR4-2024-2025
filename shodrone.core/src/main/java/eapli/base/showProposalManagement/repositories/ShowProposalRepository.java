package eapli.base.showProposalManagement.repositories;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface ShowProposalRepository extends DomainRepository<Long, ShowProposal> {

    Optional<ShowProposal> findById(Long id);
    long countByShowRequest(ShowRequest showRequest);

    Iterable<ShowProposal> findByShowRequest(ShowRequest showRequest);

    Iterable<ShowProposal> findByAcceptedProposals(Customer customer);

    Iterable<ShowProposal> findByEmailAndStatus(EmailAddress email, ShowStatus status);

    Document findDocumentByCode(String code);

    Iterable<ShowProposal> findByStatus(ShowStatus status);

    Iterable<ShowProposal> findByStatusAndEmptyDroneList(ShowStatus status);

    Iterable<ShowProposal> findByPendingAndEmptyVideo(Customer customer, ShowStatus status);
}
