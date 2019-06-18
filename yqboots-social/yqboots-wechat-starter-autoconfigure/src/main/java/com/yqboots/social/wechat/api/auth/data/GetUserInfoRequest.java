package com.yqboots.social.wechat.api.auth.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class GetUserInfoRequest implements Serializable {
    @JsonProperty(value = "access_token")
    private String accessToken;
    @JsonProperty(value = "openid")
    private String openId;
    @JsonProperty(value = "lang")
    private String language;
}
