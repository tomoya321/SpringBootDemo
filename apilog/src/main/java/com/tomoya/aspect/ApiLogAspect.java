/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiLogAspect
 * Author:   Administrator
 * Date:     2019/8/9 10:59
 * Description: ApiLog切面类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.aspect;

import com.alibaba.fastjson.JSON;
import com.tomoya.annoation.ApiLog;
import com.tomoya.service.ApiLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈ApiLog切面类〉
 *
 * @author Administrator
 * @create 2019/8/9
 * @since 1.0.0
 */
@Component
@Aspect
public class ApiLogAspect {
    @Autowired
    private ApiLogService apiLogService;
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.tomoya.annoation.ApiLog)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(){
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(value="pointCut() && @annotation(apiLog)",returning = "result")
    public void afterReturning(JoinPoint joinPoint, ApiLog apiLog, Object result){
        apiLogService.saveLog(apiLog.logType(), JSON.toJSONString(joinPoint.getArgs()), JSON.toJSONString(result), String.valueOf(System.currentTimeMillis()-startTime.get()));
    }

    @AfterThrowing(value="pointCut() && @annotation(apiLog)",throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, ApiLog apiLog, Throwable error){
        apiLogService.saveLog(apiLog.logType(), JSON.toJSONString(joinPoint.getArgs()), error.getMessage(), String.valueOf(System.currentTimeMillis()-startTime.get())+"|" + error.getMessage());
    }


}