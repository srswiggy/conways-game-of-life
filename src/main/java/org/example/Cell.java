package org.example;

public interface Cell {
    Cell nextState(int liveNeighbours);

    boolean isAlive();
}