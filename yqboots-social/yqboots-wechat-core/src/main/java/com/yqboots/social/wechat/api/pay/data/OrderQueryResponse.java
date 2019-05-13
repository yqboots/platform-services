package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.annotation.*;
import com.yqboots.social.wechat.api.pay.FeeType;
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
import java.util.List;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

/**
 * 查询订单返回报文
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderQueryResponse implements Serializable {
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
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = FIELD_NONCE_STR)
    private String nonceStr;
    /**
     * 签名
     */
    @Sign
    @XmlElement(name = FIELD_SIGN)
    private String sign;

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
     * 设备号 - 终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_DEVICE_INFO)
    private String deviceInfo = DEFAULT_DEVICE_INFO;

    /**
     * 用户标识 - 用户在商户appid下的唯一标识
     */
    @NonNull
    @NotEmpty
    @Length(max = 128)
    @XmlElement(name = FIELD_OPEN_ID)
    private String openId;

    /**
     * 是否关注公众账号
     */
    @NonNull
    @NotEmpty
    @Length(max = 1)
    @XmlElement(name = FIELD_IS_SUBSCRIBE)
    private String isSubscribe;

    /**
     * 交易类型
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = FIELD_TRADE_TYPE)
    private String tradeType;
    /**
     * 交易状态
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = FIELD_TRADE_STATE)
    private String tradeState;

    /**
     * 付款银行
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = FIELD_BANK_TYPE)
    private String bankType;
    /**
     * 总金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = FIELD_TOTAL_FEE)
    private Integer totalFee;
    /**
     * 货币类型 - 符合ISO 4217标准的三位字母代码，默认人民币CNY
     */
    @Length(max = 16)
    @XmlElement(name = FIELD_FEE_TYPE)
    private String feeType = FeeType.CNY.name();
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
     * 应结订单金额
     */
    @XmlElement(name = FIELD_SETTLEMENT_TOTAL_FEE)
    private Integer settlementTotalFee;

    /**
     * 代金券金额
     */
    @Length(max = 1)
    @XmlElement(name = FIELD_COUPON_FEE)
    private Integer couponFee;

    /**
     * 代金券使用数量
     */
    @Length(max = 1)
    @XmlElement(name = FIELD_COUPON_COUNT)
    private Integer couponCount;

    /**
     * 代金券ID
     */
    @XmlElement(name = "coupon_ids")
    private List<String> couponIds; // coupon_id_$n
    /**
     * 代金券类型
     */
    @XmlElement(name = "coupon_types")
    private List<String> couponTypes; // coupon_type_$n
    /**
     * 代金券支付金额
     */
    @XmlElement(name = "coupon_fees")
    private List<Integer> couponFees; // coupon_fee_$n

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
     * 附加数据
     */
    @Length(max = 128)
    @XmlElement(name = FIELD_ATTACH)
    private String attach;
    /**
     * 支付完成时间，支付完成时间，格式为yyyyMMddHHmmss
     */
    @NonNull
    @NotEmpty
    @Length(max = 14)
    @XmlElement(name = FIELD_TIME_END)
    private String timeEnd;

    @Length(max = 256)
    @XmlElement(name = FIELD_TRADE_STATE_DESCRIPTION)
    private String tradeStateDesc;
}
