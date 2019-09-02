/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ImportExcelLogServiceImpl
 * Author:   Administrator
 * Date:     2019/8/21 16:48
 * Description: 报表导入记录服务层实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.excelmodule.service.impl;

import com.alibaba.fastjson.JSON;
import com.tomoya.common.dto.PageView;
import com.tomoya.common.exception.MMLException;
import com.tomoya.common.statusenum.ImportExcelStatusEnum;
import com.tomoya.common.utils.ConvertUtil;
import com.tomoya.excelmodule.dao.ImportExcelLogDAO;
import com.tomoya.excelmodule.domain.ImportExcelLog;
import com.tomoya.excelmodule.dto.ImportExcelLogDTO;
import com.tomoya.excelmodule.dto.ImportExcelLogListDTO;
import com.tomoya.excelmodule.service.ImportExcelLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈报表导入记录服务层实现〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
@Service
public class ImportExcelLogServiceImpl implements ImportExcelLogService {
    @Autowired
    private ImportExcelLogDAO importExcelLogDAO;


    @Override
    public void save(ImportExcelLogDTO importExcelLogDTO) {
        ImportExcelLog save = importExcelLogDAO.save(ConvertUtil.beanCopy(importExcelLogDTO, ImportExcelLog.class));
        importExcelLogDTO.setId(save.getId());
    }


    @Override
    public ImportExcelLogDTO initLog(String fileName, String type, String createUser, Long createUserId, String url) {
        ImportExcelLogDTO importExcelLogDTO = new ImportExcelLogDTO();
        importExcelLogDTO.setCreateTime(new Date());
        importExcelLogDTO.setCreateUser(createUser);
        importExcelLogDTO.setCreateUserId(createUserId);
        importExcelLogDTO.setFileName(fileName);
        importExcelLogDTO.setStatus(ImportExcelStatusEnum.RUNNING.getStatus());
        importExcelLogDTO.setType(type);
        importExcelLogDTO.setUrl(url);
        save(importExcelLogDTO);
        return importExcelLogDTO;
    }


    @Override
    public ImportExcelLogListDTO searchByType(PageView pageView, String type) {
        ImportExcelLogListDTO importExcelLogListDTO = new ImportExcelLogListDTO();
        if(StringUtils.isNotEmpty(type)){
            Page<ImportExcelLog> all = importExcelLogDAO.findByType(type,new PageRequest(pageView.getPageNo(), pageView.getPageSize(),new Sort(Sort.Direction.DESC, "createTime")));
            importExcelLogListDTO.setListItemDTOS(ConvertUtil.listEntity2DTO(all.getContent(), ImportExcelLogDTO.class, (importExcelLog, importExcelLogDTO) -> {
                importExcelLogDTO.setResult(JSON.parseObject(importExcelLog.getResultJson()));
            }));
            importExcelLogListDTO.setTotalCount(all.getTotalElements());
        }else{
            Page<ImportExcelLog> all = importExcelLogDAO.findAll( new PageRequest(pageView.getPageNo(), pageView.getPageSize(),new Sort(Sort.Direction.DESC, "createTime")));
            importExcelLogListDTO.setListItemDTOS(ConvertUtil.listEntity2DTO(all.getContent(), ImportExcelLogDTO.class, (importExcelLog, importExcelLogDTO) -> {
                importExcelLogDTO.setResult(JSON.parseObject(importExcelLog.getResultJson()));
            }));
            importExcelLogListDTO.setTotalCount(all.getTotalElements());
        }

        return importExcelLogListDTO;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new MMLException("id不能为空");
        }
        importExcelLogDAO.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteImportRecords(List<Long> ids) {
        importExcelLogDAO.deleteByIdIn(ids);
    }

}