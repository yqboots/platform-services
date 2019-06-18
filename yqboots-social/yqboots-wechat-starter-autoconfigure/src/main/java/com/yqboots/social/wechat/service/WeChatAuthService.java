package com.yqboots.social.wechat.service;

import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;

import java.io.IOException;

public interface WeChatAuthService {
    GetAccessTokenResponse getAccessToken(String code) throws IOException;

    GetAccessTokenResponse getRefreshedAccessToken(String refreshToken) throws IOException;
}
