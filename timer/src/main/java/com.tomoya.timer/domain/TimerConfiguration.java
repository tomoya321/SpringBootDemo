package com.tomoya.timer.domain;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: SpringBootDemo
 * @description: 定时任务配置实体类
 * @author: Tomoya
 * @create: 2019-09-30 00:40
 **/

@Entity
@Table(name = "timer_configuration")
public class TimerConfiguration {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cron")
    private String cron;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "last_run_time")
    private Date lastRunTime;
    @Column(name = "run_count")
    private Long runcount;
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastRunTime() {
        return lastRunTime;
    }

    public void setLastRunTime(Date lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public Long getRuncount() {
        return runcount;
    }

    public void setRuncount(Long runcount) {
        this.runcount = runcount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}