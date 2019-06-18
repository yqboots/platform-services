package com.yqboots.social.wechat.web.controller;

import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.api.auth.data.GetUserInfoResponse;
import com.yqboots.social.wechat.service.WeChatAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/wechat/auth")
public class WeChatAuthController {
    private WeChatAuthService weChatAuthService;

    @RequestMapping(
            value = {"/{code}"},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    )
    public GetAccessTokenResponse getAccessTokenRequest(@PathVariable String code) throws IOException {
        return weChatAuthService.getAccessToken(code);
    }

    @RequestMapping(
            value = {"/{refreshToken}/refresh"},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    )
    public GetAccessTokenResponse refreshTokenRequest(@PathVariable String refreshToken) throws IOException {
        return weChatAuthService.getRefreshedAccessToken(refreshToken);
    }

    @RequestMapping(
            value = {"/user/profile"},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    )
    public GetUserInfoResponse getUserInfoRequest() throws IOException {
        return weChatAuthService.getCurrentUserInfo();
    }

    @Autowired
    public void setWeChatAuthService(WeChatAuthService weChatAuthService) {
        this.weChatAuthService = weChatAuthService;
    }
}
