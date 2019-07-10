package com.yqboots.social.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WeChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeChatApplication.class, args);
    }
}
