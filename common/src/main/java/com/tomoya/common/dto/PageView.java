/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageView
 * Author:   Administrator
 * Date:     2019/8/21 16:37
 * Description: 分页实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.common.dto;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈分页实体类〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class PageView {
    private List records;
    private long pageCount;
    private int pageSize = 10;
    private int pageNo = 1;
    private long rowCount;
    private int startPage;
    private int pagecode = 10;

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getRowCount() {
        return rowCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public PageView() {
    }

    public int getFirstResult() {
        return (this.pageNo - 1) * this.pageSize;
    }

    public int getPagecode() {
        return this.pagecode;
    }

    public void setPagecode(int pagecode) {
        this.pagecode = pagecode;
    }

    public PageView(int pageSize, int pageNo) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public PageView(int pageNo) {
        this.pageNo = pageNo;
        this.startPage = (this.pageNo - 1) * this.pageSize;
    }

    public void setQueryResult(long rowCount, List records) {
        this.setRowCount(rowCount);
        this.setRecords(records);
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
        this.setPageCount(this.rowCount % (long)this.pageSize == 0L ? this.rowCount / (long)this.pageSize : this.rowCount / (long)this.pageSize + 1L);
    }
}