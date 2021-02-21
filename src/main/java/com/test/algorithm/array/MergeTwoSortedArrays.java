package com.test.algorithm.array;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] inputArray1 = new int[]{1, 3, 5, 7, 9};
        int[] inputArray2 = new int[]{2, 4, 6, 8};
        int[] mergedArray = mergeArrays(inputArray1, inputArray2);
        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }
    }

    private static int[] mergeArrays(int[] inputArray1, int[] inputArray2) {
        int[] mergedArray = new int[inputArray1.length + inputArray2.length];
        int array1Pointer = 0;
        int array2Pointer = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (inputArray2.length == array2Pointer || inputArray1[array1Pointer] < inputArray2[array2Pointer]) {
                mergedArray[i] = inputArray1[array1Pointer];
                array1Pointer++;
            } else {
                mergedArray[i] = inputArray2[array2Pointer];
                array2Pointer++;
            }
        }
        return mergedArray;
    }
}
