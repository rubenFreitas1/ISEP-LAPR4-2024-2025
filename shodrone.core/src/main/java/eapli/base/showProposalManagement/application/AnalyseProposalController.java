package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class AnalyseProposalController {

    ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();


    public Iterable<ShowProposal> findByEmailAndStatus(String email){
        return showProposalRepository.findByEmailAndStatus(email, ShowStatus.SENT);
    }

    public Document findDocumentByCode(String code){
        return showProposalRepository.findDocumentByCode(code);
    }

}
