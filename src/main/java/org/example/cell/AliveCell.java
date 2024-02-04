package org.example.cell;

public class AliveCell implements Cell {
    @Override
    public Cell nextState(int liveNeighbours) {
        if(liveNeighbours < 2 || liveNeighbours > 3) {
            return new DeadCell();
        }

        return new AliveCell();
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String toString() {
        return "X";
    }
}
