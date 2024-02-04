package org.example.outputservice;

import org.example.Board;

public class OutputService {
    public void print(Board board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board.getCell(i, j).toString() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printGeneration(int tick) {
        System.out.println("Generation " + tick + ":");
    }
}
