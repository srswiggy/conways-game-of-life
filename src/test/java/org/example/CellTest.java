package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.CellStatus.*;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    @DisplayName("Test to see if the status of cell is alive")
    void testAliveCellStatus() {
        Cell cell = new Cell(ALIVE);

        assertEquals(ALIVE, cell.status());
    }

    @Test
    @DisplayName("Test to see if the status of cell is dead")
    void testDeadCellStatus() {
        Cell cell = new Cell(DEAD);

        assertEquals(DEAD, cell.status());
    }

    @Test
    @DisplayName("Test if Alive Status is flipped to Dead Status")
    void testAliveFlippedToDead() {
        Cell cell = new Cell(ALIVE);
        cell.flipStatus();

        assertEquals(DEAD, cell.status());
    }

    @Test
    @DisplayName("Test if Dead status is flipped to Alive Cell Status")
    void testDeadFlippedToAlive() {
        Cell cell = new Cell(DEAD);
        cell.flipStatus();

        assertEquals(ALIVE, cell.status());
    }

    @Test
    @DisplayName("Test if the cell dies due to underpopulation")
    void testLiveCellStatusInUnderpopulation() {
        //arrange
        Cell cell = new Cell(ALIVE);
        int liveNeighbors = 1;
        //act
        cell.statusInNewGeneration(liveNeighbors);
        //assert
        assertEquals(DEAD, cell.status());
    }

    @Test
    @DisplayName("Test if the dead cell remains dead in underpopulation")
    void testDeadCellStatusIsDeadInUnderpopulation() {
        //arrange
        Cell cell = new Cell(DEAD);
        int liveNeighbors = 1;
        //act
        cell.statusInNewGeneration(liveNeighbors);
        //assert
        assertEquals(DEAD,cell.status());
    }

    @Test
    @DisplayName("Test if the live cell with 2 or more neighbors remains alive")
    void testLiveCellStatusWith2Neighbors() {
        Cell cell = new Cell(ALIVE);
        int liveNeighbors = 2;
        cell.statusInNewGeneration(liveNeighbors);

        assertEquals(ALIVE, cell.status());
    }

    @Test
    @DisplayName("Test if the live cell with more than 3 neighbors dies due to overpopulation")
    void testLiveCellStatusWithMoreThan3Neighbors() {
        Cell cell = new Cell(ALIVE);
        int liveNeighbors = 4;
        cell.statusInNewGeneration(liveNeighbors);

        assertEquals(DEAD, cell.status());
    }

    @Test
    @DisplayName("Test if the live cell with more than 3 neighbors dies due to overpopulation")
    void testLiveCellStatusWithMoreThan8Neighbors() {
        Cell cell = new Cell(ALIVE);
        int liveNeighbors = 8;
        cell.statusInNewGeneration(liveNeighbors);

        assertEquals(DEAD, cell.status());
    }

    @Test
    @DisplayName("Test if the live cell with 3 neighbors lives")
    void testLiveCellStatusWith3NeighborsLive() {
        Cell cell = new Cell(ALIVE);
        int liveNeighbors = 3;
        cell.statusInNewGeneration(liveNeighbors);

        assertEquals(ALIVE, cell.status());
    }

    @Test
    @DisplayName("Test if the dead cell with 3 live neighbors lives")
    void testDeadCellStatusWith3NeighborsLive() {
        Cell cell = new Cell(DEAD);
        int liveNeighbors = 3;
        cell.statusInNewGeneration(liveNeighbors);

        assertEquals(ALIVE, cell.status());
    }

    @Test
    @DisplayName("Test if the dead cell with 4 live neighbor does not lives")
    void testDeadCellStatusWith4NeighborsDoesNotLive() {
        Cell cell = new Cell(DEAD);
        int liveNeighbors = 4;
        cell.statusInNewGeneration(liveNeighbors);

        assertEquals(DEAD, cell.status());
    }
}