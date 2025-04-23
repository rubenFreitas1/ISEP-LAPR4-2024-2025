package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaDroneModelRepository extends JpaAutoTxRepository<DroneModel, Long, Long> implements DroneModelRepository{


    public JpaDroneModelRepository(TransactionalContext autoTx){super(autoTx, "droneModelId");}

    public JpaDroneModelRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "droneModelId");
    }


    @Override
    public Iterable<DroneModel> findByManufacturer(final String manufacturer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("manufacturer", manufacturer);
        return match("e.manufacturer=:manufacturer", params);
    }

    @Override
    public boolean isDroneModelNameUsed(String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.modelName = :name", params).isPresent();
    }

    @Override
    public Optional<DroneModel> findById(final Long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return matchOne("e.droneModelId = :id", params);
    }

}
