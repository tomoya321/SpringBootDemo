package com.tomoya.timer.service;

import com.tomoya.timer.dao.TimerConfigurationDao;
import com.tomoya.timer.domain.TimerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringBootDemo
 * @description: 定时任务配置业务层
 * @author: Tomoya
 * @create: 2019-09-30 00:49
 **/

@Service
public interface TimerConfigurationService {

    List<TimerConfiguration> fingAllTimerConfiguration ();

}
    
