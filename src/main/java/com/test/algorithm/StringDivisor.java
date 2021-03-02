package com.test.algorithm;

import java.util.*;

public class StringDivisor {

    public static void main(String[] args) {
        String s = "abab";
        // abab
        // aba
        // bab
        // ba
        // ab
        // a
        // b

        System.out.println(substringCalculator(s));
    }

    public static int findSmallestDivisor(String s, String t) {
        if (isDivisible(s, t)) {
            char firstChar = t.charAt(0);
            StringBuilder repeatingSubstringBuilder = new StringBuilder();
            repeatingSubstringBuilder.append(firstChar);
            for (int i = 1; i < t.length(); i++) {
                if (t.charAt(i) == firstChar) {
                    if (isDivisible(repeatingSubstringBuilder.toString(), t)) {
                        return repeatingSubstringBuilder.toString().length();
                    }
                }
                repeatingSubstringBuilder.append(t.charAt(i));
            }
            return t.length();
        }
        return -1;
    }

    public static boolean isDivisible(String s, String t) {
        if (s.length() % t.length() != 0) {
            return false;
        } else {
            int numOfConcatsNeeded = s.length() / t.length();
            StringBuilder concatedStringBuilder = new StringBuilder();
            for (int i = 0; i < numOfConcatsNeeded; i++) {
                concatedStringBuilder.append(t);
            }
            if (concatedStringBuilder.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static long substringCalculator(String s) {
        // if the length of the string is n,
        // then the number of substrings possible is n + (n-1)+ (n-2) + .... + 1
        // this is n*(n+1)/2
        // so for length 5, it is 5 + 4 + 3 + 2 + 1 = 5*6/2 = 15
        // and for length 10 it is 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 55 (10*11/2) but i and n occurs twice eliminating 2 possibilities and reducing overall count to 53
        long numOfMaxPossibleSubstrings = (s.length() * (s.length()+1))/2;
        long numOfDuplicateSubstrings = 0L;
        Map<Character, List<Integer>> charIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charIndexMap.get(s.charAt(i)) == null) {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                charIndexMap.put(s.charAt(i), indices);
            } else {
                // need to check for duplicates with multiple chars as well
                for (int previousIndex : charIndexMap.get(s.charAt(i))) {
                    StringBuilder str = new StringBuilder();
                    str.append(s.charAt(i));
                    int counter = 1;
                    while (i + counter <= s.length() && str.toString().equals(s.substring(i, i + counter))) {
                        str.append(s.charAt(previousIndex + counter));
                        numOfDuplicateSubstrings++;
                        counter++;
                    }
                }
                charIndexMap.get(s.charAt(i)).add(i);
            }
        }
        return (numOfMaxPossibleSubstrings - numOfDuplicateSubstrings);
    }
}
