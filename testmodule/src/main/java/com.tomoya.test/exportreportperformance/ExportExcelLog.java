/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExportExcelLog
 * Author:   Administrator
 * Date:     2019/8/21 16:35
 * Description: 导出记录实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.test.exportreportperformance;
import javax.persistence.*;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈导出记录实体类〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */

@Entity
@Table(name = "t_export_excel_log")
public class ExportExcelLog {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user", length = 30)
    private String createUser;

    @Column(name = "create_user_id")
    private Long createUserId;

    @Column(name = "file_name", length = 255)
    private String fileName;

    @Column(name = "finish_time")
    private Date finishTime;

    @Column(name = "params", length = 255)
    private String params;

    @Column(name = "params_hash", length = 64)
    private String paramsHash;

    @Column(name = "status")
    private Integer status;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "url", length = 255)
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParamsHash() {
        return paramsHash;
    }

    public void setParamsHash(String paramsHash) {
        this.paramsHash = paramsHash;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
