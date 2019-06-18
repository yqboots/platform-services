package com.yqboots.social.wechat.api.auth.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefreshAccessTokenRequest implements Serializable {
    private String appId; // app id
    private String refreshToken; // refresh_token
    private String grantType = "authorization_code"; // grant_type
}
