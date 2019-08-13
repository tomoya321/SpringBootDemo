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
package com.tomoya.test;

import com.tomoya.annoation.ApiLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        //ceshixiugai zengjiadaima2222222222 123123
        return "apiLog return" + request;        //ceshixiugai zengjiadaima222222222 13123

    }

    @ApiLog(logType = "test")
    @PostMapping("/postRequestBody")
    public String testPostRequestBody(@RequestBody ApiLog apiLog) throws Exception {
        System.out.println(apiLog.toString());
        return "apiLog return";
    }

    //todo json传参?  master jiusuanjiejue222222?
//    shajibawanyi
}