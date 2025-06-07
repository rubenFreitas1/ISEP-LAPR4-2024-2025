package eapli.base.showProposalManagement.application;


import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.dto.DroneModelDTO;
import eapli.base.droneModelManagement.dto.DroneModelDTOParser;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.AddDroneModelsToProposalService;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.application.UseCaseController;

import java.util.Optional;


@UseCaseController
public class AddDronesToProposalController {


    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();

    private final DroneModelRepository droneModelRepository = PersistenceContext.repositories().droneModels();

    private final DroneRepository droneRepository = PersistenceContext.repositories().drones();
    private final AddDroneModelsToProposalService addDroneModelsToProposalService = new AddDroneModelsToProposalService(droneRepository);

    private final DroneModelDTOParser droneModelDTOParser = new DroneModelDTOParser();

    public Iterable<DroneModelDTO> getListDroneModels(){
        Iterable<DroneModel> list =  this.droneModelRepository.findByActive(true);
        return droneModelDTOParser.transformToDroneModelDTO(list);
    }

    public Iterable<ShowProposal> getListShowProposals(){
        return this.showProposalRepository.findByStatusAndEmptyDroneList(ShowStatus.PENDING);
    }

    public boolean addDroneModelToProposal(ShowProposal showProposal,DroneModelDTO droneModel, int quantity){
        Optional<DroneModel> droneModel1 = droneModelDTOParser.getDroneModelFromDTO(droneModel);
        if(droneModel1.isPresent()){
            return addDroneModelsToProposalService.addDroneModelToProposal(showProposal,droneModel1.get(), quantity);
        }
        return false;
    }

    public void save(ShowProposal showProposal){
        this.showProposalRepository.save(showProposal);
    }

    public int allDronesInDroneList(ShowProposal showProposal){
        return showProposal.allDroneModels_Quantity();
    }



}
