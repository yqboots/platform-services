package com.yqboots.social.wechat.server.endpoint;

import com.yqboots.social.wechat.constants.WeChatConstants;
import com.yqboots.social.wechat.schemas.OrderQueryRequest;
import com.yqboots.social.wechat.schemas.OrderQueryResponse;
import com.yqboots.social.wechat.server.service.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WeChatPayEndpoint {
    private WeChatPayService weChatPayService;

    @PayloadRoot(namespace = WeChatConstants.NAMESPACE_URI, localPart = "orderQueryRequest")
    @ResponsePayload
    public OrderQueryResponse queryOrder(@RequestPayload OrderQueryRequest request) {
        return weChatPayService.queryOrder(request);
    }

    @Autowired
    public void setWeChatPayService(WeChatPayService weChatPayService) {
        this.weChatPayService = weChatPayService;
    }
}
