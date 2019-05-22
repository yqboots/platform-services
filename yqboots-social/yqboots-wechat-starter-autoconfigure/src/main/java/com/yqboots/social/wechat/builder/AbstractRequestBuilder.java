package com.yqboots.social.wechat.builder;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.pay.TradeType;
import com.yqboots.social.wechat.constants.WeChatConstants;
import com.yqboots.social.wechat.support.WeChatPayParameters;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractRequestBuilder<T extends Serializable> {
    private final WeChatPayParameters params;
    private final WeChatProperties properties;

    AbstractRequestBuilder(@Autowired WeChatProperties properties) {
        this.properties = properties;
        this.params = new WeChatPayParameters();
        this.params.add(WeChatConstants.FIELD_APPID, properties.getAppId());
        this.params.add(WeChatConstants.FIELD_MERCHANT_ID, properties.getPartnerId());
    }

    protected abstract T build(Order order, String clientIP, TradeType tradeType);

    void addParameter(String key, String value) {
        getParams().add(key, value);
    }

    String generateSignature() {
        return getParams().generateSignature(properties.getPartnerKey());
    }

    WeChatPayParameters getParams() {
        return params;
    }

    WeChatProperties getProperties() {
        return properties;
    }
}
