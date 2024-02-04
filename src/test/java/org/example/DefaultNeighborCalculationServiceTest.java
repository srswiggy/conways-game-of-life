package org.example;

import org.example.cell.AliveCell;
import org.example.cell.DeadCell;
import org.example.neighborcalculationservice.DefaultNeighborCalculationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

class DefaultNeighborCalculationServiceTest {
    @Test
    @DisplayName("test if the object is getting initialized")
    void testIfDefaultNeighborObjectIsGettingInitialized() {
        assertDoesNotThrow(DefaultNeighborCalculationService::new);
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

        DefaultNeighborCalculationService defaultNeighborCalculator = new DefaultNeighborCalculationService();

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


        DefaultNeighborCalculationService defaultNeighborCalculator = new DefaultNeighborCalculationService();
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

        DefaultNeighborCalculationService defaultNeighborCalculator = new DefaultNeighborCalculationService();

        int liveNeighbors = defaultNeighborCalculator.calculateNeighbors(board, 1, 1);

        assertEquals(8,liveNeighbors);
    }
}