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
    public Iterable<DroneModel> findByActive(boolean active) {
            return this.match((e) -> {
                return e.isActive() == active;
            });

    }

    @Override
    public boolean isDroneModelNameUsed(String name) {
        return matchOne(e -> e.modelName().equalsIgnoreCase(name)).isPresent();
    }

    @Override
    public Optional<DroneModel> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }
}
