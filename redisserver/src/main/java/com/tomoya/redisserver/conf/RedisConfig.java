/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisConfig
 * Author:   Tomoya
 * Date:     2019/10/30 15:06
 * Description: Redis配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.redisserver.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Redis配置类〉
 *
 * @author Tomoya
 * @create 2019/10/30
 * @since 1.0.0
 */
@Configuration
public class RedisConfig {

    @Value(value = "${redis.maxIdle}")
    private int redisMaxIdle;

    @Value(value = "${redis.maxTotal}")
    private int redisMaxTotal;

    @Value(value = "${redis.maxWaitMillis}")
    private int redisMaxWaitMillis;

    @Value(value = "${redis.ip}")
    private String redisIp;

    @Value(value = "${redis.master}")
    private String redisMaster;

    @Value(value = "${redis.timeOut}")
    private int redisTimeOut;

    public int getRedisMaxIdle() {
        return redisMaxIdle;
    }

    public void setRedisMaxIdle(int redisMaxIdle) {
        this.redisMaxIdle = redisMaxIdle;
    }

    public int getRedisMaxTotal() {
        return redisMaxTotal;
    }

    public void setRedisMaxTotal(int redisMaxTotal) {
        this.redisMaxTotal = redisMaxTotal;
    }

    public int getRedisMaxWaitMillis() {
        return redisMaxWaitMillis;
    }

    public void setRedisMaxWaitMillis(int redisMaxWaitMillis) {
        this.redisMaxWaitMillis = redisMaxWaitMillis;
    }

    public String getRedisIp() {
        return redisIp;
    }

    public void setRedisIp(String redisIp) {
        this.redisIp = redisIp;
    }

    public String getRedisMaster() {
        return redisMaster;
    }

    public void setRedisMaster(String redisMaster) {
        this.redisMaster = redisMaster;
    }

    public int getRedisTimeOut() {
        return redisTimeOut;
    }

    public void setRedisTimeOut(int redisTimeOut) {
        this.redisTimeOut = redisTimeOut;
    }



//    @Configuration
//    public class RedisConfig {
//
//        @Value("${redis.uri}")
//        private String url;
//        @Value("${redis.maxTotal}")
//        private int maxTotal;
//        @Value("${redis.maxIdle}")
//        private int maxIdle;
//        @Value("${redis.maxWaitMillis}")
//        private long maxWaitMillis;
//        @Value("${redis.testOnBorrow}")
//        private boolean testOnBorrow;
//        @Value("${redis.testOnReturn}")
//        private boolean testOnReturn;
//
//
//        @Bean
//        public ShardedJedisPool shardedJedisPool() {
//            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//            jedisPoolConfig.setMaxTotal(maxTotal);
//            jedisPoolConfig.setMaxIdle(maxIdle);
//            jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//            jedisPoolConfig.setTestOnBorrow(testOnBorrow);
//            jedisPoolConfig.setTestOnReturn(testOnReturn);
//            List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
//            jedisShardInfos.add(new JedisShardInfo(url));
//
//            return new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
//        }
//
//        @Bean
//        public RedisService redisService(){
//            RedisService redisService = new RedisService();
//            redisService.setShardedJedisPool(shardedJedisPool());
//            return redisService;
//        }
}