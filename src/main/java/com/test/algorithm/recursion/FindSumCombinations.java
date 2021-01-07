package com.test.algorithm.recursion;


public class FindSumCombinations {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6,9,10};
        int target = 15;

        printCombinations(nums, target);
    }

    private static void printCombinations(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target && printCombinations(nums, target - nums[i], i+1)) {
                System.out.print(nums[i]);
                System.out.println();
            }
        }
    }

    private static boolean printCombinations(int[] nums, int target, int startIndex) {
        for (int i = startIndex; i < nums.length; i++) {
            int newTarget = target - nums[i];
            if (newTarget > 0) {
                if (printCombinations(nums, newTarget, i+1)) {
                    System.out.print(nums[i] + " ");
                    return true;
                }
            } else if (newTarget == 0) {
                System.out.print(nums[i] + " ");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
