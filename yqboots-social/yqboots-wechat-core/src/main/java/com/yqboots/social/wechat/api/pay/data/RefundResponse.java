package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class RefundResponse implements Serializable {
    /**
     * 返回状态码
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = FIELD_RETURN_CODE)
    private String returnCode;
    /**
     * 返回信息
     */
    @NonNull
    @NotEmpty
    @Length(max = 128)
    @XmlElement(name = FIELD_RETURN_MSG)
    private String returnMsg;
    /**
     * 业务结果 - SUCCESS/FAIL
     */
    @Length(max = 16)
    @XmlElement(name = FIELD_RESULT_CODE)
    private String resultCode;

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
     * 微信支付订单号, 微信的订单号，优先使用
     */
    @TransactionId
    @XmlElement(name = FIELD_TRANSACTION_ID)
    private String transactionId;

    /**
     * 商户订单号 - 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     * <br/>商户系统内部的订单号，当没提供transaction_id时需要传这个
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
     * 退款金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = FIELD_REFUND_FEE)
    private Integer refundFee;
    /**
     * 应结订单金额
     */
    @XmlElement(name = FIELD_SETTLEMENT_REFUND_FEE)
    private Integer settlementRefundFee;
    /**
     * 订单金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = FIELD_TOTAL_FEE)
    private Integer totalFee;
    /**
     * 应结订单金额
     */
    @XmlElement(name = FIELD_SETTLEMENT_TOTAL_FEE)
    private Integer settlementTotalFee;
    /**
     * 货币种类
     */
    @Length(max = 8)
    @XmlElement(name = FIELD_FEE_TYPE)
    private String feeType;
    /**
     * 现金支付金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = FIELD_CASH_FEE)
    private Integer cashFee;
    /**
     * 现金支付货币类型
     */
    @Length(max = 16)
    @XmlElement(name = FIELD_CASH_FEE_TYPE)
    private String cashFeeType;
    /**
     * 现金支付金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = FIELD_CASH_REFUND_FEE)
    private Integer cashRefundFee;

}
