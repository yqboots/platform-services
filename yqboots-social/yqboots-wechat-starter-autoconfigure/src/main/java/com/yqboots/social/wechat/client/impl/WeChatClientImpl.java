package com.yqboots.social.wechat.client.impl;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.auth.data.OpenIdRequest;
import com.yqboots.social.wechat.api.auth.data.OpenIdResponse;
import com.yqboots.social.wechat.api.pay.data.RefundRequest;
import com.yqboots.social.wechat.api.pay.data.RefundResponse;
import com.yqboots.social.wechat.client.WeChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeChatClientImpl implements WeChatClient {
    private final RestTemplate restTemplate;

    private final WeChatProperties properties;

    public WeChatClientImpl(final RestTemplate restTemplate, final WeChatProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getOpenID(OpenIdRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", request.getAppId());
        params.put("secret", request.getAppSecret());
        params.put("code", request.getCode());
        params.put("grant_type", request.getGrantType());

        ResponseEntity<OpenIdResponse> response = this.restTemplate.getForEntity(
                properties.getAuth().getAccessTokenUrl(),
                OpenIdResponse.class,
                params
        );

        if (response.hasBody()) {
            return Objects.requireNonNull(response.getBody()).getOpenId();
        }

        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public RefundResponse doRefund(RefundRequest request) {
        return null;
    }
}
