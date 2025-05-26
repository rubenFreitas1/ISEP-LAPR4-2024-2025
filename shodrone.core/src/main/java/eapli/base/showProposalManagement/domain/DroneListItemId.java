package eapli.base.showProposalManagement.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DroneListItemId implements Serializable {


    private Long droneModelId;


    private Long showProposalId;

    protected DroneListItemId(){
    }


    public DroneListItemId( Long droneModelId, Long showProposalId){
        this.droneModelId = droneModelId;
        this.showProposalId = showProposalId;
    }

    public Long droneModelId() {
        return droneModelId;
    }

    public Long showProposalId() {
        return showProposalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DroneListItemId that = (DroneListItemId) o;
        return Objects.equals(droneModelId, that.droneModelId) && Objects.equals(showProposalId, that.showProposalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droneModelId, showProposalId);
    }

    @Override
    public String toString() {
        return "DroneListItemId{" +
                "droneModelId=" + droneModelId +
                ", showProposalId=" + showProposalId +
                '}';
    }
}
