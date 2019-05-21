package com.yqboots.social.wechat.builder;

import com.yqboots.commerce.order.entity.AbstractOrder;
import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.pay.TradeType;
import com.yqboots.social.wechat.api.pay.data.UnifiedOrderRequest;
import com.yqboots.social.wechat.constants.WeChatConstants;
import org.springframework.beans.factory.annotation.Value;

public class UnifiedOrderRequestBuilder extends AbstractRequestBuilder<UnifiedOrderRequest> {
    @Value("yqboots.social.wechat.test-mode")
    private Boolean testMode;

    public UnifiedOrderRequestBuilder(WeChatProperties properties) {
        super(properties);
    }

    @Override
    public UnifiedOrderRequest build(AbstractOrder order, String clientIP, TradeType tradeType) {
        UnifiedOrderRequest result = new UnifiedOrderRequest();

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
        addParameter(WeChatConstants.FIELD_SPBILL_CREATE_IP, clientIP);
        addParameter(WeChatConstants.FIELD_TIME_START, "");
        addParameter(WeChatConstants.FIELD_TIME_EXPIRE, "");
        addParameter(WeChatConstants.FIELD_GOODS_TAG, "");
        addParameter(WeChatConstants.FIELD_NOTIFY_URL, getProperties().getPay().getPayNotifyUrl());
        addParameter(WeChatConstants.FIELD_TRADE_TYPE, tradeType.name());
        addParameter(WeChatConstants.FIELD_LIMIT_PAY, "");
        addParameter(WeChatConstants.FIELD_RECEIPT, "");
        addParameter(WeChatConstants.FIELD_SIGN, generateSignature());

        return result;
    }
}
