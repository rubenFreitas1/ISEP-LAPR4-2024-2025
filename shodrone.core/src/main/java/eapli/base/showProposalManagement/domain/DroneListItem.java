package eapli.base.showProposalManagement.domain;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.showProposalManagement.dto.DroneListItemDTO;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class DroneListItem implements DTOable<DroneListItemDTO> {

    @EmbeddedId
    private DroneListItemId droneListItemId;

    @ManyToOne
    @MapsId("showProposalId")
    private ShowProposal showProposal;

    @ManyToOne
    @MapsId("droneModelId")
    private DroneModel droneModel;


    private int numberOfDrones;



    protected  DroneListItem(){
    }

    public DroneListItem(DroneModel droneModel, ShowProposal showProposal,int numberOfDrones){
        Preconditions.noneNull(new Object[] {droneModel, showProposal,numberOfDrones});
        Preconditions.ensure(numberOfDrones > 0, "Number of drones can't be negative!");
        this.droneModel = droneModel;
        this.showProposal = showProposal;
        this.numberOfDrones = numberOfDrones;
        this.droneListItemId = new DroneListItemId(droneModel.identity(), showProposal.identity());
    }

    public ShowProposal showProposal() {
        return showProposal;
    }

    public DroneModel droneModel() {
        return droneModel;
    }

    public int numberOfDrones() {
        return numberOfDrones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DroneListItem that = (DroneListItem) o;
        return Objects.equals(showProposal, that.showProposal) && Objects.equals(droneModel, that.droneModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showProposal, droneModel);
    }

    @Override
    public DroneListItemDTO toDTO() {
        return new DroneListItemDTO(droneModel.identity(), showProposal.identity(), droneModel.modelName(), numberOfDrones, droneModel.toDTO());
    }
}
