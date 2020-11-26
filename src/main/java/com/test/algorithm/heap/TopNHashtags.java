package com.test.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopNHashtags {

    public static void main(String[] args) {
        int n = 3;
        PriorityQueue<HashTagCount> priorityQueue = new PriorityQueue<>(Comparator.comparing(HashTagCount::getCount).reversed());
        priorityQueue.add(new HashTagCount("#sometag", 10));
        priorityQueue.add(new HashTagCount("#sometag1", 1000));
        priorityQueue.add(new HashTagCount("#sometag2", 900));
        priorityQueue.add(new HashTagCount("#sometag3", 100));
        priorityQueue.add(new HashTagCount("#sometag4", 50));
        priorityQueue.add(new HashTagCount("#sometag", 10));

        for (int i=0; i<n; i++) {
            System.out.println(priorityQueue.poll());
        }
    }
}
