package com.yqboots.social.wechat.service;

import com.yqboots.social.wechat.api.auth.data.OpenIdResponse;

import java.io.IOException;

public interface WeChatAuthService {
    OpenIdResponse getOpenIdRequest(String code) throws IOException;
}
