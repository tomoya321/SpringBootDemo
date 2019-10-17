/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: test
 * Author:   Administrator
 * Date:     2019/9/2 16:25
 * Description: 测试一次查询和多次查询性能差异
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.test.exportreportperformance.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tomoya.test.exportreportperformance.dao.ExportExcelLogDAO;
import com.tomoya.test.exportreportperformance.domain.ExportExcelLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试一次查询和多次查询性能差异〉
 *
 * @author Administrator
 * @create 2019/9/2
 * @since 1.0.0
 */

/**
 * 分别用1000,5000,10000,20000条数据采取操作计算性能差异
 * 数据量	单个拿出	一起拿出,放入map	时间倍数
 * 								    (不太准,不同时间有差异)
 * 1000 	1201	394				3.048
 * 5000	    4801	567				8.467
 * 10000  	18647 	1087 			17.15
 * 20000	20406	1118			18.253
 */


@RestController("/testcharu")
public class test {

    @Autowired
    ExportExcelLogDAO exportExcelLogDAO;

    @RequestMapping
    public String test() {

        //插入一万条数据
        for(int i = 0; i < 10000; i ++) {

            //这是testhoujiadea
            ExportExcelLog exportExcelLog = new ExportExcelLog();

            exportExcelLog.setCreateTime(new Date());
            exportExcelLog.setCreateUser("zhangbaoyuan"+i+10001);
            exportExcelLog.setCreateUserId(997L);
            exportExcelLog.setFileName("wenjianmingzi");
            exportExcelLog.setFinishTime(new Date());
            exportExcelLog.setParams("shawanyi?");
            exportExcelLog.setParamsHash("zhemeniubi?");
            exportExcelLog.setStatus(1);
            exportExcelLog.setType("5");
            exportExcelLog.setUrl("www.pornhub.com");

            exportExcelLogDAO.save(exportExcelLog);

        }
        return "success";
    }

    //拿出一万条数据,分别拿出
    @GetMapping("/testxingneng")
    public void testxingneng() {

        Long time1 = System.currentTimeMillis();

        List<ExportExcelLog> exportExcelLogs = new ArrayList<>();
        for(Integer i = 15; i < 20015; i++) {
            exportExcelLogs.add(exportExcelLogDAO.getOne(i.longValue()));
        }

        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    //一起拿出一万条数据,放在map,并拿出
    @GetMapping("/testxingneng2")
    public void testxingneng2() {

        Long time1 = System.currentTimeMillis();

        List<Long> longs = new ArrayList<>();
        Map<Long, ExportExcelLog> exportExcelLogMap = new HashMap<>();

        for(Long i = 15L; i < 20015; i++) {
            longs.add(i);
        }

        List<ExportExcelLog> exportExcelLogsList = exportExcelLogDAO.findAllById(longs);
        List<ExportExcelLog> exportExcelLogsList2 = new ArrayList<>();

        for (ExportExcelLog exportExcelLog : exportExcelLogsList) {
            exportExcelLogMap.put(exportExcelLog.getId(), exportExcelLog);
        }

        for (Long i = 15L; i < 20015; i ++) {
            exportExcelLogsList2.add(exportExcelLogMap.get(i));
        }

        Long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    private static Map<String, String> getCurrentMonthFirstAndEndMonth(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date theDate = calendar.getTime();

        //本月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String currentMonthFirstDay = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(currentMonthFirstDay).append(" 00:00:00");
        currentMonthFirstDay = str.toString();

        //本月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        String currentMonthEndDay = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(currentMonthEndDay).append(" 23:59:59");
        currentMonthEndDay = endStr.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("currentMonthFirstDay", currentMonthFirstDay);
        map.put("currentMonthEndDay", currentMonthEndDay);
        return map;
    }
}
