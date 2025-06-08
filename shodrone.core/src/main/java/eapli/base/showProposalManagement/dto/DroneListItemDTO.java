package eapli.base.showProposalManagement.dto;

import eapli.framework.representations.dto.DTO;

@DTO
public class DroneListItemDTO{

    private Long droneModelId;
    private Long showProposalId;
    private String droneModelName;

    private int numberOfDrones;

    public DroneListItemDTO(){}
    public DroneListItemDTO(Long droneModelId, Long showProposalId, String droneModelName, int numberOfDrones) {
        this.droneModelId = droneModelId;
        this.showProposalId = showProposalId;
        this.droneModelName = droneModelName;
        this.numberOfDrones = numberOfDrones;
    }

    public Long getDroneModelId() {
        return droneModelId;
    }

    public Long getShowProposalId() {
        return showProposalId;
    }

    public String getDroneModelName() {
        return droneModelName;
    }

    public int getNumberOfDrones() {
        return numberOfDrones;
    }
}
