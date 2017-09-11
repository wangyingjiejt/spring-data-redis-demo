package com.wangyj.redisdemo.repository.impl;

import com.wangyj.redisdemo.repository.ZsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@Service
public class ZsetRepositoryImpl implements ZsetRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void add(String key, String value, double score) {
        System.out.println(redisTemplate.opsForZSet().add(key,value,score));
    }

    @Override
    public void incrementScore(String key, String value, double score) {
        System.out.println(redisTemplate.opsForZSet().incrementScore(key,value,score));
    }

    @Override
    public void reverseRank(String key, String value) {
        System.out.println(redisTemplate.opsForZSet().reverseRank(key,value));
    }

    @Override
    public void rangeWithScores(String key) {
        Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().rangeWithScores(key,0,-1);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = tuples.iterator();
        while (iterator.hasNext())
        {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            System.out.println("value:" + typedTuple.getValue() + "score:" + typedTuple.getScore());
        }

    }

    @Override
    public void getScore(String key, String value) {
        System.out.println(redisTemplate.opsForZSet().score(key,value));
    }
}
