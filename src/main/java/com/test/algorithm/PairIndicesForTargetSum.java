package com.test.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairIndicesForTargetSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,9,11,15,7};
        int target = 9;
        System.out.println(Arrays.toString(getIndexPair(nums, target)));
    }

    public static int[] getIndexPair(int[] nums, int target) {
        int[] pairIndices = new int[2];
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (remainderIndexMap.get(nums[i]) == null) {
                int remainder = target-nums[i];
                remainderIndexMap.put(remainder, i);
            } else {
                int remainderIndex = remainderIndexMap.get(nums[i]);
                pairIndices[0] = remainderIndex;
                pairIndices[1] = i;
            }
        }
        return pairIndices;
    }
}
