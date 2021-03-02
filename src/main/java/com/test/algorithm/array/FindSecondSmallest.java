package com.test.algorithm.array;

public class FindSecondSmallest {

    public static void main(String[] args) {
        int input[] = {12, 13, 1, 10, 34, 1};
        printSecondSmallest(input);
    }

    private static void printSecondSmallest(int[] input) {
        if (input.length < 2) {
            System.out.println("Invalid input");
            return;
        }
        int smallest = input[0];
        int secondSmallest = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] < smallest) {
                secondSmallest = smallest;
                smallest = input[i];
            } else if (input[i] == smallest) {
                continue;
            } else if (input[i] < secondSmallest) {
                secondSmallest = input[i];
            }
        }
        System.out.println("Second smallest number " + secondSmallest);
    }
}
