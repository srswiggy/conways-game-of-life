package org.example;

import org.example.inputservice.InputService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> values = new InputService().initialValues();
        Board board = new Board(values.get(0), values.get(1), values.get(2));
        board.evolve();
    }
}
