package com.yqboots.social.wechat.api.auth.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Open Id for wechat
 */
@Data
public class GetAccessTokenResponse {
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "expires_in")
    private String expiresIn;
    @JsonProperty(value = "refresh_token")
    private String refreshToken;
    @JsonProperty(value = "openid")
    private String openId;
    private String scope;
    @JsonProperty(value = "unionid")
    private String unionId;
    @JsonProperty(value = "errcode")
    private String errCode;
    @JsonProperty(value = "errmsg")
    private String errMsg;
}
