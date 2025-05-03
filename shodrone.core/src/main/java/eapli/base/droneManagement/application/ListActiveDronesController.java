package eapli.base.droneManagement.application;

import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.application.DroneModelManagementService;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListActiveDronesController {

    private final DroneRepository repo = PersistenceContext.repositories().drones();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final DroneManagementService droneSvc = new DroneManagementService(repo);

    private final DroneModelManagementService droneModelSvc = new DroneModelManagementService(PersistenceContext.repositories().droneModels());

    public Iterable<DroneModel> activeDroneModel() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return this.droneModelSvc.listActiveDroneModels();
    }

    public Iterable<Drone> findByDroneModel(final DroneModel droneModel) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return this.droneSvc.findByDroneModel(droneModel);
    }
}
