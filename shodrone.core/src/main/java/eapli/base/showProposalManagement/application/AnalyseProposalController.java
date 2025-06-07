package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.Document;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;

@UseCaseController
public class AnalyseProposalController {

    ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();


    public Iterable<ShowProposal> findByEmailAndStatus(String email){
        EmailAddress emailAddress = EmailAddress.valueOf(email);
        return showProposalRepository.findByEmailAndStatus(emailAddress, ShowStatus.SENT);
    }

    public Document findDocumentByCode(String code){
        return showProposalRepository.findDocumentByCode(code);
    }

}
