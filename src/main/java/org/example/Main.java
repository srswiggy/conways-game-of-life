package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(10, 10, 50);
                board.evolve();
    }
}
