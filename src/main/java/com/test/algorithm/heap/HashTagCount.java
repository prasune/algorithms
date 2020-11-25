package com.test.algorithm.heap;

import java.util.Objects;

public class HashTagCount {

    private String hashTag;

    private long count;

    public HashTagCount(String hashTag, long count) {
        this.hashTag = hashTag;
        this.count = count;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTagCount that = (HashTagCount) o;
        return hashTag.equals(that.hashTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashTag);
    }

    @Override
    public String toString() {
        return "TweetCount{" +
                "hashTag='" + hashTag + '\'' +
                ", count=" + count +
                '}';
    }
}
