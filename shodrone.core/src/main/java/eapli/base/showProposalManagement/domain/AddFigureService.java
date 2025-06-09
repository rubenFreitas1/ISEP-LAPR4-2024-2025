package eapli.base.showProposalManagement.domain;

import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.droneModelManagement.domain.DroneModel;

public class AddFigureService {

    private final FigureRepository figureRepository;

    public AddFigureService(final FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }

    public boolean addFigureWithDroneModel(ShowProposal showProposal, Figure figure, DroneModel droneModel, int sequenceNumber) {
        if (showProposal == null || figure == null || droneModel == null) {
            throw new IllegalArgumentException("ShowProposal, Figure, or DroneModel cannot be null!");
        }
        if (!figureRepository.findById(figure.identity()).isPresent()) {
            throw new IllegalArgumentException("Figure does not exist in the system!");
        }

        return showProposal.addFigureWithDroneModel(figure, droneModel, sequenceNumber);
    }
}