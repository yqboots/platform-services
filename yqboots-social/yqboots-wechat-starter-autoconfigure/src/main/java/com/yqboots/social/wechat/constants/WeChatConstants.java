package com.yqboots.social.wechat.constants;

/**
 * 微信常量
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
public final class WeChatConstants {
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    public static final String RETURN_CODE_SUCCESS = SUCCESS;
    public static final String RETURN_CODE_FAIL = FAIL;

    public static final String RESULT_CODE_SUCCESS = SUCCESS;
    public static final String RESULT_CODE_FAIL = FAIL;

    /**
     * 此交易订单号不存在
     * <p>该API只能查提交支付交易返回成功的订单，请商户检查需要查询的订单号是否正确</p>
     */
    public static final String ERROR_CODE_ORDERNOTEXIST = "ORDERNOTEXIST";
    /**
     * 系统错误
     * <p>系统异常，请再调用发起查询</p>
     */
    public static final String ERROR_CODE_SYSTEMERROR = "SYSTEMERROR";

    public static final String DEFAULT_DEVICE_INFO = "WEB";
    public static final String PACKAGE = "Sign=WXPay";
}
