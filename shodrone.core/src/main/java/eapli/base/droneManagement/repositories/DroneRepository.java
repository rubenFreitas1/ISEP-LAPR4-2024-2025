package eapli.base.droneManagement.repositories;

import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface DroneRepository extends DomainRepository<Long, Drone> {

    Optional<Drone> findById(Long id);

    Iterable<Drone> findByDroneModel(DroneModel droneModel);

    boolean isSerialNameUsed(String serialNumber);

    Iterable<Drone> findByActive(boolean b);
}
