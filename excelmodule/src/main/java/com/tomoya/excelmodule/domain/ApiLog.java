/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiLog
 * Author:   Administrator
 * Date:     2019/8/9 11:29
 * Description: 日志实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.excelmodule.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈日志实体类〉
 *
 * @author Administrator
 * @create 2019/8/9
 * @since 1.0.0
 */
@Entity
@Table(name = "api_log")
public class ApiLog {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type")
    private String type;
    @Column(name = "post_time")
    private Date postTime;
    @Column(name = "request")
    private String request;
    @Column(name = "response")
    private String response;
    @Column(name = "error")
    private String error;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ApiLog{" +
                "type='" + type + '\'' +
                ", postTime=" + postTime +
                ", request='" + request + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}