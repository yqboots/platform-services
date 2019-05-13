package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

@Data
@NoArgsConstructor
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderCloseRequest implements Serializable {
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
     * 商户订单号 - 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     */
    @OutTradeNo
    @XmlElement(name = FIELD_OUT_TRADE_NO)
    private String outTradeNo;

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
}
