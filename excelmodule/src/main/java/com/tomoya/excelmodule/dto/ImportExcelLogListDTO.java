/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImportExcelLogListDTO
 * Author:   Administrator
 * Date:     2019/8/21 16:11
 * Description: 订单导入记录列表转换类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.excelmodule.dto;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈订单导入记录列表转换类〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class ImportExcelLogListDTO {

    private List<ImportExcelLogDTO> listItemDTOS;

    private Long totalCount;

    public List<ImportExcelLogDTO> getListItemDTOS() {
        return listItemDTOS;
    }

    public void setListItemDTOS(List<ImportExcelLogDTO> listItemDTOS) {
        this.listItemDTOS = listItemDTOS;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}