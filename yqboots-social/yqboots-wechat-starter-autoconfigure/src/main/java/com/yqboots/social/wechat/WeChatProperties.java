package com.yqboots.social.wechat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * WeChat properties
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "yqboots.social.wechat")
public class WeChatProperties {
    private String appId;
    private String appSecret;
    private String partnerId;
    private String partnerKey;
    private PayProperties pay;

    @Data
    public static class PayProperties {
        private String unifiedOrderUrl;
        private String orderQueryUrl;
    }
}
