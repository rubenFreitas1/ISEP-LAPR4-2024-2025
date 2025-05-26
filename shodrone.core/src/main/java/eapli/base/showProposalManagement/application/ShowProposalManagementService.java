package eapli.base.showProposalManagement.application;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.ShowProposalStatus;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalTime;
import java.util.Calendar;

public class ShowProposalManagementService {
    private final ShowProposalRepository showProposalRepository;

    public ShowProposalManagementService(final ShowProposalRepository showProposalRepository) {
        this.showProposalRepository = showProposalRepository;
    }

    public ShowProposal registerShowProposal(ShowRequest showRequest, GeoLocation location, Calendar date, LocalTime time, int duration, int totalDroneNumber, SystemUser user) {
        long proposalCount = showProposalRepository.countByShowRequest(showRequest);
        int proposalNumber = (int) proposalCount + 1;

        ShowProposal showProposal = new ShowProposal(showRequest, location, date, time, duration, totalDroneNumber, proposalNumber, user, ShowProposalStatus.PENDING);
        return (ShowProposal) this.showProposalRepository.save(showProposal);
    }

    public boolean addDroneModelToProposal(ShowProposal showProposal, DroneModel droneModel,int quantity){
        if(showProposal == null){
            throw new IllegalArgumentException("Show Proposal cannot be null!");
        }
        if(droneModel == null){
            throw new IllegalArgumentException("Drone Model cannot be null!");
        }
        return showProposal.addDroneToList(droneModel, quantity);
    }
}
