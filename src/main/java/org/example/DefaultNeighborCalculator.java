package org.example;

public class DefaultNeighborCalculator implements NeighborCalculator{
    @Override
    public int calculateNeighbors(Board board, int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                Cell neighbor = board.getCell(row + i, col + j);
                if (neighbor instanceof AliveCell) {
                    count++;
                }
            }
        }
        return count;
    }
}
