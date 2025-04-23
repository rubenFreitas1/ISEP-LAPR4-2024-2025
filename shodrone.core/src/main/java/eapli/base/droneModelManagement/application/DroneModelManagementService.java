package eapli.base.droneModelManagement.application;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneModelBuilder;
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

    public DroneModel registerNewDroneModel(final String modelName, final String manufacturer, final Calendar createdOn, final SystemUser createdBy){
        if(isModelNameUsed(droneModelRepository, modelName)){
            throw new IllegalArgumentException("This Model Name is already registered in the system!");
        }
        DroneModelBuilder droneModelBuilder = new DroneModelBuilder();
        droneModelBuilder.withModelName(modelName).withManufacturer(manufacturer).createdOn(createdOn).createdBy(createdBy);
        DroneModel newDroneModel = droneModelBuilder.build();
        return (DroneModel) this.droneModelRepository.save(newDroneModel);
    }


    public DroneModel registerNewDroneModel(final String modelName, final String manufacturer, final SystemUser createdBy){
        return registerNewDroneModel(modelName, manufacturer, CurrentTimeCalendars.now(), createdBy);
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

    public Iterable<DroneModel> listDroneModels(){return this.droneModelRepository.findByActive(true);}


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
