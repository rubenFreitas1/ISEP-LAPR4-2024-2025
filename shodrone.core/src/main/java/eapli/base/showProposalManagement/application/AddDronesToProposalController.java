package eapli.base.showProposalManagement.application;


import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.ProposalService;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.application.UseCaseController;


@UseCaseController
public class AddDronesToProposalController {


    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();

    private final DroneModelRepository droneModelRepository = PersistenceContext.repositories().droneModels();

    private final DroneRepository droneRepository = PersistenceContext.repositories().drones();
    private final ProposalService proposalService = new ProposalService(droneRepository);


    public Iterable<DroneModel> getListDroneModels(){
        return this.droneModelRepository.findByActive(true);
    }

    public Iterable<ShowProposal> getListShowProposals(){
        return this.showProposalRepository.findByStatusAndEmptyDroneList(ShowStatus.PENDING);
    }

    public boolean addDroneModelToProposal(ShowProposal showProposal,DroneModel droneModel, int quantity){
        return proposalService.addDroneModelToProposal(showProposal,droneModel, quantity);
    }

    public void save(ShowProposal showProposal){
        this.showProposalRepository.save(showProposal);
    }

    public int allDronesInDroneList(ShowProposal showProposal){
        return showProposal.allDroneModels_Quantity();
    }

}
