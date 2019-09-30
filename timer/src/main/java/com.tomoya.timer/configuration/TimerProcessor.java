package com.tomoya.timer.configuration;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: SpringBootDemo
 * @description: 定时任务处理器
 * @author: Tomoya
 * @create: 2019-09-30 14:02
 **/

@Component
public class TimerProcessor {
    static Integer i = 0;
    //测试定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    public void testTimer() {
        System.out.println("fuckyou" + i++);
    }
}
    
