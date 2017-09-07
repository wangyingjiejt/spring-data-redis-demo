package com.wangyj.redisdemo.repository.impl;

import com.wangyj.redisdemo.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ListRepositoryImpl implements ListRepository{

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void leftPush(String programs, String s) {
        ListOperations<String,String> operations= redisTemplate.opsForList();
        operations.leftPush(programs,s);
    }

    /**
     * 将数组插入list
     * @user wangyj
     * @date 2017/9/7 10:21
     */
    @Override
    public void leftPushAll(String key, String[] array) {
        ListOperations<String,String> operations= redisTemplate.opsForList();
        operations.leftPushAll(key,array);
        System.err.println(operations.size(key));
        System.err.println(operations.range(key,0 ,-1));
    }


    @Override
    public void remove(String key, long i, String value) {
        ListOperations<String,String> operations= redisTemplate.opsForList();
        operations.remove(key,i,value);
        System.err.println(operations.range(key,0,-1));
    }

    @Override
    public void leftPop(String key) {
        ListOperations<String,String> operations= redisTemplate.opsForList();
        operations.leftPop(key);
        System.err.println(operations.range(key,0,-1));
    }
}
