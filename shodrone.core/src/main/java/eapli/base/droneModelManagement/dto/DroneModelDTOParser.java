package eapli.base.droneModelManagement.dto;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DroneModelDTOParser {

    private final DroneModelRepository droneModelRepository = PersistenceContext.repositories().droneModels();

    public Iterable<DroneModelDTO> transformToDroneModelDTO(final Iterable<DroneModel> droneModels){
        return StreamSupport.stream(droneModels.spliterator(), true).map(DroneModel::toDTO).collect(Collectors.toUnmodifiableList());
    }

    public Optional<DroneModel> getDroneModelFromDTO(final DroneModelDTO droneModel){
        return this.droneModelRepository.findById(droneModel.getDroneModelId());
    }

}
