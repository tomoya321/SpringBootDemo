package com.tomoya.timer.controller;

import com.tomoya.common.response.SingleResponse;
import com.tomoya.timer.domain.TimerConfiguration;
import com.tomoya.timer.service.TimerConfigurationService;
import com.tomoya.timer.service.impl.TimerConfigurationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.certpath.OCSPResponse;

import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: 定时任务配置控制层
 * @author: Tomoya
 * @create: 2019-09-30 00:49
 **/

@RestController
@RequestMapping(value = "/timerConfigutation")
public class TimerConfigurationController {

    @Autowired
    TimerConfigurationServiceImpl timerConfigurationService;

    @GetMapping(value = "/findAll")
    public SingleResponse findAll() {
        List<TimerConfiguration> timerConfigurationList = timerConfigurationService.fingAllTimerConfiguration();
        SingleResponse<List<TimerConfiguration>> singleResponse = new SingleResponse<>(200, "成功查询", timerConfigurationList);
        return singleResponse;
    }
}
    
