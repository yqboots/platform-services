package com.yqboots.social.wechat.api.pay.data;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 下单返回报文
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Data
public class UnifiedOrderResponse implements Serializable {
    /**
     * 返回状态码 - SUCCESS/FAIL
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    private String returnCode;
    /**
     * 返回信息
     */
    @Length(max = 128)
    private String returnMsg;

    /**
     * 业务结果 - SUCCESS/FAIL
     */
    @Length(max = 16)
    private String resultCode;
    /**
     * 错误代码
     */
    @Length(max = 32)
    private String errCode;
    /**
     * 错误代码描述
     */
    @Length(max = 128)
    private String errCodeDes;

    /**
     * 应用ID
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String appId;
    /**
     * 商户号
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String mchId;
    /**
     * 设备号 - 终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @Length(max = 32)
    private String deviceInfo = "WEB";
    /**
     * 随机字符串
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String nonceStr;
    /**
     * 签名
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String sign;

    /**
     * 交易类型 - 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP
     */
    @Length(max = 16)
    private String tradeType;
    /**
     * 预支付交易会话标识 - 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    @Length(max = 64)
    private String prepayId;
}
