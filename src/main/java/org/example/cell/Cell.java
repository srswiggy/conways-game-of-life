package org.example.cell;

public interface Cell {
    Cell nextState(int liveNeighbours);

    boolean isAlive();
}