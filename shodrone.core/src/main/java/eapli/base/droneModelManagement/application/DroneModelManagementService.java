package eapli.base.droneModelManagement.application;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Optional;

@Component
public class DroneModelManagementService {

    private final DroneModelRepository droneModelRepository;

    public DroneModelManagementService(final DroneModelRepository droneModelRepository){
        this.droneModelRepository = droneModelRepository;
    }

    public DroneModel registerNewDroneModel(final String modelName, final String manufacturer, final Calendar createdOn, final SystemUser createdBy, final DroneWindBehavior windBehavior){
        if(isModelNameUsed(droneModelRepository, modelName)){
            throw new IllegalArgumentException("This Model Name is already registered in the system!");
        }
        if(windBehavior == null){
            throw new IllegalArgumentException("Wind Behavior cannot be null!");
        }
        if (createdBy == null){
            throw new IllegalArgumentException("Created By cannot be null!");
        }
        DroneModel newDroneModel = new DroneModel(modelName, manufacturer, createdOn, createdBy, windBehavior);
        return (DroneModel) this.droneModelRepository.save(newDroneModel);
    }


    public DroneModel registerNewDroneModel(final String modelName, final String manufacturer, final SystemUser createdBy, final DroneWindBehavior windBehavior){
        return registerNewDroneModel(modelName, manufacturer, CurrentTimeCalendars.now(), createdBy, windBehavior);
    }

    public Optional<DroneModel> findById(final Long id){
        return this.droneModelRepository.findById(id);
    }

    public Iterable<DroneModel> findByManufacturer(final String manufacturer){
        return this.droneModelRepository.findByManufacturer(manufacturer);
    }

    public Iterable<DroneModel> findAll(){
        return this.droneModelRepository.findAll();
    }

    public Iterable<DroneModel> listActiveDroneModels(){return this.droneModelRepository.findByActive(true);}


    public DroneModel deactivateDroneModel(final DroneModel droneModel) {
        droneModel.deactivate(CurrentTimeCalendars.now());
        return (DroneModel) this.droneModelRepository.save(droneModel);
    }

    public DroneModel activateDroneModel(final DroneModel droneModel) {
        droneModel.activate();
        return (DroneModel) this.droneModelRepository.save(droneModel);
    }


    public boolean isModelNameUsed(DroneModelRepository repo, String modelName){
        return repo.isDroneModelNameUsed(modelName);
    }
}
