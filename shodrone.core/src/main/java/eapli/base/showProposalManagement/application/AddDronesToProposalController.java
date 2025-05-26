package eapli.base.showProposalManagement.application;


import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.ShowProposalStatus;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.framework.application.UseCaseController;


@UseCaseController
public class AddDronesToProposalController {


    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();

    private final ShowProposalManagementService showProposalManagementService = new ShowProposalManagementService(showProposalRepository);

    private final DroneModelRepository droneModelRepository = PersistenceContext.repositories().droneModels();


    public Iterable<DroneModel> getListDroneModels(){
        return this.droneModelRepository.findByActive(true);
    }

    public Iterable<ShowProposal> getListShowProposals(){
        return this.showProposalRepository.findByStatusAndEmptyDroneList(ShowProposalStatus.PENDING);
    }

    public boolean addDroneModelToProposal(ShowProposal showProposal,DroneModel droneModel, int quantity){
        return showProposalManagementService.addDroneModelToProposal(showProposal,droneModel, quantity);
    }

    public void save(ShowProposal showProposal){
        this.showProposalRepository.save(showProposal);
    }

    public int allDronesInDroneList(ShowProposal showProposal){
        return showProposal.allDroneModels_Quantity();
    }

}
