package com.yqboots.social.wechat.api.pay;

import lombok.Getter;

/**
 * 签名类型
 */
public enum SignType {
    MD5("MD5"), HMAC_SHA256("HMAC-SHA256");

    @Getter
    private final String code;

    SignType(final String code) {
        this.code = code;
    }
}
