package eapli.base.droneModelManagement.application;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


@UseCaseController
public class AddDroneModelController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final DroneModelRepository repo = PersistenceContext.repositories().droneModels();

    private final DroneModelManagementService droneModelsvc = new DroneModelManagementService(repo);


    public DroneModel addDroneModel(final String modelName, final String manufacturer, final DroneWindBehavior windBehavior) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return droneModelsvc.registerNewDroneModel(modelName,manufacturer, authz.session().get().authenticatedUser(), windBehavior);
    }
}
