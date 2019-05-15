package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.annotation.OutTradeNo;
import com.yqboots.social.wechat.api.annotation.TransactionId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

/**
 * <h3><a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_2&index=4">查询订单</a></h3>
 * <p>该接口提供所有微信支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。</p>
 * <ul>需要调用查询接口的情况：
 * <li>当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；</li>
 * <li>调用支付接口后，返回系统错误或未知交易状态情况；</li>
 * <li>调用被扫支付API，返回USERPAYING的状态；</li>
 * <li>调用关单或撤销接口API之前，需确认支付状态；</li>
 * </ul>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderQueryRequest extends AbstractWeChatPayData {
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
}
