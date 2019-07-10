package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenRequest;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GetAccessTokenRequestBuilder {
    private final WeChatProperties properties;

    public GetAccessTokenRequestBuilder(WeChatProperties properties) {
        this.properties = properties;
    }

    public GetAccessTokenRequest build(String code) {
        GetAccessTokenRequest result = new GetAccessTokenRequest();

        result.setAppId(properties.getAppId());
        result.setAppSecret(properties.getAppSecret());
        result.setCode(code);
        result.setGrantType("authorization_code");

        return result;
    }
}
