package com.tomoya.timer.service.impl;

import com.tomoya.timer.dao.TimerConfigurationDao;
import com.tomoya.timer.domain.TimerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: 定时任务配置业务实现
 * @author: Tomoya
 * @create: 2019-09-30 00:51
 **/

@Service
public class TimerConfigurationServiceImpl {

    @Autowired
    TimerConfigurationDao timerConfigurationDao;

    public List<TimerConfiguration> fingAllTimerConfiguration () {
        List<TimerConfiguration> timerConfigurationList = timerConfigurationDao.findAll();
        return timerConfigurationList;
    }
}
    
