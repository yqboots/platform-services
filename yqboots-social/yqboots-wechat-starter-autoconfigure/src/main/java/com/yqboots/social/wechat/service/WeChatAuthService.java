package com.yqboots.social.wechat.service;

import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.api.auth.data.GetUserInfoResponse;

import java.io.IOException;

public interface WeChatAuthService {
    /**
     * Login with WeChat
     *
     * @param code code
     * @throws IOException if can not parse the response string to object
     */
    void login(String code) throws IOException;

    GetAccessTokenResponse getAccessToken(String code) throws IOException;

    GetAccessTokenResponse getRefreshedAccessToken(String refreshToken) throws IOException;

    GetUserInfoResponse getCurrentUserInfo() throws IOException;
}
