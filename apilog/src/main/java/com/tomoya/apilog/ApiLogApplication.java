/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiLogApplication
 * Author:   Administrator
 * Date:     2019/8/9 12:19
 * Description: ApiLog启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.apilog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * 〈一句话功能简述〉<br> 
 * 〈ApiLog启动类〉
 *
 * @author Administrator
 * @create 2019/8/9
 * @since 1.0.0
 */
@SpringBootApplication
public class ApiLogApplication {

    @PostConstruct
    void started() {
        //时区
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+8"));
    }
    public static void main(String[] args) {
        SpringApplication.run(ApiLogApplication.class, args);
    }

}