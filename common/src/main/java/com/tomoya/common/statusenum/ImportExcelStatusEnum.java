/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImportExcelStatusEnum
 * Author:   Administrator
 * Date:     2019/8/21 19:30
 * Description: 导入报表状态枚举类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.common.statusenum;

/**
 * 〈一句话功能简述〉<br> 
 * 〈导入报表状态枚举类〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public enum ImportExcelStatusEnum {
    RUNNING(0,"导入进行中"),
    FINISH(1,"导入完成"),

    ;

    private Integer status;
    private String name;



    public static String getStatusName(Integer status){
        for (ImportExcelStatusEnum value : ImportExcelStatusEnum.values()) {
            if(status.equals(value.getStatus())){
                return value.getName();
            }
        }
        return "";
    }

    ImportExcelStatusEnum(Integer status, String name) {
        this.status = status;
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}