package org.example;

public enum CellStatus {
    ALIVE,
    DEAD;

    public CellStatus flip() {
        return this == ALIVE ? DEAD : ALIVE;
    }
}
