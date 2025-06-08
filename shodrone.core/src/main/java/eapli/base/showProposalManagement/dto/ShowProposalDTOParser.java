package eapli.base.showProposalManagement.dto;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ShowProposalDTOParser {

    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();

    public Iterable<ShowProposalDTO> transformToShowProposalDTOlist(final Iterable<ShowProposal> showProposals){
        return StreamSupport.stream(showProposals.spliterator(), true).map(ShowProposal::toDTO).collect(Collectors.toUnmodifiableList());
    }

    public Optional<ShowProposal> getShowProposalfromDTO(ShowProposalDTO showProposalDTO){
        return this.showProposalRepository.findById(showProposalDTO.getShowProposalId());
    }
}
