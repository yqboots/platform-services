package com.yqboots.social.wechat.api.auth.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CheckAccessTokenValidResponse implements Serializable {
    @JsonProperty(value = "errcode")
    private String errCode;
    @JsonProperty(value = "errmsg")
    private String errMsg;
}
