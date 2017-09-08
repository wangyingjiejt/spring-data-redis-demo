package com.wangyj.redisdemo.repository.impl;

import com.wangyj.redisdemo.repository.HashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HashRepositoryImpl implements HashRepository{

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void add(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key,field,value);
        System.err.println(redisTemplate.opsForHash().entries(key));
    }

    @Override
    public boolean hasKey(String key, String field) {
        return redisTemplate.opsForHash().hasKey(key,field);
    }

    @Override
    public Object getByKey(String key, String field) {
        return redisTemplate.opsForHash().get(key,field);
    }


    @Override
    public void increment(String key, String filed, double v) {
        System.out.println(redisTemplate.opsForHash().increment(key,filed,v));
    }
}
