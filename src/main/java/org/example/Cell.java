package org.example;

import static org.example.CellStatus.ALIVE;

public class Cell {
    private CellStatus status;

    Cell(CellStatus status) {
        this.status = status;
    }

    public CellStatus status() {
        return status;
    }

    public void flipStatus() {
        this.status = this.status.flip();
    }

    public void statusInNewGeneration(int liveNeighbors) {
        if(this.status == ALIVE) {
            if(liveNeighbors < 2 || liveNeighbors > 3) {
                this.status = this.status.flip();
            }
        }
        else {
            if(liveNeighbors == 3) {
                this.status = this.status.flip();
            }
        }
    }
}
