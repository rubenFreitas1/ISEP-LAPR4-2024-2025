package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ProposalAnswerFeedback;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTOParser;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

@UseCaseController
public class ProposalFeedbackController {

    ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();
    ShowProposalDTOParser showProposalDTOParser = new ShowProposalDTOParser();


    public Iterable<ShowProposalDTO> findBySent (String email){
        EmailAddress emailAddress = EmailAddress.valueOf(email);
        return showProposalDTOParser.transformToShowProposalDTOlist(showProposalRepository.findByEmailAndStatus(emailAddress, ShowStatus.SENT));
    }

   public Optional<ShowProposal> findById(Long id) {
       return showProposalRepository.findById(id);
   }

   public void updateProposalFeedback(Optional<ShowProposal> proposal, String aprooval, String feedback) {
        ProposalAnswerFeedback.Answer answer = null;
        if(aprooval.equalsIgnoreCase("yes")){
            answer = ProposalAnswerFeedback.Answer.ACCEPTED;
        } else if(aprooval.equalsIgnoreCase("no")) {
            answer = ProposalAnswerFeedback.Answer.REJECTED;
        }
        ProposalAnswerFeedback proposalAnswerFeedback = new ProposalAnswerFeedback(answer, feedback);
        proposal.get().updateProposalAnswer(proposalAnswerFeedback);
        showProposalRepository.save(proposal.get());
   }
}
