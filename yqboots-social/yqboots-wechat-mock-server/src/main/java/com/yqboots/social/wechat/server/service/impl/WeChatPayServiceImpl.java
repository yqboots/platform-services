package com.yqboots.social.wechat.server.service.impl;

import com.yqboots.social.wechat.schemas.OrderQueryRequest;
import com.yqboots.social.wechat.schemas.OrderQueryResponse;
import com.yqboots.social.wechat.server.service.WeChatPayService;
import org.springframework.stereotype.Service;

@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    public OrderQueryResponse queryOrder(OrderQueryRequest request) {
        return new OrderQueryResponse();
    }
}
