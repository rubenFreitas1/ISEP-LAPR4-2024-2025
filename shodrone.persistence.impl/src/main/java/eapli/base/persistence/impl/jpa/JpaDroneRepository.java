package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaDroneRepository extends JpaAutoTxRepository<Drone, Long, Long> implements DroneRepository {

    public JpaDroneRepository(TransactionalContext context){super(context, "droneId");}

    public JpaDroneRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(), "droneId");
    }


    @Override
    public Iterable<Drone> findByDroneModel(DroneModel droneModel) {
        final Map<String, Object> params = new HashMap<>();
        params.put("droneModel", droneModel);
        return match("e.droneModel=:droneModel", params);
    }

    @Override
    public boolean isSerialNameUsed(String serialNumber) {
        final Map<String, Object> params = new HashMap<>();
        params.put("serialNumber", serialNumber);
        return matchOne("e.serialNumber = :serialNumber", params).isPresent();
    }

    @Override
    public Optional<Drone> findById(final Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.droneId = :id", params);
    }
}
