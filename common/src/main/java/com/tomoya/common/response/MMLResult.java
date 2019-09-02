//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tomoya.common.response;

import java.util.HashMap;
import java.util.Map;

public class MMLResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public MMLResult() {
        this.put((String)"httpcode", 200);
    }

    public static MMLResult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static MMLResult error(String msg) {
        return error(500, msg);
    }

    public static MMLResult error(int code, String msg) {
        MMLResult r = new MMLResult();
        r.put((String)"httpcode", code);
        r.put((String)"httpmsg", msg);
        return r;
    }

    public static MMLResult ok(String msg) {
        MMLResult r = new MMLResult();
        r.put((String)"httpmsg", msg);
        return r;
    }

    public static MMLResult ok(Map<String, Object> map) {
        MMLResult r = new MMLResult();
        r.putAll(map);
        return r;
    }

    public static MMLResult ok() {
        return new MMLResult();
    }

    @Override
    public MMLResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
