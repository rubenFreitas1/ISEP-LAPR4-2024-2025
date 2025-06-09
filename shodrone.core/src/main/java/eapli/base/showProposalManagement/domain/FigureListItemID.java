package eapli.base.showProposalManagement.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FigureListItemID implements Serializable {

    private Long figureId;
    private Long droneModelId;
    private Long showProposalId;
    private int sequenceNumber;

    protected FigureListItemID() {

    }

    public FigureListItemID(Long figureId, Long droneModelId, Long showProposalId, int sequenceNumber) {
        this.figureId = figureId;
        this.droneModelId = droneModelId;
        this.showProposalId = showProposalId;
        this.sequenceNumber = sequenceNumber;
    }


    public Long figureId() {
        return figureId;
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
        FigureListItemID that = (FigureListItemID) o;
        return Objects.equals(figureId, that.figureId) &&
                Objects.equals(droneModelId, that.droneModelId) &&
                Objects.equals(showProposalId, that.showProposalId) &&
                Objects.equals(sequenceNumber, that.sequenceNumber);

    }

    @Override
    public int hashCode() {
        return Objects.hash(figureId, droneModelId, showProposalId, sequenceNumber);
    }
}