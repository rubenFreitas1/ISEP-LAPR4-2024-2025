package eapli.base.showProposalManagement.dto;

public class FigureListItemDTO {

    private Long figureId;
    private Long showProposalId;
    private String figureDescription;

    public FigureListItemDTO() {}
    public FigureListItemDTO(Long figureId, Long showProposalId, String figureDescription) {
        this.figureId = figureId;
        this.showProposalId = showProposalId;
        this.figureDescription = figureDescription;
    }

    public Long getShowProposalId() {
        return showProposalId;
    }

    public String getFigureDescription() {
        return figureDescription;
    }

    public Long getFigureId() {
        return figureId;
    }
}
