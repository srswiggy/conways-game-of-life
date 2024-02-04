package org.example;

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
        display();
        setInitialSeeds(m, n, seedPercentage);
    }

    void initializeBoardCellsDead() {
//        System.out.println("inside inititalize board cell");

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

    public void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print((grid[i][j].getClass() == AliveCell.class) ? "X " : "_ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void evolve() throws InterruptedException {
//        System.out.println("inside evolve");
        while(true) {

            display();
            nextGen();
            Thread.sleep(1000);
        }
    }
}
