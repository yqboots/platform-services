package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

/**
 * 提交退款申请后，通过调用该接口查询退款状态。
 * 退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
 */
@Data
@NoArgsConstructor
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundQueryRequest implements Serializable {
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
     * 微信支付订单号
     */
    @TransactionId
    @XmlElement(name = FIELD_TRANSACTION_ID)
    private String transactionId;
    /**
     * 商户订单号，商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     */
    @OutTradeNo
    @XmlElement(name = FIELD_OUT_TRADE_NO)
    private String outTradeNo;
    /**
     * 商户退款单号
     */
    @OutTradeNo
    @Length(max = 64)
    @XmlElement(name = FIELD_OUT_REFUND_NO)
    private String outRefundNo;
    /**
     * 微信退款单号
     */
    @OutTradeNo
    @Length(max = 32)
    @XmlElement(name = FIELD_REFUND_ID)
    private String refundId;
    /**
     * 偏移量
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_OFFSET)
    private Integer offset;
}
