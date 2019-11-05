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


import com.tomoya.apilog.dao.ApiLogDao;
import com.tomoya.apilog.domain.ApiLog;
import com.tomoya.apilog.service.ApiLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
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
        ApiLog apiLog = new ApiLog();
        apiLog.setType(type);
        apiLog.setPostTime(new Date());
        apiLog.setRequest(request);
        apiLog.setResponse(response);
        apiLog.setError(error);
        apiLogDao.save(apiLog);
    }
}