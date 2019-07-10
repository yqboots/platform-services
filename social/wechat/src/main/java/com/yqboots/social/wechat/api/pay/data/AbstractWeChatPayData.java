package com.yqboots.social.wechat.api.pay.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yqboots.social.wechat.api.annotation.AppId;
import com.yqboots.social.wechat.api.annotation.MerchantId;
import com.yqboots.social.wechat.api.annotation.NonceStr;
import com.yqboots.social.wechat.api.annotation.Sign;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractWeChatPayData implements Serializable {
    /**
     * 应用ID
     */
    @AppId
    @XmlElement(name = FIELD_APPID)
    @JsonProperty(value = FIELD_APPID)
    private String appId;

    /**
     * 商户号
     */
    @MerchantId
    @XmlElement(name = FIELD_MERCHANT_ID)
    @JsonProperty(value = FIELD_MERCHANT_ID)
    private String mchId;
    /**
     * 随机字符串
     */
    @NonceStr
    @XmlElement(name = FIELD_NONCE_STR)
    @JsonProperty(value = FIELD_NONCE_STR)
    private String nonceStr;
    /**
     * 签名
     */
    @Sign
    @XmlElement(name = FIELD_SIGN)
    @JsonProperty(value = FIELD_SIGN)
    private String sign;
}
