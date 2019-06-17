package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.auth.data.OpenIdRequest;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OpenIdRequestBuilder {
    private final WeChatProperties properties;

    public OpenIdRequestBuilder(WeChatProperties properties) {
        this.properties = properties;
    }

    public OpenIdRequest build(String code) {
        OpenIdRequest result = new OpenIdRequest();

        result.setAppId(properties.getAppId());
        result.setAppSecret(properties.getAppSecret());
        result.setCode(code);
        result.setGrantType("authorization_code");

        return result;
    }
}
