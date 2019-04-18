package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.WeChatConstants;
import com.yqboots.social.wechat.api.pay.FeeType;
import com.yqboots.social.wechat.api.pay.LimitPay;
import com.yqboots.social.wechat.api.pay.SignType;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <h3>统一下单请求报文（XML格式）</h3>
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
public class UnifiedOrderRequest implements Serializable {
    /**
     * 应用ID
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String appId;
    /**
     * 商户号
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String mchId;
    /**
     * 设备号 - 终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @Length(max = 32)
    private String deviceInfo = WeChatConstants.DEFAULT_DEVICE_INF0;
    /**
     * 随机字符串
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String nonceStr;
    /**
     * 签名
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String sign;
    /**
     * 签名类型
     */
    @Length(max = 32)
    private String signType = SignType.MD5.getCode();
    /**
     * 商品描述
     */
    @NonNull
    @NotEmpty
    @Length(max = 128)
    private String body;
    /**
     * 商品详情
     */
    @Length(max = 8192)
    private String detail;
    /**
     * 附加数据
     */
    @Length(max = 127)
    private String attach;
    /**
     * 商户订单号 - 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     */
    @NonNull
    @NotEmpty
    @Length(max = 32)
    private String outTradeNo;
    /**
     * 货币类型 - 符合ISO 4217标准的三位字母代码，默认人民币CNY
     */
    @Length(max = 16)
    private String feeType = FeeType.CNY.name();
    /**
     * 总金额 - 订单总金额，单位为分
     */
    @NonNull
    @Min(0)
    private Integer totalFee = 0;
    /**
     * 终端IP - 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     */
    @Length(max = 64)
    private String spbillCreateIp;
    /**
     * 交易起始时间 - 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
     */
    @Length(max = 14)
    private String timeStart;
    /**
     * 交易结束时间 - 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010
     */
    @Length(max = 14)
    private String timeExpire;
    /**
     * 订单优惠标记 - 订单优惠标记，代金券或立减优惠功能的参数
     */
    @Length(max = 32)
    private String goodsTag;
    /**
     * 通知地址 - 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     */
    @NonNull
    @NotEmpty
    @Length(max = 256)
    private String notifyUrl;
    /**
     * 交易类型
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    private String tradeType;
    /**
     * 指定支付方式
     */
    @Length(max = 32)
    private String limitPay = LimitPay.no_credit.name();
    /**
     * 开发票入口开放标识 - Y，传入Y时，支付成功消息和支付详情页将出现开票入口。<br/>
     * 需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    @Length(max = 8)
    private String receipt;
}
