/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImportExcelLogDAO
 * Author:   Administrator
 * Date:     2019/8/21 16:50
 * Description: 报表导入记录dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.test.exportreportperformance.dao;

import com.tomoya.test.exportreportperformance.domain.ExportExcelLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈报表导入记录dao〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
@Repository
public interface ExportExcelLogDAO extends JpaRepository<ExportExcelLog, Long>, JpaSpecificationExecutor<ExportExcelLog> {

    List<ExportExcelLog> findByType(String type);

    Page<ExportExcelLog> findByType(String type, Pageable pageable);

    void deleteByIdIn(List<Long> ids);

}