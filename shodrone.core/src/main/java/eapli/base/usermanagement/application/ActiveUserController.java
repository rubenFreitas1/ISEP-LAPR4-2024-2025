package eapli.base.usermanagement.application;

import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


@UseCaseController
public class ActiveUserController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public Iterable<SystemUser> deactiveUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN);

        return userSvc.deactivatedUsers();
    }

    public SystemUser activateUser(final SystemUser user) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.POWER_USER, Roles.ADMIN);
        return userSvc.activateUser(user);
    }
}
