package eapli.base.showProposalManagement.domain;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.figureManagement.domain.Figure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FigureListItemTest {

    private Figure figure;
    private DroneModel droneModel;
    private ShowProposal showProposal;
    private FigureListItem figureListItem;

    @BeforeEach
    void setUp() {
        figure = mock(Figure.class);
        droneModel = mock(DroneModel.class);
        showProposal = mock(ShowProposal.class);
        figureListItem = new FigureListItem(figure, droneModel, showProposal, 1);
    }

    @Test
    void ensureFigureListItemIsCreatedSuccessfully() {
        assertNotNull(figureListItem);
        assertEquals(figure, figureListItem.figure());
        assertEquals(droneModel, figureListItem.droneModel());
        assertEquals(showProposal, figureListItem.showProposal());
    }

    @Test
    void ensureEqualsWorksCorrectly() {
        FigureListItem anotherItem = new FigureListItem(figure, droneModel, showProposal, 1);
        assertEquals(figureListItem, anotherItem);
    }

    @Test
    void ensureHashCodeIsConsistent() {
        FigureListItem anotherItem = new FigureListItem(figure, droneModel, showProposal, 1);
        assertEquals(figureListItem.hashCode(), anotherItem.hashCode());
    }

    @Test
    void ensureNotEqualsForDifferentObjects() {
        Figure differentFigure = mock(Figure.class);
        FigureListItem differentItem = new FigureListItem(differentFigure, droneModel, showProposal, 1);
        assertNotEquals(figureListItem, differentItem);
    }
}