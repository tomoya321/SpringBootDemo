/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImportExcelLogDTO
 * Author:   Administrator
 * Date:     2019/8/21 16:12
 * Description: 订单导入记录转换类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.excelmodule.dto;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈订单导入记录转换类〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class ImportExcelLogDTO {

    private long id;

    //@ApiModelProperty("创建时间")
    private Date createTime;

    //@ApiModelProperty("创建人")
    private String createUser;

    //@ApiModelProperty("创建人id")
    private Long createUserId;

    //@ApiModelProperty("文件名")
    private String fileName;

    //@ApiModelProperty("结束时间")
    private Date finishTime;

    //@ApiModelProperty("结果")
    private String resultJson;

    //@ApiModelProperty("结果")
    private JSONObject result;

    //@ApiModelProperty("状态")
    private Integer status;

    //@ApiModelProperty("类型")
    private String type;

    //@ApiModelProperty("原始文件地址")
    private String url;

    //@ApiModelProperty("导入总数")
    private Integer totalCount;

    //@ApiModelProperty("成功总数")
    private Integer successCount;

    //@ApiModelProperty("失败总数")
    private Integer failedCount;

    //@ApiModelProperty("失败文件")
    private String resultFile;

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

    public String getResultJson() {
        return resultJson;
    }

    public void setResultJson(String resultJson) {
        this.resultJson = resultJson;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public String getResultFile() {
        return resultFile;
    }

    public void setResultFile(String resultFile) {
        this.resultFile = resultFile;
    }
}