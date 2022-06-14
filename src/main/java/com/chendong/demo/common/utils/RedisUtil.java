package com.chendong.demo.common.utils;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author dong.chen
 */
public class RedisUtil {

    private static final Logger log = LoggerFactory.getLogger(RedisUtil.class);

    private static JedisPool jedisPool;

    public synchronized void initPool(String host, int port, String password, int database) {
        if (Objects.isNull(jedisPool)) {
            try {
                JedisPoolConfig poolConfig = new JedisPoolConfig();
                poolConfig.setMaxTotal(200);
                poolConfig.setMaxIdle(30);
                poolConfig.setBlockWhenExhausted(true);
                poolConfig.setMaxWaitMillis(10 * 1000);
                poolConfig.setTestOnBorrow(true);
                jedisPool = new JedisPool(poolConfig, host, port, 20 * 1000, password, database);
            } catch (Exception e) {
                log.error("jedisPool get errors " + e.toString());
            }
        }
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

}
