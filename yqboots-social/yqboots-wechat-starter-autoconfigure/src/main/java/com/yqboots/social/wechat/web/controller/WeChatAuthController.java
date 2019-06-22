package com.yqboots.social.wechat.web.controller;

import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
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
    public GetAccessTokenResponse login(@PathVariable String code) throws IOException {
        return weChatAuthService.getAccessToken(code);
    }

    @Autowired
    public void setWeChatAuthService(WeChatAuthService weChatAuthService) {
        this.weChatAuthService = weChatAuthService;
    }
}
