package org.example.neighborcalculationservice;

import org.example.Board;

public interface NeighborCalculationService {
    int calculateNeighbors(Board board, int row, int col);
}
