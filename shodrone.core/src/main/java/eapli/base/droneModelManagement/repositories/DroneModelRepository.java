package eapli.base.droneModelManagement.repositories;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface DroneModelRepository extends DomainRepository<Long, DroneModel> {

    Optional<DroneModel> findById(Long id);

    Iterable<DroneModel> findByManufacturer(String manufacturer);

    boolean isDroneModelNameUsed(String name);

}
