package com.yqboots.social.wechat.service.impl;

import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.client.WeChatClient;
import com.yqboots.social.wechat.client.builder.GetAccessTokenRequestBuilder;
import com.yqboots.social.wechat.client.builder.RefreshAccessTokenRequestBuilder;
import com.yqboots.social.wechat.service.WeChatAuthService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional(readOnly = true)
public class WeChatAuthServiceImpl implements WeChatAuthService, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private final WeChatClient weChatClient;

    @Autowired
    public WeChatAuthServiceImpl(WeChatClient weChatClient) {
        this.weChatClient = weChatClient;
    }

    @Override
    public GetAccessTokenResponse getAccessToken(String code) throws IOException {
        GetAccessTokenRequestBuilder builder = applicationContext.getBean(GetAccessTokenRequestBuilder.class);

        return weChatClient.getAccessToken(builder.build(code));
    }

    @Override
    public GetAccessTokenResponse getRefreshedAccessToken(String refreshToken) throws IOException {
        RefreshAccessTokenRequestBuilder builder = applicationContext.getBean(RefreshAccessTokenRequestBuilder.class);
        return weChatClient.getRefreshedAccessToken(builder.build(refreshToken));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
