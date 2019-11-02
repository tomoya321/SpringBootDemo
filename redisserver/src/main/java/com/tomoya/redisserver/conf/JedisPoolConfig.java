/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JedisPoolConfig
 * Author:   Tomoya
 * Date:     2019/10/31 16:01
 * Description: jedis连接池设置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.redisserver.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈jedis连接池设置〉
 *
 * @author Tomoya
 * @create 2019/10/31
 * @since 1.0.0
 */
public class JedisPoolConfig {
    private static final Logger logger = LoggerFactory.getLogger(JedisPoolConfig.class);

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
    
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = null;
        try {
            jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(redisMaxIdle);
            jedisPoolConfig.setMaxTotal(redisMaxTotal);
            jedisPoolConfig.setMaxWaitMillis(redisMaxWaitMillis);
            jedisPoolConfig.setTestOnBorrow(false);
        } catch (Exception e) {
            log.error("jedisPoolConfig有问题", e);
        }
        return jedisPoolConfig;
    }
}