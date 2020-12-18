package com.test.algorithm.stack;

import java.util.Stack;

public class NearestGreaterNumber {

    public static void main(String[] args) {
        int[] numArray = new int[]{4,2,5,8,12,11,10};
        printNumWithNearestGreaterNumber(numArray);
    }

    private static void printNumWithNearestGreaterNumber(int[] numArray) {
        Stack<Integer> numStack = new Stack<>();
        for (int i=0; i< numArray.length; i++) {
            while (!numStack.isEmpty() && numStack.peek() < numArray[i]) {
                System.out.println(numStack.pop() + " -> " + numArray[i]);
            }
            numStack.push(numArray[i]);
        }
        while (!numStack.isEmpty()) {
            System.out.println(numStack.pop() + " -> -1");
        }
    }
}
