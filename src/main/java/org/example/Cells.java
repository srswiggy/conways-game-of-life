package org.example;

import org.example.cell.AliveCell;
import org.example.cell.Cell;
import org.example.cell.DeadCell;

import java.util.Random;

public class Cells {
    protected Cell[][] grid;

    public Cells(int m, int n, int seedPercentage) {
        this.grid = new Cell[m][n];
        initializeBoardCellsDead();
        seed(m, n, seedPercentage);
    }

    private void initializeBoardCellsDead() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                this.grid[i][j] = new DeadCell();
            }
        }
    }

    private void seed(int m, int n, int seedPercentage) {
        Random random = new Random();
        int totalCells = m*n;
        double seedPerc = seedPercentage * 0.01;
        int cellsToSeed = (int)(totalCells * seedPerc);

        while(cellsToSeed > 0) {
            int randomRow = random.nextInt(m);
            int randomCol = random.nextInt(n);
            if(this.grid[randomRow][randomCol].getClass() == AliveCell.class) continue;
            this.grid[randomRow][randomCol] = new AliveCell();
            cellsToSeed--;
        }
    }

    public void updateCells(Cell[][] newGrid) {
        this.grid = newGrid;
    }

}
