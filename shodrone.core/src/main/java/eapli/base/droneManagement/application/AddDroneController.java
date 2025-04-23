package eapli.base.droneManagement.application;

import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.application.DroneModelManagementService;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class AddDroneController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final DroneRepository repo = PersistenceContext.repositories().drones();

    private final DroneModelRepository droneModelRepository = PersistenceContext.repositories().droneModels();

    private final DroneModelManagementService droneModelSvc = new DroneModelManagementService(droneModelRepository);

    private final DroneManagementService droneSvc = new DroneManagementService(repo);


    public Iterable<DroneModel> listDroneModels (){
        return this.droneModelSvc.listActiveDroneModels();
    }

    public Drone addDrone(final String serialNumber, final DroneModel droneModel){
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return this.droneSvc.registerNewDrone(serialNumber, droneModel,authz.session().get().authenticatedUser());
    }

}
