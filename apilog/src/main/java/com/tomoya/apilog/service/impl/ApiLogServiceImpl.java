/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiLogServiceImpl
 * Author:   Administrator
 * Date:     2019/8/9 11:22
 * Description: 保存日志实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.apilog.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.tomoya.apilog.dao.ApiLogDao;
import com.tomoya.apilog.domain.ApiLog;
import com.tomoya.apilog.domain.YunClient;
import com.tomoya.apilog.domain.YunRequest;
import com.tomoya.apilog.service.ApiLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈保存日志实现类〉
 *
 * @author Administrator
 * @create 2019/8/9
 * @since 1.0.0
 */
@Service
public class ApiLogServiceImpl implements ApiLogService {

    @Autowired
    private ApiLogDao apiLogDao;


    @Override
    @Transactional
    public void saveLog(String type, String request, String response, String error) {
        new Thread(() -> {
            try {
                ApiLog apiLog = new ApiLog();
                apiLog.setType(type);

//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai")); // 设置北京时区
//                Date now = sdf.parse(new Date().toString());
                // TODO 时间延迟了四个小时
                apiLog.setPostTime(new Date());

                apiLog.setRequest(request);
                apiLog.setResponse(response);
                apiLog.setError(error);
                apiLogDao.save(apiLog);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        ApiLog apiLog = new ApiLog();
        apiLog.setType(type);
        apiLog.setPostTime(new Date());
        apiLog.setRequest(request);
        apiLog.setResponse(response);
        apiLog.setError(error);
        apiLogDao.save(apiLog);
//        throw new RuntimeException("测试");
    }

    @Override
    @Transactional
    public void testEx() {
        ApiLog apiLog = new ApiLog();
        apiLog.setType("1");
        apiLog.setPostTime(new Date());
        apiLog.setRequest("1");
        apiLog.setResponse("1");
        apiLog.setError("1");
        apiLogDao.save(apiLog);

//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(123);
//                throw new RuntimeException("测试");
//            }
//        });
    }

    @Override
    public String changBindPhone(String oldPhone, String newPhone, String code, String bizUserId) {
        YunRequest yunRequest = new YunRequest("MemberService", "changeBindPhone");
        yunRequest.put("bizUserId", bizUserId);
        yunRequest.put("oldPhone", oldPhone);
        yunRequest.put("newPhone", newPhone);
        yunRequest.put("newVerificationCode", code);
        String result = "";
        try {
            result = YunClient.request(yunRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("变更手机号返回结果" + result);
        JSONObject jsonObject = JSONObject.parseObject(result);

        String status = jsonObject.getString("status");
        if (StringUtils.equals("OK", status)) {
            System.out.println("用户ID:{}的原手机号-----phone：{}解绑成功");
            return "success";
        }
        if (StringUtils.equals("error", status)) {
            System.out.println("用户ID:{}的原手机号-----phone：{}解绑失败");
            return "fail";
        }
        return result;
    }
}