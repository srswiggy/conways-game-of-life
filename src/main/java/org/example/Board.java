package org.example;

import org.example.cell.AliveCell;
import org.example.cell.Cell;
import org.example.cell.DeadCell;
import org.example.neighborcalculationservice.DefaultNeighborCalculationService;
import org.example.neighborcalculationservice.NeighborCalculationService;
import org.example.outputservice.OutputService;

public class Board {
    Cells cells;
    NeighborCalculationService neighborCalculationService;

    Board(int m, int n, int seedPercentage) {
        if(m <= 0 || n <= 0 )  {
            throw new IllegalArgumentException("M, N or Seed Percentage cannot be equal or less than 0");
        }

        this.cells = new Cells(m, n, seedPercentage);
        this.neighborCalculationService = new DefaultNeighborCalculationService();
    }

    public Cell getCell(int row, int col) {
        if (row >= 0 && row < cells.grid.length && col >= 0 && col < cells.grid[0].length) {
            return cells.grid[row][col];
        }
        return new DeadCell();
    }

    protected void nextGen() {
        Cell[][] newGrid = new Cell[this.cells.grid.length][this.cells.grid[0].length];
        for(int i = 0; i < cells.grid.length; i++) {
            for(int j = 0; j < cells.grid[0].length; j++) {
                int liveNeighbors = this.neighborCalculationService.calculateNeighbors(this, i, j);
                newGrid[i][j] = this.cells.grid[i][j].nextState(liveNeighbors);
            }
        }

        this.cells.updateCells(newGrid);
    }

    void evolve() throws InterruptedException {
        OutputService outputService = new OutputService();
        int tick = 1;
        while(true) {
            outputService.printGeneration(tick);
            outputService.print(this, cells.grid.length, cells.grid[0].length);
            nextGen();
            Thread.sleep(1000);
            tick++;
        }
    }
}
