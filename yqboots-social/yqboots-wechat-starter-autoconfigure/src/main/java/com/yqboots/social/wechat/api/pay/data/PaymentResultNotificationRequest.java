package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.WeChatConstants;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <h3><a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_7&index=3">支付结果通知</a></h3>
 * <p>支付完成后，微信会把相关支付结果及用户信息通过数据流的形式发送给商户，商户需要接收处理，并按文档规范返回应答。</p>
 * <ul>注意：
 * <li>同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知。</li>
 * <li>后台通知交互时，如果微信收到商户的应答不符合规范或超时，微信会判定本次通知失败，重新发送通知，直到成功为止（在通知一直不成功的情况下，微信总共会发起10次通知，通知频率为15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h - 总计 24h4m），但微信不保证通知最终一定能成功。</li>
 * <li>在订单状态不明或者没有收到微信支付结果通知的情况下，建议商户主动调用微信支付【查询订单API】确认订单状态。</li>
 * </ul>
 * <br/>
 * <ul>特别提醒：
 * <li>商户系统对于支付结果通知的内容一定要做签名验证,并校验返回的订单金额是否与商户侧的订单金额一致，防止数据泄漏导致出现“假通知”，造成资金损失。</li>
 * <li>当收到通知进行处理时，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。在对业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。</li>
 * </ul>
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentResultNotificationRequest {
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
     * 应用ID
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = "appid")
    private String appId;
    /**
     * 商户号
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = "mch_id")
    private String mchId;
    /**
     * 设备号 - 终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @Length(max = 32)
    @XmlElement(name = "device_info")
    private String deviceInfo = WeChatConstants.DEFAULT_DEVICE_INF0;
    /**
     * 随机字符串
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = "nonce_str")
    private String nonceStr;
    /**
     * 签名
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = "sign")
    private String sign;

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
     * 用户标识 - 用户在商户appid下的唯一标识
     */
    @NonNull
    @NotEmpty
    @Length(max = 128)
    @XmlElement(name = "openid")
    private String openId;
    /**
     * 是否关注公众账号
     */
    @NonNull
    @NotEmpty
    @Length(max = 1)
    @XmlElement(name = "is_subscribe")
    private String isSubscribe;
    /**
     * 交易类型
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = "trade_type")
    private String tradeType;
    /**
     * 付款银行
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = "bank_type")
    private String bankType;
    /**
     * 总金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = "total_fee")
    private Integer totalFee;
    /**
     * 货币种类
     */
    @Length(max = 8)
    @XmlElement(name = "fee_type")
    private String feeType;
    /**
     * 现金支付金额
     */
    @NonNull
    @NotNull
    @XmlElement(name = "cash_fee")
    private Integer cashFee;
    /**
     * 现金支付货币类型
     */
    @Length(max = 16)
    @XmlElement(name = "cash_fee_type")
    private String cashFeeType;
    /**
     * 代金券金额
     */
    @Length(max = 1)
    @XmlElement(name = "coupon_fee")
    private Integer couponFee;
    /**
     * 代金券使用数量
     */
    @Length(max = 1)
    @XmlElement(name = "coupon_count")
    private Integer couponCount;
    /**
     * 代金券ID
     */
    @XmlElement(name = "is_subscribe")
    private List<String> couponIds; // coupon_id_$n
    /**
     * 代金券支付金额
     */
    @XmlElement(name = "coupon_fees")
    private List<Integer> couponFees; // coupon_fee_$n
    /**
     * 微信支付订单号
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = "transaction_id")
    private String transactionId;
    /**
     * 商户订单号，商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @XmlElement(name = "out_trade_no")
    private String outTradeNo;
    /**
     * 商家数据包，原样返回
     */
    @Length(max = 128)
    @XmlElement(name = "attach")
    private String attach;
    /**
     * 支付完成时间，支付完成时间，格式为yyyyMMddHHmmss
     */
    @NonNull
    @NotEmpty
    @Length(max = 14)
    @XmlElement(name = "time_end")
    private String timeEnd;
}
