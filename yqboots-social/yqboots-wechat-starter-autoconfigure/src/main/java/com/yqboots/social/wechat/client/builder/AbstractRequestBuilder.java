package com.yqboots.social.wechat.client.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import com.yqboots.social.wechat.client.builder.support.WeChatPayParameters;
import com.yqboots.social.wechat.constants.WeChatConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.Serializable;

public abstract class AbstractRequestBuilder<T extends Serializable> {
    private final WeChatPayParameters params;
    private final WeChatProperties properties;

    private ObjectMapper objectMapper;

    AbstractRequestBuilder(WeChatProperties properties) {
        this.properties = properties;
        this.params = new WeChatPayParameters();
        this.params.add(WeChatConstants.FIELD_APPID, properties.getAppId());
        this.params.add(WeChatConstants.FIELD_MERCHANT_ID, properties.getPartnerId());
    }

    protected abstract T build(RequestBuilderParameters builderParameters);

    void addParameter(String key, String value) {
        getParams().add(key, value);
    }

    void removeParameter(String key) {
        getParams().remove(key);
    }

    @SuppressWarnings("unchecked")
    T convertToBean(T bean) {
        try {
            String json = getObjectMapper().writeValueAsString(getParams().getParameters());

            return (T) getObjectMapper().readValue(json, bean.getClass());
        } catch (IOException e) {
            return null;
        }
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

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }
}
