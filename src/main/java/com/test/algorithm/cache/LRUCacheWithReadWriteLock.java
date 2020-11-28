package com.test.algorithm.cache;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCacheWithReadWriteLock<K, V> {

    private final int limit;
    private final Map<K, V> internalCache;
    private final Queue<K> trackingQueue;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public LRUCacheWithReadWriteLock(int limit){
        internalCache = new ConcurrentHashMap<>();
        trackingQueue = new ConcurrentLinkedQueue<>();
        this.limit = limit;
    }

    public V get(K key) {
        this.readWriteLock.readLock().lock();
        try {
            V value = internalCache.get(key);
            if (value != null) {
                if (trackingQueue.remove(key)) {
                    trackingQueue.add(key);
                }
            }
            return value;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void put(K key, V value) {
        this.readWriteLock.writeLock();
        try {
            if (internalCache.containsKey(key)) {
                trackingQueue.remove(key);
            }
            if (trackingQueue.size() == limit) {
                K expiredKey = trackingQueue.poll();
                internalCache.remove(expiredKey);
            }
            internalCache.put(key, value);
            trackingQueue.add(key);
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String arg[]){
        LRUCacheWithReadWriteLock<Integer, String> lruCache = new LRUCacheWithReadWriteLock<>(4);

        lruCache.put(1, "Object1");
        lruCache.put(2, "Object2");
        lruCache.put(3, "Object3");
        lruCache.get(1);
        lruCache.put(4, "Object4");
        System.out.println(lruCache);
        lruCache.put(5, "Object5");
        lruCache.get(3);
        lruCache.put(6, "Object6");
        System.out.println(lruCache);
        lruCache.get(4);
        lruCache.put(7, "Object7");
        lruCache.put(8, "Object8");
        System.out.println(lruCache);
    }

    @Override
    public String toString() {
        return "LRUCacheWithReadWriteLock{" +
                "internalCache=" + internalCache +
                '}';
    }
}
