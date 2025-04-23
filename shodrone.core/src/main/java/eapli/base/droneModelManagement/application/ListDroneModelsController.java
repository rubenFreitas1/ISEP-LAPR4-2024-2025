package eapli.base.droneModelManagement.application;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class ListDroneModelsController {

    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final DroneModelRepository repo = PersistenceContext.repositories().droneModels(autoTx);

    private final DroneModelManagementService droneModelsvc = new DroneModelManagementService(repo);

    public Iterable<DroneModel> allDroneModels() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return droneModelsvc.findAll();
    }
}
