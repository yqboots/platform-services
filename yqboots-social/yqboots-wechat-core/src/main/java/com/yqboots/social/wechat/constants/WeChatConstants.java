package com.yqboots.social.wechat.constants;

/**
 * 微信常量
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
public final class WeChatConstants {
    public static final String NAMESPACE_URI = "http://www.yqboots.com/social/wechat/schemas";

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

    // FIELDS
    public static final String FIELD_ROOT_ELEMENT = "xml";
    public static final String FIELD_APPID = "appid";
    public static final String FIELD_ATTACH = "attach";
    public static final String FIELD_BANK_TYPE = "bank_type";
    public static final String FIELD_BODY = "body";
    public static final String FIELD_CASH_FEE = "cash_fee";
    public static final String FIELD_CASH_REFUND_FEE = "cash_refund_fee";
    public static final String FIELD_CASH_FEE_TYPE = "cash_fee_type";
    public static final String FIELD_COUPON_COUNT = "coupon_count";
    public static final String FIELD_COUPON_FEE = "coupon_fee";
    public static final String FIELD_DETAIL = "detail";
    public static final String FIELD_DEVICE_INFO = "device_info";
    public static final String FIELD_ERROR_CODE = "err_code";
    public static final String FIELD_ERROR_CODE_DESCRIPTION = "err_code_des";
    public static final String FIELD_FEE_TYPE = "fee_type";
    public static final String FIELD_GOODS_TAG = "goods_tag";
    public static final String FIELD_IS_SUBSCRIBE = "is_subscribe";
    public static final String FIELD_LIMIT_PAY = "limit_pay";
    public static final String FIELD_MERCHANT_ID = "mch_id";
    public static final String FIELD_NONCE_STR = "nonce_str";
    public static final String FIELD_NOTIFY_URL = "notify_url";
    public static final String FIELD_OPEN_ID = "openid";
    public static final String FIELD_OUT_TRADE_NO = "out_trade_no";
    public static final String FIELD_OUT_REFUND_NO = "out_refund_no";
    public static final String FIELD_REFUND_ID = "refund_id";
    public static final String FIELD_REFUND_FEE = "refund_fee";
    public static final String FIELD_REFUND_FEE_TYPE = "refundFeeType";
    public static final String FIELD_REFUND_DESC = "refundDesc";
    public static final String FIELD_REFUND_ACCOUNT = "refundAccount";
    public static final String FIELD_OFFSET = "offset";
    public static final String FIELD_PACKAGE = "package";
    public static final String FIELD_PARTNER_ID = "partnerid";
    public static final String FIELD_PREPAY_ID = "prepay_id";
    public static final String FIELD_RECEIPT = "receipt";
    public static final String FIELD_RESULT_CODE = "result_code";
    public static final String FIELD_RESULT_MSG = "result_msg";
    public static final String FIELD_RETURN_CODE = "return_code";
    public static final String FIELD_RETURN_MSG = "return_msg";
    public static final String FIELD_SETTLEMENT_TOTAL_FEE = "settlement_total_fee";
    public static final String FIELD_SETTLEMENT_REFUND_FEE = "settlement_refund_fee";
    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";
    public static final String FIELD_SPBILL_CREATE_IP = "spbill_create_ip";
    public static final String FIELD_TIME_END = "time_end";
    public static final String FIELD_TIME_EXPIRE = "time_expire";
    public static final String FIELD_TIME_START = "time_start";
    public static final String FIELD_TIMESTAMP = "timestamp";
    public static final String FIELD_TOTAL_FEE = "total_fee";
    public static final String FIELD_TRADE_STATE = "trade_state";
    public static final String FIELD_TRADE_STATE_DESCRIPTION = "trade_state_desc";
    public static final String FIELD_TRADE_TYPE = "trade_type";
    public static final String FIELD_TRANSACTION_ID = "transaction_id";
    public static final String FIELD_TOTAL_REFUND_COUNT = "total_refund_count";
}
