package eapli.base.droneModelManagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindIntervalTest {

    @Test
    void constructor_validValues_shouldCreateWindInterval() {
        WindInterval interval = new WindInterval(0, 10, 0.5);
        assertEquals(0, interval.min());
        assertEquals(10, interval.max());
        assertEquals(0.5, interval.tolerance());
    }

    @Test
    void constructor_negativeMin_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new WindInterval(-1, 10, 0.5));
    }

    @Test
    void constructor_negativeMax_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new WindInterval(0, -5, 0.5));
    }

    @Test
    void constructor_minGreaterThanOrEqualToMax_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new WindInterval(10, 10, 0.5));
        assertThrows(IllegalArgumentException.class, () -> new WindInterval(15, 10, 0.5));
    }

    @Test
    void contains_insideInterval_shouldReturnTrue() {
        WindInterval interval = new WindInterval(0, 10, 0.5);
        assertTrue(interval.contains(5));
        assertTrue(interval.contains(10));
    }

    @Test
    void contains_outsideInterval_shouldReturnFalse() {
        WindInterval interval = new WindInterval(0, 10, 0.5);
        assertFalse(interval.contains(-1));
        assertFalse(interval.contains(10.0001));
    }

    @Test
    void overlaps_withOverlappingInterval_shouldReturnTrue() {
        WindInterval interval1 = new WindInterval(0, 10, 0.5);
        WindInterval interval2 = new WindInterval(5, 15, 0.8);
        assertTrue(interval1.overlaps(interval2));
    }

    @Test
    void overlaps_withNonOverlappingInterval_shouldReturnFalse() {
        WindInterval interval1 = new WindInterval(0, 5, 0.5);
        WindInterval interval2 = new WindInterval(5.001, 10, 0.8);
        assertFalse(interval1.overlaps(interval2));
    }

    @Test
    void equals_sameMinMax_shouldReturnTrue() {
        WindInterval interval1 = new WindInterval(0, 10, 0.5);
        WindInterval interval2 = new WindInterval(0, 10, 0.8);
        assertEquals(interval1, interval2);
    }

    @Test
    void equals_differentMinOrMax_shouldReturnFalse() {
        WindInterval interval1 = new WindInterval(0, 10, 0.5);
        WindInterval interval2 = new WindInterval(1, 10, 0.5);
        WindInterval interval3 = new WindInterval(0, 11, 0.5);

        assertNotEquals(interval1, interval2);
        assertNotEquals(interval1, interval3);
    }

    @Test
    void hashCode_shouldBeConsistentWithEquals() {
        WindInterval interval1 = new WindInterval(0, 10, 0.5);
        WindInterval interval2 = new WindInterval(0, 10, 0.9);
        assertEquals(interval1.hashCode(), interval2.hashCode());
    }

    @Test
    void toString_shouldContainAllValues() {
        WindInterval interval = new WindInterval(1, 5, 0.7);
        String result = interval.toString();
        assertTrue(result.contains("min=1.0"));
        assertTrue(result.contains("max=5.0"));
        assertTrue(result.contains("tolerance=0.7"));
    }

}