package com.wangyj.redisdemo.repository;

import com.wangyj.redisdemo.Phone;

public interface ZsetRepository {

    void add(String key, String value, double score);

    void incrementScore(String key, String value, double score);

    void reverseRank(String key, String value);

    void rangeWithScores(String key);

    void getScore(String phone, String iphone7);
}
