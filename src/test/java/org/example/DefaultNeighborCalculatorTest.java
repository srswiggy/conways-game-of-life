package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

class DefaultNeighborCalculatorTest {
    @Test
    @DisplayName("test if the object is getting initialized")
    void testIfDefaultNeighborObjectIsGettingInitialized() {
        assertDoesNotThrow(DefaultNeighborCalculator::new);
    }

    @Test
    @DisplayName("test cell with 0 live neighbors")
    void testFor0LiveNeighbor() {
        Board board = mock(Board.class);

        when(board.getCell(0, 0)).thenReturn(new DeadCell());
        when(board.getCell(0, 1)).thenReturn(new DeadCell());
        when(board.getCell(0, 2)).thenReturn(new DeadCell());
        when(board.getCell(1, 2)).thenReturn(new DeadCell());
        when(board.getCell(2, 2)).thenReturn(new DeadCell());
        when(board.getCell(2, 1)).thenReturn(new DeadCell());
        when(board.getCell(2, 0)).thenReturn(new DeadCell());
        when(board.getCell(1, 0)).thenReturn(new DeadCell());

        DefaultNeighborCalculator defaultNeighborCalculator = new DefaultNeighborCalculator();

        int liveNeighbors = defaultNeighborCalculator.calculateNeighbors(board, 1, 1);

        assertEquals(0, liveNeighbors);
    }

    @Test
    @DisplayName("test cell 1,1 with 2 alive and rest dead neighbor gives 2 live neighbors")
    void testFor2AliveNeighborGives2LiveNeighbor() {
        Board board = mock(Board.class);

        when(board.getCell(0, 0)).thenReturn(new AliveCell());
        when(board.getCell(0, 1)).thenReturn(new AliveCell());
        when(board.getCell(0, 2)).thenReturn(new DeadCell());
        when(board.getCell(1, 2)).thenReturn(new DeadCell());
        when(board.getCell(2, 2)).thenReturn(new DeadCell());
        when(board.getCell(2, 2)).thenReturn(new DeadCell());
        when(board.getCell(2, 1)).thenReturn(new DeadCell());
        when(board.getCell(2, 0)).thenReturn(new DeadCell());


        DefaultNeighborCalculator defaultNeighborCalculator = new DefaultNeighborCalculator();
        int numberOfLiveNeighbors = defaultNeighborCalculator.calculateNeighbors(board, 1,1);

        assertEquals(2, numberOfLiveNeighbors);
    }

    @Test
    @DisplayName("test cell with all 8 neighbors")
    void testForAll8neighbor() {
        Board board = mock(Board.class);


        when(board.getCell(0, 0)).thenReturn(new AliveCell());
        when(board.getCell(0, 1)).thenReturn(new AliveCell());
        when(board.getCell(0, 2)).thenReturn(new AliveCell());
        when(board.getCell(1, 2)).thenReturn(new AliveCell());
        when(board.getCell(2, 2)).thenReturn(new AliveCell());
        when(board.getCell(2, 1)).thenReturn(new AliveCell());
        when(board.getCell(2, 0)).thenReturn(new AliveCell());
        when(board.getCell(1, 0)).thenReturn(new AliveCell());

        DefaultNeighborCalculator defaultNeighborCalculator = new DefaultNeighborCalculator();

        int liveNeighbors = defaultNeighborCalculator.calculateNeighbors(board, 1, 1);

        assertEquals(8,liveNeighbors);
    }
}