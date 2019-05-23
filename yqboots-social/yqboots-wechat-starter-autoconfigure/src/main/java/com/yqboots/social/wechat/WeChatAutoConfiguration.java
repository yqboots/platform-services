package com.yqboots.social.wechat;

import com.yqboots.social.wechat.api.auth.data.OpenIdRequest;
import com.yqboots.social.wechat.api.auth.data.OpenIdResponse;
import com.yqboots.social.wechat.api.pay.data.*;
import com.yqboots.social.wechat.client.WeChatClient;
import com.yqboots.social.wechat.client.impl.WeChatClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

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
    private static final Logger LOG = LoggerFactory.getLogger(WeChatAutoConfiguration.class);

    private WeChatProperties properties;

    @Bean
    public WeChatClient weChatClient() throws Exception {
        return new WeChatClientImpl(restTemplate(), properties, jaxb2Marshaller());
    }

    // @PostConstruct
    protected void loadCert() throws KeyStoreException, IOException {
        File cert;
        try {
            cert = ResourceUtils.getFile(properties.getPay().getCertPath());
        } catch (FileNotFoundException e) {
            LOG.warn("wechat cert not found, some apis may not work", e);
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(cert);
        ) {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(fis, properties.getPartnerId().toCharArray());
        } catch (CertificateException | NoSuchAlgorithmException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private RestTemplate restTemplate() throws Exception {
        return new RestTemplate();
        /*return new RestTemplate(new HttpComponentsClientHttpRequestFactory(
                HttpClientUtils.acceptsTrustedCertsHttpClient(properties.getPartnerId()))
        );*/
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
