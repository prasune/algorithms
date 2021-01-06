package com.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatingOccurrence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,3,3,2,2,2,2,3,3,3,4,1,1,1};

        printMaxRepeatingOccurences(nums);
    }

    private static void printMaxRepeatingOccurences(int[] nums) {
        Map<Integer, Integer> numOccurrenceMap = new HashMap<>();
        int currentNumCount = 0;
        boolean isNumSeqChanged = false;
        for (int i = 0; i<nums.length; i++) {
            if (i > 0 && nums[i] != nums[i-1]) {
                isNumSeqChanged = true;
            } else {
                currentNumCount = currentNumCount + 1;
            }
            if (isNumSeqChanged) {
                if (numOccurrenceMap.get(nums[i-1]) == null) {
                    numOccurrenceMap.put(nums[i-1], currentNumCount);
                } else {
                    if (currentNumCount > numOccurrenceMap.get(nums[i-1])) {
                        numOccurrenceMap.put(nums[i-1], currentNumCount);
                    }
                }
                currentNumCount = 1;
                isNumSeqChanged = false;
            }
        }
        if (currentNumCount > numOccurrenceMap.get(nums[nums.length - 1])) {
            numOccurrenceMap.put(nums[nums.length - 1], currentNumCount);
        }
        for (Map.Entry numOccurrenceEntry : numOccurrenceMap.entrySet()) {
            System.out.println( numOccurrenceEntry.getKey() + " occurred " + numOccurrenceEntry.getValue() + " times max in sequence");
        }
    }
}
