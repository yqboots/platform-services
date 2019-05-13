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

@Data
@NoArgsConstructor
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderCloseResponse implements Serializable {
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
     * 返回状态码
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = "return_code")
    private String returnCode;
    /**
     * 返回信息
     */
    @NonNull
    @NotEmpty
    @Length(max = 128)
    @XmlElement(name = "return_msg")
    private String returnMsg;

    /**
     * 业务结果 - SUCCESS/FAIL
     */
    @Length(max = 16)
    @XmlElement(name = FIELD_RESULT_CODE)
    private String resultCode;

    /**
     * 业务结果描述
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_RESULT_MSG)
    private String resultMsg;

    /**
     * 错误代码
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_ERROR_CODE)
    private String errCode;
    /**
     * 错误代码描述
     */
    @Length(max = 128)
    @XmlElement(name = FIELD_ERROR_CODE_DESCRIPTION)
    private String errCodeDes;
}
