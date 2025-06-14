package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTOParser;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public class GetScheduledShowsController {

    ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    ShowProposalDTOParser showProposalDTOParser = new ShowProposalDTOParser();

    public Iterable<ShowProposalDTO> findScheduledShows(String customerEmail) {
        EmailAddress scheduledemail = EmailAddress.valueOf(customerEmail);
        return showProposalDTOParser.transformToShowProposalDTOlist(showProposalRepository.findScheduledShowsByEmail(scheduledemail));
    }
}
