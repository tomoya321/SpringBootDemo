/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: importExcelLogService
 * Author:   Administrator
 * Date:     2019/8/21 16:05
 * Description: 报表导入记录服务层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.excelmodule.service;

import com.tomoya.common.dto.PageView;
import com.tomoya.excelmodule.dto.ImportExcelLogDTO;
import com.tomoya.excelmodule.dto.ImportExcelLogListDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈报表导入记录服务层〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public interface ImportExcelLogService {

    void save(ImportExcelLogDTO importExcelLogDTO);

    ImportExcelLogListDTO searchByType(PageView pageView, String type);

    void delete(Long id);

    ImportExcelLogDTO initLog(String fileName, String type, String createUser, Long createUserId, String url);

    void deleteImportRecords(List<Long> ids);
}