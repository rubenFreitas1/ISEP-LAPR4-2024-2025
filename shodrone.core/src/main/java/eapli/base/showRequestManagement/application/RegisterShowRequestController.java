package eapli.base.showRequestManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class RegisterShowRequestController {
    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ShowRequestRepository repo = PersistenceContext.repositories().showRequests(autoTx);
    private final ShowRequestManagementService showRequestManagementService = new ShowRequestManagementService(repo);

    public Iterable<Customer> customers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return null;
    }
}
