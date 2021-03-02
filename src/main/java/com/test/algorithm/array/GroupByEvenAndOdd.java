package com.test.algorithm.array;

public class GroupByEvenAndOdd {
    public static void main(String[] args) {
        int[] numArray = new int[]{4,2,5,8,12,11,10};
        groupNumsByEvenAndOdd(numArray);
        for (int i=0; i< numArray.length; i++) {
            System.out.println(numArray[i]);
        }
    }

    private static void groupNumsByEvenAndOdd(int[] numArray) {
        int newEvenIndex = 0;
        for (int i=0; i< numArray.length; i++) {
            if(numArray[i]%2 == 0) {
                if (i != newEvenIndex) {
                    // swap
                    int temp = numArray[newEvenIndex];
                    numArray[newEvenIndex] = numArray[i];
                    numArray[i] = temp;
                }
                newEvenIndex++;
            }
        }
    }
}
