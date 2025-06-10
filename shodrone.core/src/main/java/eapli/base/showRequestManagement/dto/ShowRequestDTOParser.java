package eapli.base.showRequestManagement.dto;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ShowRequestDTOParser {
    private final ShowRequestRepository showRequestRepository = PersistenceContext.repositories().showRequests();

    public Iterable<ShowRequestDTO> transformToShowRequestDTOlist(final Iterable<ShowRequest> showRequests){
        return StreamSupport.stream(showRequests.spliterator(), true).map(ShowRequest::toDTO).collect(Collectors.toUnmodifiableList());
    }

    public Optional<ShowRequest> getShowRequestfromDTO(ShowRequestDTO showRequestDTO){
        return this.showRequestRepository.findById(showRequestDTO.getShowRequestId());
    }
}
