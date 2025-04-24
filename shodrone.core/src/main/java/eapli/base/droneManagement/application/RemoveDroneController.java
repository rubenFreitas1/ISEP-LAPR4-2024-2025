package eapli.base.droneManagement.application;

import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class RemoveDroneController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final DroneRepository repo = PersistenceContext.repositories().drones();

    private final DroneManagementService droneSvc = new DroneManagementService(repo);

    public void removeDrone(final Drone drone, final String reason) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        this.droneSvc.removeDrone(drone,reason);
    }

    public Iterable<Drone> activeDrones() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.DRONE_TECH);
        return this.droneSvc.activeDrones();
    }
}
