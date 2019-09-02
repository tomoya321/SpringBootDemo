/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImportExcelLogController
 * Author:   Administrator
 * Date:     2019/8/21 16:06
 * Description: 订单导入记录控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.excelmodule.controller;

import com.tomoya.common.controller.BaseController;
import com.tomoya.common.dto.PageView;
import com.tomoya.common.response.ResponseDSL;
import com.tomoya.common.response.SingleResponse;
import com.tomoya.excelmodule.dto.ImportExcelLogListDTO;
import com.tomoya.excelmodule.service.ImportExcelLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈订单导入记录控制层〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
@RestController
public class ImportExcelLogController extends BaseController {

    @Autowired
    ImportExcelLogService importExcelLogService;

    @GetMapping(value = "")
    public SingleResponse<ImportExcelLogListDTO> reportExcelList(@RequestParam(required = false) String pageNo,
                                                                 @RequestParam(required = false) String pageSize,
                                                                 @RequestParam(required = false) String type
    ) throws Exception {
        PageView pageView = getPageView(pageNo, pageSize);
        ImportExcelLogListDTO importExcelLogListDTO = importExcelLogService.searchByType(pageView, type);
        return ResponseDSL.singleResponseOk(importExcelLogListDTO).build();
    }
}