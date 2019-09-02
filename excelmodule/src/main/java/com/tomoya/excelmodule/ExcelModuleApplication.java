/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExcelModuleApplication
 * Author:   Administrator
 * Date:     2019/8/21 15:35
 * Description: excel导入导出数据启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.excelmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * 〈一句话功能简述〉<br> 
 * 〈excel导入导出数据启动类〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
@SpringBootApplication
public class ExcelModuleApplication {
    @PostConstruct
    void started() {
        //时区
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+8"));
    }
    public static void main(String[] args) {
        SpringApplication.run(ExcelModuleApplication.class, args);
    }
}