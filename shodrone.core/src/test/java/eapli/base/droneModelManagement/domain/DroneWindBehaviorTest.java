package eapli.base.droneModelManagement.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneWindBehaviorTest {
    private DroneWindBehavior behavior;

    @BeforeEach
    void setUp() {
        behavior = new DroneWindBehavior();
    }

    @Test
    void addTolerance_validInterval_shouldAddSuccessfully_X() {
        boolean result = behavior.addTolerance(Axis.X, 0, 10, 1.0);
        assertTrue(result);
    }

    @Test
    void addTolerance_validInterval_shouldAddSuccessfully_Y() {
        boolean result = behavior.addTolerance(Axis.Y, 5, 15, 1.2);
        assertTrue(result);
    }

    @Test
    void addTolerance_validInterval_shouldAddSuccessfully_Z() {
        boolean result = behavior.addTolerance(Axis.Z, 10, 20, 0.9);
        assertTrue(result);
    }

    @Test
    void addTolerance_invalidInterval_minGreaterThanMax_shouldReturnFalse() {
        boolean result = behavior.addTolerance(Axis.X, 10, 5, 0.5);
        assertFalse(result);
    }

    @Test
    void addTolerance_overlappingInterval_shouldReturnFalse() {
        behavior.addTolerance(Axis.X, 0, 10, 1.0);
        boolean result = behavior.addTolerance(Axis.X, 5, 15, 1.5);
        assertFalse(result);
    }

    @Test
    void addTolerance_lowerToleranceThanExisting_shouldReturnFalse() {
        behavior.addTolerance(Axis.Y, 0, 10, 1.0);
        boolean result = behavior.addTolerance(Axis.Y, 10.0001, 20, 0.5);
        assertFalse(result);
    }

    @Test
    void addTolerance_sameIntervalDifferentAxis_shouldWorkIndependently() {
        behavior.addTolerance(Axis.X, 0, 10, 1.0);
        boolean result = behavior.addTolerance(Axis.Y, 0, 10, 1.0);
        assertTrue(result);
    }

    @Test
    void addTolerance_multipleValidIntervalsNonOverlapping_shouldAllBeAdded() {
        assertTrue(behavior.addTolerance(Axis.Z, 0, 5, 0.5));
        assertTrue(behavior.addTolerance(Axis.Z, 5.1, 10, 0.6));
        assertTrue(behavior.addTolerance(Axis.Z, 10.1, 15, 0.8));
    }

}