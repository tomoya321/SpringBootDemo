package com.tomoya.timer.dao;

import com.tomoya.timer.domain.TimerConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: SpringBootDemo
 * @description: 定时任务配置dao层
 * @author: Tomoya
 * @create: 2019-09-30 00:47
 **/

public interface TimerConfigurationDao extends JpaRepository<TimerConfiguration, Long> {

}
    
