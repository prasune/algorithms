package com.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatingOccurrence {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3, 3, 2, 2, 2, 2, 3, 3, 3, 4, 1, 1, 1};

        printMaxRepeatingOccurrences(nums);
    }

    private static void printMaxRepeatingOccurrences(int[] nums) {
        Map<Integer, Integer> numOccurrenceMap = new HashMap<>();
        int currentSequenceCount = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSequenceCount = currentSequenceCount + 1;
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                if (numOccurrenceMap.get(nums[i]) == null || currentSequenceCount > numOccurrenceMap.get(nums[i])) {
                    numOccurrenceMap.put(nums[i], currentSequenceCount);
                }
                currentSequenceCount = 0;
            }
        }
        for (Map.Entry<Integer, Integer> numOccurrenceEntry : numOccurrenceMap.entrySet()) {
            System.out.println(numOccurrenceEntry.getKey() + " occurred " + numOccurrenceEntry.getValue() + " times max in sequence");
        }
    }
}
