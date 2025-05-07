package eapli.base.representativeManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class RegisterRepresentativeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final RepresentativeRepository repo = PersistenceContext.repositories().representatives();

    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(repo);

    public Representative registerRepresentative(final String representativeName, final String representativeEmail, final String representativePhoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return representativesvc.registerNewRepresentative(representativeName, representativeEmail, representativePhoneNumber, authz.session().get().authenticatedUser());
    }
}
