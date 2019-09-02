/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MultiResponse
 * Author:   Administrator
 * Date:     2019/8/21 19:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.common.response;

import java.util.Collection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class MultiResponse<T> extends Response<T> {
    private Collection<T> data;
    private long total;
    private int pageNum;
    private int pageSize;
    private int pageCount;

    public MultiResponse(int httpCode, String httpMsg) {
        super(httpCode, httpMsg);
    }

    public MultiResponse(int httpCode, String httpMsg, Collection<T> data) {
        super(httpCode, httpMsg);
        this.data = data;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public MultiResponse<T> setPageCount(int pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public Collection<T> getData() {
        return this.data;
    }

    public MultiResponse<T> setData(Collection<T> data) {
        this.data = data;
        return this;
    }

    public long getTotal() {
        return this.total;
    }

    public MultiResponse<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public MultiResponse<T> setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public MultiResponse<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
