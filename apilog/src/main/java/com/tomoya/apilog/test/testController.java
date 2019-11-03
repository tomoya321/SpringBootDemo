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
import com.tomoya.apilog.service.ApiLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 10*60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    @Autowired
    private ApiLogService apiLogService;

//    @ApiLog(logType = "test")
    @PostMapping("/postRequestParam")
    public String testPostRequestParam(@RequestParam String request){
        System.out.println("fuckyou");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(123);
                apiLogService.saveLog("1","1","1","1");
            }
        });

        return "1";
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

    /**
     * 筛选支付失败订单
     */
    @Test
    public void testData() {

        String fileName ="F:\\1030wx.txt";
        String wx = null;
        try {
            wx = readFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(wx);
        String[] strwx = wx.split("`");

        String fileNameZT ="F:\\1030sc.txt";
        String zt = null;
        try {
            zt = readFile(fileNameZT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(zt);
        String[] strzt = zt.split(",");

        Set<String> setStr = new HashSet<>();
        for (int i = 0; i < strzt.length; i ++) {
            setStr.add(strzt[i]);
        }
        for (int i = 0; i < strwx.length; i ++) {
            if (setStr.contains(strwx[i])) {
//                System.out.println("正常" + strwx[i]);
            } else {
                System.out.println(strwx[i]);
            }
        }

    }

    public static String readFile(String fileName) throws Exception{
        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line =bufferedReader.readLine();

        String returnstr = null;
        while (line!=null){
            returnstr += line;
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        fileReader.close();
        return returnstr;
    }

    @Test
    public void testdate() {
        String StrD ="2019-10-21 00:00:00";
        SimpleDateFormat sf =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date dat = null;
        try {
            dat = sf.parse(StrD);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dat.getTime());

    }


    @RequestMapping("/testTong")
    @ResponseBody
    public String testTong(String oldPhone, String newPhone, String code, String bizUserId) {
        String response = apiLogService.changBindPhone(oldPhone, newPhone, code, bizUserId);
        return response;
    }


}