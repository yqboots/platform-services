package com.yqboots.social.wechat;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * WeChat auto configuration
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(WeChatProperties.class)
public class WeChatAutoConfiguration {
}
