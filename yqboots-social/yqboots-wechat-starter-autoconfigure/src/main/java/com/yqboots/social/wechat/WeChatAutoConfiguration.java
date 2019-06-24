package com.yqboots.social.wechat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqboots.commerce.core.entity.SequenceRepository;
import com.yqboots.commerce.core.id.KeyGenerator;
import com.yqboots.commerce.core.id.PersistentKeyGenerator;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenRequest;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.api.pay.data.*;
import com.yqboots.social.wechat.client.WeChatClient;
import com.yqboots.social.wechat.client.impl.WeChatClientImpl;
import com.yqboots.social.wechat.client.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

import static com.yqboots.social.wechat.WeChatBeans.WECHAT_CUSTOMER_NAME_KEY_GENERATOR;

/**
 * WeChat auto configuration
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(WeChatProperties.class)
@EntityScan(basePackageClasses = {WeChatAutoConfiguration.class})
@EnableJpaRepositories(basePackageClasses = {WeChatAutoConfiguration.class})
@ComponentScan(basePackageClasses = {WeChatAutoConfiguration.class})
public class WeChatAutoConfiguration {
    private static final String WE_CHAT_PREFIX = "WC";

    private WeChatProperties properties;

    @Bean
    public WeChatClient weChatClient(ObjectMapper objectMapper) throws Exception {
        return new WeChatClientImpl(restTemplate(), properties, jaxb2Marshaller(), objectMapper);
    }

    @Bean(name = WECHAT_CUSTOMER_NAME_KEY_GENERATOR)
    public KeyGenerator weChatCustomerNameKeyGenerator(SequenceRepository sequenceRepository) {
        return new PersistentKeyGenerator(WE_CHAT_PREFIX, sequenceRepository);
    }

    private RestTemplate restTemplate() throws Exception {
        RestTemplate bean = new RestTemplate(new HttpComponentsClientHttpRequestFactory(
                HttpClientUtils.acceptsTrustedCertsHttpClient(
                        properties.getPay().getCertPath(),
                        properties.getPartnerId())
        ));
        // 解决中文乱码的问题
        bean.getMessageConverters().stream()
                .filter(converter -> converter instanceof StringHttpMessageConverter)
                .forEach(converter -> ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8));

        return bean;
    }

    private Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(
                GetAccessTokenRequest.class, GetAccessTokenResponse.class,
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
