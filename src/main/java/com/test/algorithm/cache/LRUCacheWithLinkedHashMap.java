package com.test.algorithm.cache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap<K, V> {

    private final Map<K, V> internalCache;

    public LRUCacheWithLinkedHashMap(int limit){
        internalCache = Collections.synchronizedMap(new LinkedHashMap<K, V>(limit, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > limit;
            }
        });
    }

    public V get(K key) {
        return internalCache.get(key);
    }

    public void put(K key, V value) {
        internalCache.put(key, value);
    }

    public V remove(K key) {
        return internalCache.remove(key);
    }

    public static void main(String arg[]){
        LRUCacheWithLinkedHashMap<Integer, String> lruCache = new LRUCacheWithLinkedHashMap<>(4);

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
        return "LRUCacheWithLinkedHashMap{" +
                "internalCache=" + internalCache +
                '}';
    }
}
