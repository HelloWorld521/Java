package com.springboot.demo.common.domain;

import java.util.HashMap;
import java.util.Map;

public class ResponseBo extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResponseBo() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static ResponseBo error() {
        return error(1, "操作失败");
    }

    public static ResponseBo error(String msg) {
        return error(500, msg);
    }

    public static ResponseBo error(int code, String msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", code);
        responseBo.put("msg", msg);
        return responseBo;
    }

    public static ResponseBo ok(String msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("msg", msg);
        return responseBo;
    }

    public static ResponseBo ok(Map<String, Object> map) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.putAll(map);
        return responseBo;
    }

    public static ResponseBo ok() {
        return new ResponseBo();
    }

    @Override
    public ResponseBo put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}