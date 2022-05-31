package com.xcloud.util.result;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 返回值 code必须为int message为信息 data为请求成功后返回的数据
 * @author xuehy
 * @since 2022/5/31
 */
public class Result extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1l;

    public Result() {

    }

    public Result(Object data) {
        put("data", data);
    }

    public Result(int code, String msg) {
        put("code", code);
        put("message", msg);
    }

    public Result(int code, String msg, Object data) {
        put("code", code);
        put("message", msg);
        put("data", data);
    }

    public static Result success() {
        Result r = new Result();
        r.put("code", ResultCode.SUCCESS);
        r.put("message", "操作成功");
        return r;
    }

    public static Result success(Object data) {
        Result r = new Result();
        r.put("code", ResultCode.SUCCESS);
        r.put("message", "操作成功");
        r.put("data", data);
        return r;
    }

    public static Result success(String msg, Object data) {
        Result r = new Result();
        r.put("code", ResultCode.SUCCESS);
        r.put("message", msg);
        r.put("data", data);
        return r;
    }

    public static Result fail() {
        return fail(ResultCode.ERR, "发生错误,请联系管理员");
    }

    public static Result fail(String msg) {
        return fail(ResultCode.ERR, msg);
    }

    public static Result busy() {
        return fail(ResultCode.BUSY, "服务繁忙,请稍后重试");
    }

    public static Result fail(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("message", msg);
        return r;
    }

    public boolean isSuccess() {
        if (this.get("code") instanceof Integer) {
            return (int) this.get("code") == ResultCode.SUCCESS;
        }
        return false;
    }

}
