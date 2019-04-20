package com.yqboots.social.wechat.web.config;

import com.yqboots.social.wechat.web.WeChatWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@ComponentScan(basePackageClasses = {WeChatWebApplication.class})
public class WeChatWebConfiguration {
}
