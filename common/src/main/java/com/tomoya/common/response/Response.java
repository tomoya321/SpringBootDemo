/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResponseCode
 * Author:   Administrator
 * Date:     2019/8/21 19:38
 * Description: responsecode
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.common.response;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈responsecode〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 815861485460502164L;
    private int code;
    private String message;

    Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static enum ResponseCode {
        HTTP_OK(200, "操作成功"),
        HTTP_NO_CONTENT(204, "操作成功"),
        HTTP_SERVER_ERROR(500, "服务异常");

        private int code;
        private String message;

        private ResponseCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
}