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
        cell.flip();

        assertEquals(DEAD, cell.status());
    }

    @Test
    @DisplayName("Test if Dead status is flipped to Alive Cell Status")
    void testDeadFlippedToAlive() {
        Cell cell = new Cell(DEAD);
        cell.flip();

        assertEquals(ALIVE, cell.status());
    }
}