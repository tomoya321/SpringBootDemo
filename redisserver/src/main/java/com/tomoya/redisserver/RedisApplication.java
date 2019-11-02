/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RedisApplication
 * Author:   Tomoya
 * Date:     2019/10/30 14:31
 * Description: redis缓存测试服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.redisserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * 〈一句话功能简述〉<br> 
 * 〈redis缓存测试服务〉
 *
 * @author Tomoya
 * @create 2019/10/30
 * @since 1.0.0
 */
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