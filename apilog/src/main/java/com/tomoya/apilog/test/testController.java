/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: testController
 * Author:   Administrator
 * Date:     2019/8/11 20:50
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.apilog.test;

import com.tomoya.apilog.annoation.ApiLog;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试类〉
 *
 * @author Administrator
 * @create 2019/8/11
 * @since 1.0.0
 */
@RestController
@RequestMapping("/testController")
public class testController {

    @ApiLog(logType = "test")
    @PostMapping("/postRequestParam")
    public String testPostRequestParam(@RequestParam String request){
        System.out.println("fuckyou");
        return "apiLog return" + request;
    }

    @ApiLog(logType = "test")
    @PostMapping("/postRequestBody")
    public String testPostRequestBody(@RequestBody User user) throws Exception {
        System.out.println(user.toString());
        System.out.println("fucking");
        return "apiLog return";
    }

    @PostMapping("/unionParam")
    public String testUnionParam(@RequestParam String str,@RequestBody User user) {
        System.out.println(user.toString());
        System.out.println(str);
        return "union return";
    }
    //todo 热部署开启?

    @Test
    public void test() {
//        Date date = new Date();
//        System.out.println(date);
//        SimpleDateFormat formatter = new java.text.SimpleDateFormat("MM月dd日");
//        String str_date1 = formatter.format(date);
//        System.out.println(str_date1);

//        Date date = new Date();//获取当前时间    
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println(calendar);
//        calendar.add(Calendar.YEAR, -1);//当前时间减去一年，即一年前的时间    
//        System.out.println(calendar);
//        calendar.add(Calendar.MONTH, -1);//当前时间前去一个月，即一个月前的时间    
//        System.out.println(calendar);
//        calendar.getTime();

//        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = new Date();
        System.out.println(df.format(new Date()));
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
        Date datae = date.getTime();
        System.out.println(beginDate);
        System.out.println(datae);
    }

    @Test
    public void testHashMap(){
        Map<String, Long> logisticsInfo = new HashMap<>(32);
        logisticsInfo.put("申通",20L);
        logisticsInfo.put("中通",21L);
        logisticsInfo.put("圆通",22L);
        logisticsInfo.put("EMS",23L);
        String str = "申通";
        String str1 = "为什么这么着急";
        if(Objects.nonNull(logisticsInfo.get(str1))){
            System.out.println("fuckyou");
        } else {
            throw new RuntimeException("没有物流公司错误");
        }
    }

    @Test
    public void testInteger() {
        Date tempDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(tempDate);
        calendar.add(Calendar.DATE,10);
        tempDate = calendar.getTime();
        System.out.println(tempDate);

        Date tempDate2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(tempDate);
        calendar2.add(Calendar.DATE,50);
        tempDate2 = calendar2.getTime();
        System.out.println(tempDate2);

        System.out.println(tempDate2.compareTo(tempDate));


    }

}