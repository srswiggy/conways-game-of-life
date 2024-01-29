package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AliveCellTest {
    @Test
    @DisplayName("test is alive always return true")
    void testIfIsAliveAlwaysReturnTrue() {
        AliveCell aliveCell = new AliveCell();

        assertTrue(aliveCell.isAlive());
    }

    @Test
    @DisplayName("Test if the cell dies due to underpopulation")
    void testLiveCellStatusInUnderpopulation() {
        //arrange
        Cell cell = new AliveCell();
        int liveNeighbors = 1;
        //act
        Cell nextStateCell = cell.nextState(liveNeighbors);
        //assert
        assertEquals(DeadCell.class, nextStateCell.getClass());
    }

    @Test
    @DisplayName("Test if the live cell with 2 or more neighbors remains alive")
    void testLiveCellStatusWith2Neighbors() {
        Cell cell = new AliveCell();
        int liveNeighbors = 2;
        Cell nextStateCell = cell.nextState(liveNeighbors);

        assertEquals(nextStateCell.getClass(), AliveCell.class);
    }

    @Test
    @DisplayName("Test if the live cell with more than 3 neighbors dies due to overpopulation")
    void testLiveCellStatusWithMoreThan3Neighbors() {
        Cell cell = new AliveCell();
        int liveNeighbors = 4;
        Cell nextStateCell = cell.nextState(liveNeighbors);

        assertEquals(nextStateCell.getClass(), DeadCell.class);
    }

    @Test
    @DisplayName("Test if the live cell with 3 neighbors lives")
    void testLiveCellStatusWith3NeighborsLive() {
        Cell cell = new AliveCell();
        int liveNeighbors = 3;
        Cell nextStateCell = cell.nextState(liveNeighbors);

        assertEquals(nextStateCell.getClass(), AliveCell.class);
    }
}