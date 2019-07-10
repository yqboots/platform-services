package com.yqboots.social.wechat.api.pay;

/**
 * 下单错误码
 */
public enum PayErrorCode {
    /**
     * <ul>参数错误
     * <li>原因：参数格式有误或者未按规则上传</li>
     * <li>解决方案：订单重入时，要求参数值与原请求一致，请确认参数问题</li>
     * </ul>
     */
    INVALID_REQUEST,
    /**
     * <ul>商户无此接口权限
     * <li>原因：商户未开通此接口权限</li>
     * <li>解决方案：请商户前往申请此接口权限</li>
     * </ul>
     */
    NOAUTH,
    /**
     * <ul>余额不足
     * <li>原因：用户帐号余额不足</li>
     * <li>解决方案：用户帐号余额不足，请用户充值或更换支付卡后再支付</li>
     * </ul>
     */
    NOTENOUGH,
    /**
     * <ul>商户订单已支付
     * <li>原因：商户订单已支付，无需重复操作</li>
     * <li>解决方案：商户订单已支付，无需更多操作</li>
     * </ul>
     */
    ORDERPAID,
    /**
     * <ul>订单已关闭
     * <li>原因：当前订单已关闭，无法支付</li>
     * <li>解决方案：当前订单已关闭，请重新下单</li>
     * </ul>
     */
    ORDERCLOSED,
    /**
     * <ul>系统错误
     * <li>原因：系统超时</li>
     * <li>解决方案：系统异常，请用相同参数重新调用</li>
     * </ul>
     */
    SYSTEMERROR,
    /**
     * <ul>APPID不存在
     * <li>原因：参数中缺少APPID</li>
     * <li>解决方案：请检查APPID是否正确</li>
     * </ul>
     */
    APPID_NOT_EXIST,
    /**
     * <ul>MCHID不存在
     * <li>原因：参数中缺少MCHID</li>
     * <li>解决方案：请检查MCHID是否正确</li>
     * </ul>
     */
    MCHID_NOT_EXIST,
    /**
     * <ul>appid和mch_id不匹配
     * <li>原因：appid和mch_id不匹配</li>
     * <li>解决方案：请确认appid和mch_id是否匹配</li>
     * </ul>
     */
    APPID_MCHID_NOT_MATCH,
    /**
     * <ul>缺少参数
     * <li>原因：缺少必要的请求参数</li>
     * <li>解决方案：请检查参数是否齐全</li>
     * </ul>
     */
    LACK_PARAMS,
    /**
     * <ul>商户订单号重复
     * <li>原因：同一笔交易不能多次提交</li>
     * <li>解决方案：请核实商户订单号是否重复提交</li>
     * </ul>
     */
    OUT_TRADE_NO_USED,
    /**
     * <ul>签名错误
     * <li>原因：参数签名结果不正确</li>
     * <li>解决方案：请检查签名参数和方法是否都符合签名算法要求</li>
     * </ul>
     */
    SIGNERROR,
    /**
     * <ul>XML格式错误
     * <li>原因：XML格式错误</li>
     * <li>解决方案：请检查XML参数格式是否正确</li>
     * </ul>
     */
    XML_FORMAT_ERROR,
    /**
     * <ul>请使用post方法
     * <li>原因：未使用post传递参数</li>
     * <li>解决方案：请检查请求参数是否通过post方法提交</li>
     * </ul>
     */
    REQUIRE_POST_METHOD,
    /**
     * <ul>post数据为空
     * <li>原因：post数据不能为空</li>
     * <li>解决方案：请检查post数据是否为空</li>
     * </ul>
     */
    POST_DATA_EMPTY,
    /**
     * <ul>编码格式错误
     * <li>原因：未使用指定编码格式</li>
     * <li>解决方案：请使用UTF8编码格式</li>
     * </ul>
     */
    NOT_UTF8
}
