package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.annotation.AppId;
import com.yqboots.social.wechat.api.annotation.MerchantId;
import com.yqboots.social.wechat.api.annotation.NonceStr;
import com.yqboots.social.wechat.api.annotation.Sign;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

/**
 * 下单返回报文
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderResponse implements Serializable {
    /**
     * 返回状态码 - SUCCESS/FAIL
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = "return_code")
    private String returnCode;
    /**
     * 返回信息
     */
    @Length(max = 128)
    @XmlElement(name = "return_msg")
    private String returnMsg;

    /**
     * 业务结果 - SUCCESS/FAIL
     */
    @Length(max = 16)
    @XmlElement(name = "result_code")
    private String resultCode;
    /**
     * 错误代码
     */
    @Length(max = 32)
    @XmlElement(name = "err_code")
    private String errCode;
    /**
     * 错误代码描述
     */
    @Length(max = 128)
    @XmlElement(name = "err_code_des")
    private String errCodeDes;

    /**
     * 应用ID
     */
    @AppId
    @XmlElement(name = FIELD_APPID)
    private String appId;
    /**
     * 商户号
     */
    @MerchantId
    @XmlElement(name = FIELD_MERCHANT_ID)
    private String mchId;
    /**
     * 设备号 - 终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_DEVICE_INFO)
    private String deviceInfo = DEFAULT_DEVICE_INFO;
    /**
     * 随机字符串
     */
    @NonceStr
    @XmlElement(name = FIELD_NONCE_STR)
    private String nonceStr;
    /**
     * 签名
     */
    @Sign
    @XmlElement(name = FIELD_SIGN)
    private String sign;

    /**
     * 交易类型 - 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP
     */
    @Length(max = 16)
    @XmlElement(name = FIELD_TRADE_TYPE)
    private String tradeType;
    /**
     * 预支付交易会话标识 - 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    @Length(max = 64)
    @XmlElement(name = FIELD_PREPAY_ID)
    private String prepayId;
}
