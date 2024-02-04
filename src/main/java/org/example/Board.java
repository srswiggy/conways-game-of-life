package org.example;

import org.example.cell.AliveCell;
import org.example.cell.Cell;
import org.example.cell.DeadCell;
import org.example.neighborcalculationservice.DefaultNeighborCalculationService;
import org.example.neighborcalculationservice.NeighborCalculationService;
import org.example.outputservice.OutputService;

import java.util.Random;

public class Board {
    Cell[][] grid;
    NeighborCalculationService neighborCalculationService;

    Board(int m, int n, int seedPercentage) {
        if(m <= 0 || n <= 0 )  {
            throw new IllegalArgumentException("M, N or Seed Percentage cannot be equal or less than 0");
        }
        this.grid = new Cell[m][n];
        this.neighborCalculationService = new DefaultNeighborCalculationService();
        initializeBoardCellsDead();
        setInitialSeeds(m, n, seedPercentage);
    }

    void initializeBoardCellsDead() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                this.grid[i][j] = new DeadCell();
            }
        }
    }

    void setInitialSeeds(int m, int n, int seedPercentage) {
        System.out.println("inside initial seeds");

        Random random = new Random();
        int totalCells = m*n;
        double seedPerc = seedPercentage * 0.01;
        int cellsToSeed = (int)(totalCells * seedPerc);
//        System.out.println(cellsToSeed);

        while(cellsToSeed > 0) {

            int randomRow = random.nextInt(m);
            int randomCol = random.nextInt(n);
//            System.out.println(randomRow + " " + randomCol);
            this.grid[randomRow][randomCol] = new AliveCell();
            cellsToSeed--;
        }
    }

    public Cell getCell(int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
//            System.out.println("get cell");
            return grid[row][col];
        }
        return new DeadCell();
    }

    private void nextGen() {
//        System.out.println("inside nextgen");
        Cell[][] newGrid = new Cell[this.grid.length][this.grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int liveNeighbors = this.neighborCalculationService.calculateNeighbors(this, i, j);
                newGrid[i][j] = this.grid[i][j].nextState(liveNeighbors);
            }
        }

        this.grid = newGrid;
    }

//    public void display() {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                System.out.print(grid[i][j].toString() + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    void evolve() throws InterruptedException {
        OutputService outputService = new OutputService();
        while(true) {

            outputService.display(this, grid.length, grid[0].length);
            nextGen();
            Thread.sleep(1000);
        }
    }
}
