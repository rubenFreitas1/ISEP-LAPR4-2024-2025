package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class MarkShowProposalController {


    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();



    public Iterable<ShowProposal> getAnsweredShowProposals(){
        return showProposalRepository.findByAcceptedProposals();
    }

    public boolean markShowProposal(ShowProposal showProposal){
        if(showProposal.markShowProposal()){
            showProposalRepository.save(showProposal);
            return true;
        }
        return false;
    }
}
