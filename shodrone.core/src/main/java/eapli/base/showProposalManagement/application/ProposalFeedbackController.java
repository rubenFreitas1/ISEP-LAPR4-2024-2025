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

   public void updateProposalFeedback(Optional<ShowProposal> proposal, Boolean approval, String feedback) {
        ProposalAnswerFeedback.Answer answer = ProposalAnswerFeedback.Answer.REJECTED;
        if(approval){
            answer = ProposalAnswerFeedback.Answer.ACCEPTED;
        }
        ProposalAnswerFeedback proposalAnswerFeedback = new ProposalAnswerFeedback(answer, feedback);
        proposal.get().updateProposalAnswer(proposalAnswerFeedback);
        proposal.get().changeStatus(ShowStatus.ANSWERED);
        showProposalRepository.save(proposal.get());
   }
}
