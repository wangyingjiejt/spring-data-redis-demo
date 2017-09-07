package com.wangyj.redisdemo.repository.impl;

import com.wangyj.redisdemo.Phone;
import com.wangyj.redisdemo.repository.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

@Service
public class SetRepositoryImpl implements SetRepository{

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public void add(String key, Phone phone) {
        SetOperations<String,Phone> operations= redisTemplate.opsForSet();
        System.err.println(operations.add(key,phone));;
    }

    @Override
    public boolean isMembers(String key, Phone phone) {
        SetOperations<String,Phone> operations= redisTemplate.opsForSet();
        return operations.isMember(key,phone);
    }


    @Override
    public void remove(String key, Phone phone) {
        SetOperations<String,Phone> operations= redisTemplate.opsForSet();
        operations.remove(key,phone);
    }
}
