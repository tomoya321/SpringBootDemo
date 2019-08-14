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
}