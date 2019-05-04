package com.yqboots.social.wechat.server.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WeChatPayEndpoint {
    private static final String NAMESPACE_URI = "http://www.yqboots.com/ws/social/schema";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public Object queryOrder(@RequestPayload Object request) {
        return null;
    }
}
