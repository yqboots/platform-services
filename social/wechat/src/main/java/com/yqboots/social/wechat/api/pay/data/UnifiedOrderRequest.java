package com.yqboots.social.wechat.api.pay.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yqboots.social.wechat.api.annotation.OutTradeNo;
import com.yqboots.social.wechat.api.pay.FeeType;
import com.yqboots.social.wechat.api.pay.LimitPay;
import com.yqboots.social.wechat.api.pay.SignType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

/**
 * <h3><a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_1">统一下单请求报文</a>（XML格式）</h3>
 * <p>商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再在APP里面调起支付。</p>
 * <p>URL地址: https://api.mch.weixin.qq.com/pay/unifiedorder</p>
 * <p>示例如下：</p>
 * <code><pre>
 * <xml>
 *  <appid>wx2421b1c4370ec43b</appid>
 *  <attach>支付测试</attach>
 *  <body>APP支付测试</body>
 *  <mch_id>10000100</mch_id>
 *  <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
 *  <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>
 *  <out_trade_no>1415659990</out_trade_no>
 *  <spbill_create_ip>14.23.150.211</spbill_create_ip>
 *  <total_fee>1</total_fee>
 *  <trade_type>APP</trade_type>
 *  <sign>0CB01533B8C1EF103065174F50BCA001</sign>
 * </xml>
 * </pre></code>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderRequest extends AbstractWeChatPayData {
    /**
     * 设备号 - 终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_DEVICE_INFO)
    @JsonProperty(value = FIELD_DEVICE_INFO)
    private String deviceInfo;
    /**
     * 签名类型
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_SIGN_TYPE)
    @JsonProperty(value = FIELD_SIGN_TYPE)
    private String signType;
    /**
     * 商品描述
     */
    @NonNull
    @NotEmpty
    @Length(max = 128)
    @XmlElement(name = FIELD_BODY)
    @JsonProperty(value = FIELD_BODY)
    private String body;
    /**
     * 商品详情
     */
    @Length(max = 8192)
    @XmlElement(name = FIELD_DETAIL)
    @JsonProperty(value = FIELD_DETAIL)
    private String detail;
    /**
     * 附加数据
     */
    @Length(max = 128)
    @XmlElement(name = FIELD_ATTACH)
    @JsonProperty(value = FIELD_ATTACH)
    private String attach;
    /**
     * 商户订单号 - 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     */
    @OutTradeNo
    @XmlElement(name = FIELD_OUT_TRADE_NO)
    @JsonProperty(value = FIELD_OUT_TRADE_NO)
    private String outTradeNo;
    /**
     * 货币类型 - 符合ISO 4217标准的三位字母代码，默认人民币CNY
     */
    @Length(max = 16)
    @XmlElement(name = FIELD_FEE_TYPE)
    @JsonProperty(value = FIELD_FEE_TYPE)
    private String feeType;
    /**
     * 总金额 - 订单总金额，单位为分
     */
    @NonNull
    @Min(0)
    @XmlElement(name = FIELD_TOTAL_FEE)
    @JsonProperty(value = FIELD_TOTAL_FEE)
    private Integer totalFee;
    /**
     * 终端IP - 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     */
    @Length(max = 64)
    @XmlElement(name = FIELD_SPBILL_CREATE_IP)
    @JsonProperty(value = FIELD_SPBILL_CREATE_IP)
    private String spbillCreateIp;
    /**
     * 交易起始时间 - 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
     */
    @Length(max = 14)
    @XmlElement(name = FIELD_TIME_START)
    @JsonProperty(value = FIELD_TIME_START)
    private String timeStart;
    /**
     * 交易结束时间 - 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010
     */
    @Length(max = 14)
    @XmlElement(name = FIELD_TIME_EXPIRE)
    @JsonProperty(value = FIELD_TIME_EXPIRE)
    private String timeExpire;
    /**
     * 订单优惠标记 - 订单优惠标记，代金券或立减优惠功能的参数
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_GOODS_TAG)
    @JsonProperty(value = FIELD_GOODS_TAG)
    private String goodsTag;
    /**
     * 通知地址 - 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     */
    @NonNull
    @NotEmpty
    @Length(max = 256)
    @XmlElement(name = FIELD_NOTIFY_URL)
    @JsonProperty(value = FIELD_NOTIFY_URL)
    private String notifyUrl;
    /**
     * 交易类型
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = FIELD_TRADE_TYPE)
    @JsonProperty(value = FIELD_TRADE_TYPE)
    private String tradeType;
    /**
     * 指定支付方式
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_LIMIT_PAY)
    @JsonProperty(value = FIELD_LIMIT_PAY)
    private String limitPay;
    /**
     * 开发票入口开放标识 - Y，传入Y时，支付成功消息和支付详情页将出现开票入口。<br/>
     * 需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    @Length(max = 8)
    @XmlElement(name = FIELD_RECEIPT)
    @JsonProperty(value = FIELD_RECEIPT)
    private String receipt;
}
