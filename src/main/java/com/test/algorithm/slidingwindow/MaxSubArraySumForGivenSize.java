package com.test.algorithm.slidingwindow;

public class MaxSubArraySumForGivenSize {

    public static void main(String[] args) {
        int[] input = new int[] {2, 3, 4, 1, 5};
        int subArraySize = 2;
        System.out.println(getMaxSubArraySum(input, subArraySize));
    }

    private static int getMaxSubArraySum(int[] input, int subArraySize) {
        int subArraySum = 0;
        int maxSubArraySum = 0;
        int startIndex = 0;
        for (int i = 0; i < input.length; i++) {
            subArraySum = subArraySum + input[i];
            if (i >= subArraySize-1) {
                maxSubArraySum = Math.max(subArraySum, maxSubArraySum);
                subArraySum = subArraySum - input[startIndex];
                startIndex ++;
            }
        }
        return maxSubArraySum;
    }
}
