package eapli.base.showProposalManagement.domain;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddFigureServiceTest {

    private AddFigureService service;
    private FigureRepository figureRepository;
    private ShowProposal showProposal;
    private Figure figure;
    private DroneModel droneModel;

    @BeforeEach
    void setUp() {
        figureRepository = mock(FigureRepository.class);
        service = new AddFigureService(figureRepository);
        showProposal = mock(ShowProposal.class);
        figure = mock(Figure.class);
        droneModel = mock(DroneModel.class);

        when(figure.identity()).thenReturn(1L);
    }

    @Test
    void addFigureWithDroneModel_Success() {
        when(figureRepository.findById(1L)).thenReturn(Optional.of(figure));
        when(showProposal.addFigureWithDroneModel(figure, droneModel, 1)).thenReturn(true);

        boolean result = service.addFigureWithDroneModel(showProposal, figure, droneModel, 1);

        assertTrue(result);
        verify(showProposal, times(1)).addFigureWithDroneModel(figure, droneModel, 1);
    }

    @Test
    void addFigureWithDroneModel_Fail_NullShowProposal() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            service.addFigureWithDroneModel(null, figure, droneModel, 1);
        });
        assertEquals("ShowProposal, Figure, or DroneModel cannot be null!", ex.getMessage());
    }

    @Test
    void addFigureWithDroneModel_Fail_NullFigure() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            service.addFigureWithDroneModel(showProposal, null, droneModel, 1);
        });
        assertEquals("ShowProposal, Figure, or DroneModel cannot be null!", ex.getMessage());
    }

    @Test
    void addFigureWithDroneModel_Fail_NullDroneModel() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            service.addFigureWithDroneModel(showProposal, figure, null, 1);
        });
        assertEquals("ShowProposal, Figure, or DroneModel cannot be null!", ex.getMessage());
    }

    @Test
    void addFigureWithDroneModel_Fail_FigureNotInRepository() {
        when(figureRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            service.addFigureWithDroneModel(showProposal, figure, droneModel, 1);
        });
        assertEquals("Figure does not exist in the system!", ex.getMessage());
    }
}