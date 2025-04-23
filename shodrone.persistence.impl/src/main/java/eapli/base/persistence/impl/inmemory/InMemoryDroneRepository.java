package eapli.base.persistence.impl.inmemory;

import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryDroneRepository extends InMemoryDomainRepository<Drone, Long> implements DroneRepository {
    @Override
    public Iterable<Drone> findByDroneModel(DroneModel droneModel) {
        return match(e -> e.droneModel().equals(droneModel));
    }

    @Override
    public boolean isSerialNameUsed(String serialNumber) {
        return matchOne(e -> e.serialNumber().equalsIgnoreCase(serialNumber)).isPresent();
    }

    @Override
    public Optional<Drone> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }

}
