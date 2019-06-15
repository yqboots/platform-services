package com.yqboots.social.wechat;

import com.yqboots.social.wechat.api.auth.data.OpenIdRequest;
import com.yqboots.social.wechat.api.auth.data.OpenIdResponse;
import com.yqboots.social.wechat.api.pay.data.*;
import com.yqboots.social.wechat.client.WeChatClient;
import com.yqboots.social.wechat.client.impl.WeChatClientImpl;
import com.yqboots.social.wechat.client.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * WeChat auto configuration
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(WeChatProperties.class)
@ComponentScan(basePackageClasses = {WeChatAutoConfiguration.class})
public class WeChatAutoConfiguration {
    private WeChatProperties properties;

    @Bean
    public WeChatClient weChatClient() throws Exception {
        return new WeChatClientImpl(restTemplate(), properties, jaxb2Marshaller());
    }

    private RestTemplate restTemplate() throws Exception {
        RestTemplate bean = new RestTemplate(new HttpComponentsClientHttpRequestFactory(
                HttpClientUtils.acceptsTrustedCertsHttpClient(
                        properties.getPay().getCertPath(),
                        properties.getPartnerId())
        ));
        // 解决中文乱码的问题
        bean.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        return bean;
    }

    private Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(
                OpenIdRequest.class, OpenIdResponse.class,
                InitiatePaymentRequest.class,
                OrderCloseRequest.class, OrderCloseResponse.class,
                OrderQueryRequest.class, OrderQueryResponse.class,
                PaymentResultNotificationRequest.class, PaymentResultNotificationResponse.class,
                RefundQueryRequest.class, RefundQueryResponse.class,
                RefundRequest.class, RefundResponse.class,
                UnifiedOrderRequest.class, UnifiedOrderResponse.class
        );

        return marshaller;
    }

    @Autowired
    public void setProperties(WeChatProperties properties) {
        this.properties = properties;
    }
}
