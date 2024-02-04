package org.example.inputservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputService {
    private Scanner scanner;

    public InputService() {
        this.scanner = new Scanner(System.in);
    }
     public List<Integer> initialValues() {
        List<Integer> values = new ArrayList<>();
        System.out.print("Enter MxN & Seed Percentage -\n");
         System.out.print("M: ");
         int m = scanner.nextInt();
         System.out.print("N: ");
         int n = scanner.nextInt();
         System.out.print("Seed Percentage: ");
         int seed = scanner.nextInt();
        if(m <= 0 || n <= 0 || seed < 0) throw new IllegalArgumentException("values cannot be less than 0");
        values.add(m);
        values.add(n);
        values.add(seed);

        return values;
    }
}
