package com.test.algorithm.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TopNHashtags {

    public static void main(String[] args) {
        int n = 3;
        List<HashTagCount> hashTagList = new ArrayList<>();
        hashTagList.add(new HashTagCount("#sometag", 10));
        hashTagList.add(new HashTagCount("#sometag1", 1000));
        hashTagList.add(new HashTagCount("#sometag2", 900));
        hashTagList.add(new HashTagCount("#sometag3", 100));
        hashTagList.add(new HashTagCount("#sometag4", 50));
        hashTagList.add(new HashTagCount("#sometag", 10));

        printTopNTrendingHashTags(n, hashTagList);
    }

    private static void printTopNTrendingHashTags(int n, List<HashTagCount> hashTagList) {
        PriorityQueue<HashTagCount> topTrendingHashTags =
                new PriorityQueue<>(Comparator.comparing(HashTagCount::getCount).reversed());
        topTrendingHashTags.addAll(hashTagList);
        for (int i = 0; i< n; i++) {
            System.out.println(topTrendingHashTags.poll());
        }
    }
}
