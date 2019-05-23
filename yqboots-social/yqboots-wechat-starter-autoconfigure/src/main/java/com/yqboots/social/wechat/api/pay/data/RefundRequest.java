package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.annotation.OutTradeNo;
import com.yqboots.social.wechat.api.annotation.TransactionId;
import com.yqboots.social.wechat.api.pay.SignType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

/**
 * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，
 * 卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundRequest extends AbstractWeChatPayData {
    /**
     * 签名类型
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_SIGN_TYPE)
    private String signType = SignType.MD5.getCode();
    /**
     * 微信支付订单号, 微信的订单号，优先使用
     */
    @TransactionId
    @XmlElement(name = FIELD_TRANSACTION_ID)
    private String transactionId;
    /**
     * 商户订单号 - 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
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
     * 订单金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = FIELD_TOTAL_FEE)
    private Integer totalFee;
    /**
     * 退款金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = FIELD_REFUND_FEE)
    private Integer refundFee;
    /**
     * 退款金额
     */
    @Length(max = 8)
    @XmlElement(name = FIELD_REFUND_FEE_TYPE)
    private String refundFeeType;
    /**
     * 退款原因
     */
    @Length(max = 80)
    @XmlElement(name = FIELD_REFUND_DESC)
    private String refundDesc;
    /**
     * 退款资金来源
     */
    @Length(max = 30)
    @XmlElement(name = FIELD_REFUND_ACCOUNT)
    private String refundAccount;
    /**
     * 通知地址
     */
    @NonNull
    @NotEmpty
    @Length(max = 256)
    @XmlElement(name = FIELD_NOTIFY_URL)
    private String notifyUrl;
}
