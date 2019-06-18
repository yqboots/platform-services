package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.auth.data.RefreshAccessTokenRequest;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RefreshAccessTokenRequestBuilder {
    private final WeChatProperties properties;

    public RefreshAccessTokenRequestBuilder(WeChatProperties properties) {
        this.properties = properties;
    }

    public RefreshAccessTokenRequest build(String refreshToken) {
        RefreshAccessTokenRequest result = new RefreshAccessTokenRequest();

        result.setAppId(properties.getAppId());
        result.setRefreshToken(refreshToken);
        result.setGrantType("refresh_token");

        return result;
    }
}
