package com.tomoya.timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @program: SpringBootDemo
 * @description: 定时器启动类
 * @author: Tomoya
 * @create: 2019-09-30 01:04
 **/
@EnableScheduling
@SpringBootApplication
public class TimerApplication {
    @PostConstruct
    void started() {
        //时区
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+8"));
    }
    public static void main(String[] args) {
        SpringApplication.run(TimerApplication.class, args);
    }
}
    
