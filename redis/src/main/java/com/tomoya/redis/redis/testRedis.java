/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: testRedis
 * Author:   Tomoya
 * Date:     2019/11/5 23:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.redis.redis;

import com.tomoya.redis.util.MD5Utils;
import com.tomoya.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Tomoya
 * @create 2019/11/5
 * @since 1.0.0
 */
@RestController
@RequestMapping("/redis")
public class testRedis {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping
    public void test() {
        redisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);
    }

    @GetMapping("/query")
    public String query() {
        if (redisTemplate.hasKey("test")) {
            System.out.println("2");
//            modelMap.put("message","true");
            return "true";
        }
        System.out.println("1");
//        modelMap.put("message","false");
        return "false";
    }

    @GetMapping("/testIdempotent")
        public String testIdempotent(Integer milkStation, Integer milkMan, String originalOrderId) {
        String md5String = originalOrderId + milkMan + milkStation;
        if (redisUtil.hasKey(md5String)) {
            return "已经操作过了";
        }
        redisUtil.setEx(md5String,"",15,TimeUnit.SECONDS);
        return "操作成功";
    }

}