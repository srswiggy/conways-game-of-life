package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadCellTest {
    @Test
    @DisplayName("test is alive always return false")
    void testIfIsAliveAlwaysReturnTrue() {
        DeadCell deadCell = new DeadCell();

        assertFalse(deadCell.isAlive());
    }

    @Test
    @DisplayName("Test if the dead cell with 3 live neighbors lives")
    void testDeaRdCellStatusWith3NeighborsLive() {
        Cell cell = new DeadCell();
        int liveNeighbors = 3;
        Cell nextStateCell = cell.nextState(liveNeighbors);

        assertEquals(nextStateCell.getClass(), AliveCell.class);
    }

    @Test
    @DisplayName("Test if the dead cell with 4 live neighbor does not lives")
    void testDeadCellStatusWith4NeighborsDoesNotLive() {
        Cell cell = new DeadCell();
        int liveNeighbors = 4;
        Cell nextStateCell = cell.nextState(liveNeighbors);

        assertEquals(nextStateCell.getClass(), DeadCell.class);
    }
}