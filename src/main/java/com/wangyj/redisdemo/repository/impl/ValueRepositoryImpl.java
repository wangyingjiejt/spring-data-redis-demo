package com.wangyj.redisdemo.repository.impl;


import com.wangyj.redisdemo.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ValueRepositoryImpl implements ValueRepository {


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save(String id, String name) {
        ValueOperations<String  ,String> operations = redisTemplate.opsForValue();
        operations.set(id,name);
    }

    @Override
    public String getUser(String id) {
        ValueOperations<String ,String> operations = redisTemplate.opsForValue();
        return operations.get(id);
    }

    @Override
    public void saveMulti(Map<String, String> map) {
        ValueOperations<String ,String> operations = redisTemplate.opsForValue();
        operations.multiSet(map);
    }
}
