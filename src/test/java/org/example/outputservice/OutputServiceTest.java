package org.example.outputservice;

import org.example.Board;
import org.example.cell.AliveCell;
import org.example.cell.Cell;
import org.example.cell.DeadCell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OutputServiceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("test printing board with 1 alive cell and rest dead cells")
    public void testPrintWith1AliveCell2DeadCell() {
        Board board = mock(Board.class);
        AliveCell aliveCell = new AliveCell();
        DeadCell deadCell = new DeadCell();

        when(board.getCell(0, 0)).thenReturn(aliveCell);
        when(board.getCell(0, 1)).thenReturn(deadCell);
        when(board.getCell(0, 2)).thenReturn(aliveCell);

        OutputService outputService = new OutputService();
        outputService.print(board, 1, 3);

        assertEquals("X _ X \n\n", outContent.toString());
    }

    @Test
    @DisplayName("test printing a 3x3 board")
    public void testPrinting3x3board() {
        Board board = mock(Board.class);
        AliveCell aliveCell = new AliveCell();
        DeadCell deadCell = new DeadCell();

        when(board.getCell(0, 0)).thenReturn(aliveCell);
        when(board.getCell(0, 1)).thenReturn(deadCell);
        when(board.getCell(0, 2)).thenReturn(deadCell);
        when(board.getCell(1, 0)).thenReturn(deadCell);
        when(board.getCell(1, 1)).thenReturn(aliveCell);
        when(board.getCell(1, 2)).thenReturn(deadCell);
        when(board.getCell(2, 0)).thenReturn(deadCell);
        when(board.getCell(2, 1)).thenReturn(deadCell);
        when(board.getCell(2, 2)).thenReturn(aliveCell);

        OutputService outputService = new OutputService();
        outputService.print(board, 3, 3);

        assertEquals("X _ _ \n_ X _ \n_ _ X \n\n", outContent.toString());
    }

    @Test
    @DisplayName("test printing tick")
    public void printingTick3() {
        int tickvalue = 3;

        OutputService outputService = new OutputService();
        outputService.printGeneration(tickvalue);

        assertEquals("Generation 3:\n", outContent.toString());
    }

    @Test
    @DisplayName("test printing tick")
    public void printingTick342() {
        int tickvalue = 342;

        OutputService outputService = new OutputService();
        outputService.printGeneration(tickvalue);

        assertEquals("Generation 342:\n", outContent.toString());
    }
}