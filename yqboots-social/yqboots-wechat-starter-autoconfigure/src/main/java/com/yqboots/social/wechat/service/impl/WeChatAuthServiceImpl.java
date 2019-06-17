package com.yqboots.social.wechat.service.impl;

import com.yqboots.social.wechat.api.auth.data.OpenIdResponse;
import com.yqboots.social.wechat.client.WeChatClient;
import com.yqboots.social.wechat.client.builder.OpenIdRequestBuilder;
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
    public OpenIdResponse getOpenIdRequest(String code) throws IOException {
        OpenIdRequestBuilder builder = applicationContext.getBean(OpenIdRequestBuilder.class);

        return weChatClient.getOpenID(builder.build(code));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
