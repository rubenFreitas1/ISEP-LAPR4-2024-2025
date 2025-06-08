package eapli.base.showProposalManagement.application;


import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.dto.DroneModelDTO;
import eapli.base.droneModelManagement.dto.DroneModelDTOParser;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.AddDroneModelsToProposalService;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTOParser;
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

    private final ShowProposalDTOParser showProposalDTOParser = new ShowProposalDTOParser();

    public Iterable<DroneModelDTO> getListDroneModels(){
        Iterable<DroneModel> list =  this.droneModelRepository.findByActive(true);
        return droneModelDTOParser.transformToDroneModelDTO(list);
    }

    public Iterable<ShowProposalDTO> getListShowProposals(){
        Iterable<ShowProposal> showProposals = this.showProposalRepository.findByStatusAndEmptyDroneList(ShowStatus.PENDING);
        return showProposalDTOParser.transformToShowProposalDTOlist(showProposals);
    }

    public boolean addDroneModelToProposal(ShowProposalDTO showProposalDTO,DroneModelDTO droneModelDTO, int quantity){
        Optional<DroneModel> droneModel = droneModelDTOParser.getDroneModelFromDTO(droneModelDTO);
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        if(droneModel.isPresent() & showProposal.isPresent()){
            return addDroneModelsToProposalService.addDroneModelToProposal(showProposal.get(),droneModel.get(), quantity);
        }
        return false;
    }

    public boolean save(ShowProposalDTO showProposalDTO){
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        if (showProposal.isPresent()){
            this.showProposalRepository.save(showProposal.get());
            return true;
        }
        return false;
    }

    public int allDronesInDroneList(ShowProposalDTO showProposalDTO){
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        return showProposal.get().allDroneModels_Quantity();
    }



}
