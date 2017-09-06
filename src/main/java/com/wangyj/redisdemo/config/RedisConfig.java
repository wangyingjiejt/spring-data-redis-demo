package com.wangyj.redisdemo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {


    @Value("${redis.host_name}")
    private String REDIS_HOST;

    @Value("${redis.port}")
    private int REDIS_PORT;

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        jcf.setHostName(REDIS_HOST);
        jcf.setPort(REDIS_PORT);
        jcf.setUsePool(true);
        return jcf;
    }


    @Bean
    RedisTemplate<Object,Object> redisTemplate(){
        RedisTemplate template = new RedisTemplate();
        StringRedisSerializer srs= new StringRedisSerializer();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(srs);
        template.setValueSerializer(srs);
        return template;
    }


    @Bean
    CacheManager cacheManager(){
        return new RedisCacheManager(redisTemplate());
    }
}
