/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisApplication
 * Author:   Tomoya
 * Date:     2019/11/5 23:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Tomoya
 * @create 2019/11/5
 * @since 1.0.0
 */
@EnableRedisRepositories
@SpringBootApplication
public class RedisApplication {
    @PostConstruct
    void started() {
        //时区
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+8"));
    }
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}