package com.yqboots.social.wechat.builder;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.pay.FeeType;
import com.yqboots.social.wechat.api.pay.LimitPay;
import com.yqboots.social.wechat.api.pay.SignType;
import com.yqboots.social.wechat.api.pay.TradeType;
import com.yqboots.social.wechat.api.pay.data.UnifiedOrderRequest;
import com.yqboots.social.wechat.constants.WeChatConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UnifiedOrderRequestBuilder extends AbstractRequestBuilder<UnifiedOrderRequest> {
    public UnifiedOrderRequestBuilder(@Autowired WeChatProperties properties) {
        super(properties);
    }

    @Override
    public UnifiedOrderRequest build(Order order, String clientIP, TradeType tradeType) {
        addParameter(WeChatConstants.FIELD_DEVICE_INFO, WeChatConstants.DEFAULT_DEVICE_INFO);
        addParameter(WeChatConstants.FIELD_NONCE_STR, getParams().generateNonce());
        addParameter(WeChatConstants.FIELD_BODY, order.getEntries().get(0).getProduct().getName());
        addParameter(WeChatConstants.FIELD_DETAIL, "");
        addParameter(WeChatConstants.FIELD_ATTACH, "");
        addParameter(WeChatConstants.FIELD_OUT_TRADE_NO, order.getCode());
        if (getProperties().getTestMode()) {
            addParameter(WeChatConstants.FIELD_TOTAL_FEE, "1");
        } else {
            addParameter(WeChatConstants.FIELD_TOTAL_FEE, String.valueOf(order.getTotalPrice() * 100));
        }
        addParameter(WeChatConstants.FIELD_FEE_TYPE, FeeType.CNY.name());
        addParameter(WeChatConstants.FIELD_SIGN_TYPE, SignType.MD5.getCode());
        addParameter(WeChatConstants.FIELD_SPBILL_CREATE_IP, clientIP);
        addParameter(WeChatConstants.FIELD_TIME_START, "");
        addParameter(WeChatConstants.FIELD_TIME_EXPIRE, "");
        addParameter(WeChatConstants.FIELD_GOODS_TAG, "");
        addParameter(WeChatConstants.FIELD_NOTIFY_URL, getProperties().getPay().getPayNotifyUrl());
        addParameter(WeChatConstants.FIELD_TRADE_TYPE, tradeType.name());
        addParameter(WeChatConstants.FIELD_LIMIT_PAY, LimitPay.no_credit.name());
        addParameter(WeChatConstants.FIELD_RECEIPT, "");
        addParameter(WeChatConstants.FIELD_SIGN, generateSignature());

        return convertToBean(new UnifiedOrderRequest());
    }
}
