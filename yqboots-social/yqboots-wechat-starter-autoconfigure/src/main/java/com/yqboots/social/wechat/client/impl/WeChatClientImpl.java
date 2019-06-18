package com.yqboots.social.wechat.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenRequest;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.api.auth.data.RefreshAccessTokenRequest;
import com.yqboots.social.wechat.api.pay.data.*;
import com.yqboots.social.wechat.client.WeChatClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeChatClientImpl implements WeChatClient {
    private final RestTemplate restTemplate;

    private final WeChatProperties properties;

    private final Jaxb2Marshaller jaxb2Marshaller;
    private final ObjectMapper objectMapper;

    public WeChatClientImpl(final RestTemplate restTemplate,
                            final WeChatProperties properties,
                            final Jaxb2Marshaller jaxb2Marshaller,
                            final ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.properties = properties;
        this.jaxb2Marshaller = jaxb2Marshaller;
        this.objectMapper = objectMapper;
    }

    @Override
    public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request) {
        return invoke(request, properties.getPay().getUnifiedOrderUrl());
    }

    /**
     * @inheritDoc
     */
    @Override
    public GetAccessTokenResponse getAccessToken(GetAccessTokenRequest request) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", request.getAppId());
        params.put("secret", request.getAppSecret());
        params.put("code", request.getCode());
        params.put("grant_type", request.getGrantType());

        String url = properties.getAuth().getAccessTokenUrl() +
                "?appid={appid}&secret={secret}&code={code}&grant_type={grant_type}";
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                url,
                String.class,
                params
        );

        if (response.getBody() != null) {
            return objectMapper.readValue(
                    response.getBody().getBytes(StandardCharsets.UTF_8),
                    GetAccessTokenResponse.class
            );
        }

        return null;
    }

    @Override
    public GetAccessTokenResponse getRefreshedAccessToken(RefreshAccessTokenRequest request) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", request.getAppId());
        params.put("refreshToken", request.getRefreshToken());
        params.put("grant_type", request.getGrantType());

        String url = properties.getAuth().getRefreshTokenUrl() +
                "?appid={appid}&refresh_token={refresh_token}&grant_type={grant_type}";
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                url,
                String.class,
                params
        );

        if (response.getBody() != null) {
            return objectMapper.readValue(
                    response.getBody().getBytes(StandardCharsets.UTF_8),
                    GetAccessTokenResponse.class
            );
        }

        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public RefundResponse doRefund(RefundRequest request) {
        return invoke(request, properties.getPay().getRefundUrl());
    }

    /**
     * @inheritDoc
     */
    @Override
    public RefundQueryResponse queryRefund(RefundQueryRequest request) {
        return invoke(request, properties.getPay().getRefundQueryUrl());
    }

    /**
     * @inheritDoc
     */
    @Override
    public OrderQueryResponse queryOrder(OrderQueryRequest request) {
        return invoke(request, properties.getPay().getOrderQueryUrl());
    }

    /**
     * @inheritDoc
     */
    @Override
    public OrderCloseResponse closeOrder(OrderCloseRequest request) {
        return invoke(request, properties.getPay().getOrderCloseUrl());
    }

    @SuppressWarnings({"unchecked"})
    private <REQ extends Serializable, RES extends Serializable> RES invoke(REQ request, String url) {
        StringResult requestStr = new StringResult();
        jaxb2Marshaller.marshal(request, requestStr);

        HttpEntity<String> httpEntity = new HttpEntity<>(requestStr.toString(), getCommonXmlHeaders());

        ResponseEntity<String> response = restTemplate.postForEntity(
                url,
                httpEntity,
                String.class
        );

        return (RES) jaxb2Marshaller.unmarshal(new StringSource(Objects.requireNonNull(response.getBody())));
    }

    private static HttpHeaders getCommonXmlHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.set("Content-Type", MediaType.APPLICATION_XML_VALUE);

        return headers;
    }

    private static HttpHeaders getCommonJsonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        return headers;
    }
}
