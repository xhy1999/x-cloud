package com.xcloud.util.result;

/**
 * 返回值常数
 * @author xuehy
 * @since 2021/5/20
 */
public class ResultCode {

    //成功
    public static final int SUCCESS = 0;
    //失败
    public static final int ERR = 500;
    //限流/降级/系统保护
    public static final int BUSY = 1000;

    //参数错误
    public static final int ERR_PARAM = 400;

}
