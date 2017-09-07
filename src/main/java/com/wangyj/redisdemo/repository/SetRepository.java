package com.wangyj.redisdemo.repository;

import com.wangyj.redisdemo.Phone;

public interface SetRepository {
    void add(String key, Phone phone);

    boolean isMembers(String key, Phone phone);

    void remove(String key, Phone phone);
}
