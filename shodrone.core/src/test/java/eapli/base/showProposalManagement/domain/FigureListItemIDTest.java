package eapli.base.showProposalManagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureListItemIDTest {

    @Test
    void ensureFigureListItemIDIsCreatedSuccessfully() {
        FigureListItemID id = new FigureListItemID(1L, 2L, 3L, 4);
        assertNotNull(id);
        assertEquals(1L, id.figureId());
        assertEquals(2L, id.droneModelId());
        assertEquals(3L, id.showProposalId());
    }

    @Test
    void ensureEqualsWorksCorrectly() {
        FigureListItemID id1 = new FigureListItemID(1L, 2L, 3L, 4);
        FigureListItemID id2 = new FigureListItemID(1L, 2L, 3L, 4);
        assertEquals(id1, id2);
    }

    @Test
    void ensureHashCodeIsConsistent() {
        FigureListItemID id1 = new FigureListItemID(1L, 2L, 3L, 4);
        FigureListItemID id2 = new FigureListItemID(1L, 2L, 3L, 4);
        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void ensureNotEqualsForDifferentObjects() {
        FigureListItemID id1 = new FigureListItemID(1L, 2L, 3L, 4);
        FigureListItemID id2 = new FigureListItemID(5L, 6L, 7L, 8);
        assertNotEquals(id1, id2);
    }
}