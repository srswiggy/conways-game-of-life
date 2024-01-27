package org.example;

import static org.example.CellStatus.*;

public class Cell {
    private CellStatus status;

    Cell(CellStatus status) {
        this.status = status;
    }

    public CellStatus status() {
        return status;
    }

    public void flip() {
        if(this.status == ALIVE) {
            this.status = DEAD;
        } else {
            this.status = ALIVE;
        }
    }

}
