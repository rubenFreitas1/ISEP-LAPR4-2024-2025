package eapli.base.showProposalManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.LPROGConnection.ProposalWriter;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class SendShowProposalController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final ShowProposalRepository repo = PersistenceContext.repositories().showProposals();

    private final ProposalWriter proposalWriter = new ProposalWriter();

    ShowProposalManagementService showProposalManagementSvc= new ShowProposalManagementService(repo, proposalWriter);

    public Iterable<ShowProposal> allCompletedShowProposals() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return showProposalManagementSvc.findByCompletedProposal();
    }

        public boolean sendShowProposal(ShowProposal showProposal) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return showProposalManagementSvc.sendShowProposal(showProposal);
    }
}
