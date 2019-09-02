/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SingleResponse
 * Author:   Administrator
 * Date:     2019/8/21 16:46
 * Description: SingleResposne
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tomoya.common.response;

/**
 * 〈一句话功能简述〉<br> 
 * 〈SingleResposne〉
 *
 * @author Administrator
 * @create 2019/8/21
 * @since 1.0.0
 */
public class SingleResponse<T> extends Response<T> {
    private T data;

    public SingleResponse(int httpCode, String httpMsg) {
        super(httpCode, httpMsg);
    }

    public SingleResponse(int httpCode, String httpMsg, T data) {
        super(httpCode, httpMsg);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public SingleResponse<T> setData(T data) {
        this.data = data;
        return this;
    }
}