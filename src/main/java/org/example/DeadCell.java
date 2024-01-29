package org.example;

public class DeadCell implements Cell {
    @Override
    public Cell nextState(int liveNeighbours) {
        if(liveNeighbours == 3) return new AliveCell();
        return new DeadCell();
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
