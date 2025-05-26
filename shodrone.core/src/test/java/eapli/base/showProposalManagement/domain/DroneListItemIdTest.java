package eapli.base.showProposalManagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneListItemIdTest {

    @Test
    void testConstructorAndGetters() {
        Long droneModelId = 1L;
        Long showProposalId = 2L;

        DroneListItemId id = new DroneListItemId(droneModelId, showProposalId);

        assertEquals(droneModelId, id.droneModelId());
        assertEquals(showProposalId, id.showProposalId());
    }

    @Test
    void testEqualsAndHashCode() {
        DroneListItemId id1 = new DroneListItemId(1L, 2L);
        DroneListItemId id2 = new DroneListItemId(1L, 2L);
        DroneListItemId id3 = new DroneListItemId(2L, 3L);

        assertEquals(id1, id2);
        assertEquals(id1.hashCode(), id2.hashCode());
        assertNotEquals(id1, id3);
    }

}