package eapli.base.showProposalManagement.domain;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showProposalManagement.dto.FigureListItemDTO;
import eapli.framework.representations.dto.DTOable;
import jakarta.persistence.*;

import java.util.Objects;
 @Entity
public class FigureListItem implements DTOable<FigureListItemDTO> {

    @EmbeddedId
    private FigureListItemID figureListItemID;

    @ManyToOne
    @MapsId("showProposalId")
    private ShowProposal showProposal;

    @ManyToOne
    @MapsId("figureId")
    private Figure figure;

    @ManyToOne
    @MapsId("droneModelId")
    private DroneModel droneModel;


    protected FigureListItem() {
    }

    public FigureListItem(Figure figure, DroneModel droneModel, ShowProposal showProposal, int sequenceNumber) {
        this.figure = figure;
        this.droneModel = droneModel;
        this.showProposal = showProposal;
        this.figureListItemID = new FigureListItemID(figure.identity(), droneModel.identity(), showProposal.identity(), sequenceNumber);
    }

    public ShowProposal showProposal() {
        return showProposal;
    }

    public Figure figure() {
        return figure;
    }

    public DroneModel droneModel() {
        return droneModel;
    }

    public FigureListItemID figureListItemID(){return this.figureListItemID;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FigureListItem that = (FigureListItem) o;
        return Objects.equals(showProposal, that.showProposal) && Objects.equals(droneModel, that.droneModel) && Objects.equals(figure, that.figure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showProposal, droneModel, figure);
    }


     @Override
     public FigureListItemDTO toDTO() {
         return new FigureListItemDTO(figure.figureId(), showProposal.showProposalId(), figure.description());
     }
 }
