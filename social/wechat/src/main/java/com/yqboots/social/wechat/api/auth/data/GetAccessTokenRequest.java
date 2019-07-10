package com.yqboots.social.wechat.api.auth.data;

import lombok.Data;

@Data
public class GetAccessTokenRequest {
    private String appId; // app id
    private String appSecret; // app secret
    private String code; // code
    private String grantType = "authorization_code"; // grant_type
}
