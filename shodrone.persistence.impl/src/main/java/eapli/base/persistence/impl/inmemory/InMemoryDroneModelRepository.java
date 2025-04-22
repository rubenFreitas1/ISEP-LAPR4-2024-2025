package eapli.base.persistence.impl.inmemory;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryDroneModelRepository extends InMemoryDomainRepository<DroneModel, Long>
            implements DroneModelRepository {
    @Override
    public Iterable<DroneModel> findByManufacturer(String manufacturer) {
        return match(e -> e.manufacturer().equals(manufacturer));
    }

    @Override
    public Optional<DroneModel> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }
}
