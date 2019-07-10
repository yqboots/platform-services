package com.yqboots.social.wechat.service.impl;

import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.api.auth.data.GetUserInfoResponse;
import com.yqboots.social.wechat.client.WeChatClient;
import com.yqboots.social.wechat.client.builder.GetAccessTokenRequestBuilder;
import com.yqboots.social.wechat.client.builder.GetUserInfoRequestBuilder;
import com.yqboots.social.wechat.client.builder.RefreshAccessTokenRequestBuilder;
import com.yqboots.social.wechat.entity.WeChatUserProfile;
import com.yqboots.social.wechat.service.WeChatAuthService;
import com.yqboots.social.wechat.service.support.WeChatUserProfileHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional(readOnly = true)
public class WeChatAuthServiceImpl implements WeChatAuthService, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private final WeChatClient weChatClient;
    private final WeChatUserProfileHandler userProfileHandler;

    @Autowired
    public WeChatAuthServiceImpl(final WeChatClient weChatClient,
                                 final WeChatUserProfileHandler userProfileHandler) {
        this.weChatClient = weChatClient;
        this.userProfileHandler = userProfileHandler;
    }

    @Override
    public GetUserInfoResponse login(String code) throws IOException {
        GetAccessTokenResponse tokenResponse = getAccessToken(code);
        // store the token in DB
        WeChatUserProfile userProfile = userProfileHandler.storeUserProfile(tokenResponse);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userProfile.getUnionId(), null
        );
        token.setDetails(userProfile);
        SecurityContextHolder.getContext().setAuthentication(token);

        return getCurrentUserInfo();
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
    public GetUserInfoResponse getCurrentUserInfo() throws IOException {
        GetUserInfoRequestBuilder builder = applicationContext.getBean(GetUserInfoRequestBuilder.class);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeChatUserProfile profile = (WeChatUserProfile)authentication.getDetails();
        return weChatClient.getCurrentUserInfo(builder.build(profile.getAccessToken(), profile.getOpenId()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
