package org.example;

import org.example.cell.AliveCell;
import org.example.cell.DeadCell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    @DisplayName("Test if the board is getting created successfully")
    void testIfBoardGetsCreatedWithMN() {
        assertDoesNotThrow(()-> new Board(2, 3, 20));
    }

    @Test
    @DisplayName("Test if the board creation throws error on negative values")
    void testIfBoardGetsThrowsExceptionWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, ()-> new Board(-2, -5, -20));
    }

    @Test
    @DisplayName("Test if the board creation throws error on 0")
    void testIfBoardGetsThrowsExceptionWith0() {
        assertThrows(IllegalArgumentException.class, ()-> new Board(0, 0, 0));
    }

    @Test
    @DisplayName("test if the getcell method returns alive cells for all alive cells")
    void testIfGetCellreturnsAliveCellsForAliveCells() {
        Board board = new Board(20, 20, 100);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                assertEquals(AliveCell.class, board.getCell(i, j).getClass());
            }
        }
    }

    @Test
    @DisplayName("Test if the initialized object has all the dead cells")
    void testGridInitializationhasAllDeadCells() {
        Board board = new Board(30, 30,0);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                assertEquals(DeadCell.class, board.getCell(i, j).getClass());
            }
        }

    }

    @Test
    @DisplayName("Test if the seed is is 50% and the alive cells are 50%")
    void testSetSeedFunctionFor50Percentage() {
        Board board = new Board(30, 30,50);

        int aliveCellCount = 0;
        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                if(board.getCell(i, j).getClass() == AliveCell.class) {
                    aliveCellCount++;
                }
            }
        }

        assertEquals(450, aliveCellCount);

    }

    @Test
    @DisplayName("Test if the seed is is 70% and the alive cells are 70%")
    void testSetSeedFunctionFor70Percentage() {
        Board board = new Board(30, 30,70);

        int aliveCellCount = 0;
        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                if(board.getCell(i, j).getClass() == AliveCell.class) {
                    aliveCellCount++;
                }
            }
        }

        assertEquals(630, aliveCellCount);

    }
}