package com.wangyj.redisdemo.repository;
/**
 * List操作
 * @user wangyj
 * @date 2017/9/7 9:56
 */
public interface ListRepository {
    void leftPush(String programs, String s);

    void leftPushAll(String key,String[] array);

    void remove(String key, long i, String value);

    void leftPop(String key);
}
