package com.wangyj.redisdemo.repository;

public interface HashRepository {
    void add(String key, String field, Object value);

    boolean hasKey(String key, String field);

    Object getByKey(String phone, String brand);

    void increment(String key, String filed, double v);
}
