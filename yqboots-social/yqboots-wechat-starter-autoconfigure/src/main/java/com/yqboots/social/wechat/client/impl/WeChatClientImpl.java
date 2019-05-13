package com.yqboots.social.wechat.client.impl;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.auth.data.OpenIdRequest;
import com.yqboots.social.wechat.api.auth.data.OpenIdResponse;
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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeChatClientImpl implements WeChatClient {
    private final RestTemplate restTemplate;

    private final WeChatProperties properties;

    private final Jaxb2Marshaller jaxb2Marshaller;

    public WeChatClientImpl(final RestTemplate restTemplate,
                            final WeChatProperties properties,
                            final Jaxb2Marshaller jaxb2Marshaller) {
        this.restTemplate = restTemplate;
        this.properties = properties;
        this.jaxb2Marshaller = jaxb2Marshaller;
    }

    /**
     * @inheritDoc
     */
    @Override
    public OpenIdResponse getOpenID(OpenIdRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", request.getAppId());
        params.put("secret", request.getAppSecret());
        params.put("code", request.getCode());
        params.put("grant_type", request.getGrantType());

        ResponseEntity<OpenIdResponse> response = this.restTemplate.getForEntity(
                properties.getAuth().getAccessTokenUrl(),
                OpenIdResponse.class,
                params
        );

        return Objects.requireNonNull(response.getBody());
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
}
