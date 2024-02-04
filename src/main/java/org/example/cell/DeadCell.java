package org.example.cell;

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

    @Override
    public String toString() {
        return "_";
    }
}
