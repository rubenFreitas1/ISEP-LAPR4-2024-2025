package eapli.base.showProposalManagement.dto;

import eapli.base.droneModelManagement.dto.DroneModelDTO;
import eapli.framework.representations.dto.DTO;

@DTO
public class DroneListItemDTO{

    private Long droneModelId;
    private Long showProposalId;
    private String droneModelName;
    private DroneModelDTO droneModelDTO;

    private int numberOfDrones;

    public DroneListItemDTO(){}
    public DroneListItemDTO(Long droneModelId, Long showProposalId, String droneModelName, int numberOfDrones, DroneModelDTO droneModelDTO) {
        this.droneModelId = droneModelId;
        this.showProposalId = showProposalId;
        this.droneModelName = droneModelName;
        this.numberOfDrones = numberOfDrones;
        this.droneModelDTO = droneModelDTO;
    }

    public DroneModelDTO getDroneModelDTO() {
        return droneModelDTO;
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
