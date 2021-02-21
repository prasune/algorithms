package com.test.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        // Generate and print binary numbers till n
        int n = 10;
        generateAndPrintBinaryNumbers(n);
    }

    private static void generateAndPrintBinaryNumbers(int n) {
        Queue<String> queueForBinary = new LinkedList<>();
        queueForBinary.add("1");
        for (int i = 1; i <= n; i++) {
            String lastBinary = queueForBinary.poll();
            System.out.println(lastBinary);

            queueForBinary.add(lastBinary + "0");
            queueForBinary.add(lastBinary + "1");
        }
    }
}
