/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResponseDSL
 * Author:   Administrator
 * Date:     2019/8/21 19:36
 * Description: response领域类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.common.response;

import java.util.Collection;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈response领域类〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class ResponseDSL {
    public ResponseDSL() {
    }

    public static <T> ResponseDSL.SingleResponseBuilder<T> singleResponse(int code, String message, T data) {
        return new ResponseDSL.SingleResponseBuilder(code, message, data);
    }

    public static <T> ResponseDSL.MultiResponseBuilder<T> multiResponse(int code, String message, Collection<T> datas) {
        return new ResponseDSL.MultiResponseBuilder(code, message, datas);
    }

    public static <T> ResponseDSL.SingleResponseBuilder<T> responseNoData(int code, String message) {
        return new ResponseDSL.SingleResponseBuilder(code, message);
    }

    public static <T> ResponseDSL.SingleResponseBuilder<T> singleResponseByResponseCode(Response.ResponseCode code, T data) {
        return singleResponse(code.getCode(), code.getMessage(), data);
    }

    public static <T> ResponseDSL.MultiResponseBuilder<T> multiResponseByResponseCode(Response.ResponseCode code, Collection<T> datas) {
        return multiResponse(code.getCode(), code.getMessage(), datas);
    }

    public static <T> ResponseDSL.SingleResponseBuilder<T> responseNoDataByResponseCode(Response.ResponseCode code) {
        return responseNoData(code.getCode(), code.getMessage());
    }

    public static <T> ResponseDSL.SingleResponseBuilder<T> singleResponseOk(T data) {
        return singleResponseByResponseCode(Response.ResponseCode.HTTP_OK, data);
    }

    public static <T> ResponseDSL.MultiResponseBuilder<T> multiResponseOk(Collection<T> datas) {
        return multiResponseByResponseCode(Response.ResponseCode.HTTP_OK, datas);
    }

    public static <T> ResponseDSL.SingleResponseBuilder<T> responseNoDataOk() {
        return responseNoDataByResponseCode(Response.ResponseCode.HTTP_NO_CONTENT);
    }

    public static <T> ResponseDSL.SingleResponseBuilder<T> responseError() {
        return responseNoDataByResponseCode(Response.ResponseCode.HTTP_SERVER_ERROR);
    }

    public static class MultiResponseBuilder<T> {
        private int httpCode;
        private String message;
        private Collection<T> data;
        private long total;
        private int pageSize;
        private int pageNum;
        private int pageCount;

        private MultiResponseBuilder(int httpCode, String message, Collection<T> data) {
            this.total = 0L;
            this.pageSize = 0;
            this.pageNum = 0;
            this.pageCount = 0;
            this.httpCode = httpCode;
            this.message = message;
            this.data = data;
        }

        public ResponseDSL.MultiResponseBuilder<T> setTotal(long total) {
            this.total = total;
            return this;
        }

        public ResponseDSL.MultiResponseBuilder<T> setPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ResponseDSL.MultiResponseBuilder<T> setPageNum(int pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public ResponseDSL.MultiResponseBuilder<T> setData(Collection<T> data) {
            this.data.addAll(data);
            return this;
        }

//        public ResponseDSL.MultiResponseBuilder<T> withPage(List<T> page) {
//            if (page instanceof Page) {
//                this.data.addAll(((Page)page).getResult());
//                this.pageNum = ((Page)page).getPageNum();
//                this.pageSize = ((Page)page).getPageSize();
//                this.total = ((Page)page).getTotal();
//                this.pageCount = ((Page)page).getPages();
//            } else {
//                this.data.addAll(page);
//            }
//
//            return this;
//        }

        public MultiResponse<T> build() {
            return (new MultiResponse(this.httpCode, this.message)).setData(this.data).setPageNum(this.pageNum).setPageSize(this.pageSize).setTotal(this.total).setPageCount(this.pageCount);
        }
    }

    public static class SingleResponseBuilder<T> {
        private int httpCode;
        private String message;
        private T data;

        private SingleResponseBuilder(int httpCode, String message, T data) {
            this.httpCode = httpCode;
            this.message = message;
            this.data = data;
        }

        private SingleResponseBuilder(int httpCode, String message) {
            this.httpCode = httpCode;
            this.message = message;
        }

        public SingleResponse<T> build() {
            return new SingleResponse(this.httpCode, this.message, this.data);
        }
    }
}