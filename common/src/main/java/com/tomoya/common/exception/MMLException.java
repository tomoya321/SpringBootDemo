package com.tomoya.common.exception;

public class MMLException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String httpmsg;
    private int httpcode = 500;

    public MMLException() {
        this.httpmsg = "未知异常，请联系管理员";
    }

    public MMLException(String msg) {
        super(msg);
        this.httpmsg = msg;
    }

    public MMLException(int code, String msg) {
        super(msg);
        this.httpcode = code;
        this.httpmsg = msg;
    }

    public MMLException(String msg, Throwable e) {
        super(msg, e);
        this.httpmsg = msg;
    }

    public MMLException(int code, String msg, Throwable e) {
        super(msg, e);
        this.httpmsg = msg;
        this.httpcode = code;
    }

    public String getHttpmsg() {
        return this.httpmsg;
    }

    public void setHttpmsg(String httpmsg) {
        this.httpmsg = httpmsg;
    }

    public int getHttpcode() {
        return this.httpcode;
    }

    public void setHttpcode(int httpcode) {
        this.httpcode = httpcode;
    }
}
