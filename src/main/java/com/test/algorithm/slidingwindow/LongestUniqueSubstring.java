package com.test.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("abcba"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int startIndex = 0;
        int currentSequenceLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if(charIndexMap.containsKey(s.charAt(i))) {
                currentSequenceLength = i - startIndex;
                if (currentSequenceLength > lengthOfLongestSubstring) {
                    lengthOfLongestSubstring = currentSequenceLength;
                }
                startIndex = Math.max(startIndex, charIndexMap.get(s.charAt(i)) + 1);
            }
            charIndexMap.put(s.charAt(i), i);
        }
        currentSequenceLength = s.length() - startIndex;
        if (currentSequenceLength > lengthOfLongestSubstring) {
            lengthOfLongestSubstring = currentSequenceLength;
        }
        return lengthOfLongestSubstring;
    }
}
