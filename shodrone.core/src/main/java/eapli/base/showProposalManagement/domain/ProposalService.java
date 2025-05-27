package eapli.base.showProposalManagement.domain;

import eapli.base.droneManagement.domain.Drone;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.domain.DroneModel;

public class ProposalService {

    private final DroneRepository droneRepository;

    public ProposalService(final DroneRepository droneRepository){
        this.droneRepository = droneRepository;
    }

    public boolean addDroneModelToProposal(ShowProposal showProposal, DroneModel droneModel, int quantity){
        if(showProposal == null){
            throw new IllegalArgumentException("Show Proposal cannot be null!");
        }
        if(droneModel == null){
            throw new IllegalArgumentException("Drone Model cannot be null!");
        }
        if(numberDronesOfDroneModel(droneModel) < quantity){
            throw new IllegalArgumentException("Not enough Drones with this Drone Model Registered in the System!");
        }
        return showProposal.addDroneToList(droneModel, quantity);
    }



    private int numberDronesOfDroneModel(DroneModel droneModel){
        int numberOfDrones = 0;
        Iterable<Drone> drones = this.droneRepository.findByDroneModel(droneModel);
        for (Drone drone : drones){
            numberOfDrones++;
        }
        return  numberOfDrones;
    }
}
