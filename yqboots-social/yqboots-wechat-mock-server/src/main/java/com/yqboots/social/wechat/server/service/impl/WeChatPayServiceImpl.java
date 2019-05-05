package com.yqboots.social.wechat.server.service.impl;

import com.yqboots.social.wechat.api.pay.data.OrderQueryRequest;
import com.yqboots.social.wechat.api.pay.data.OrderQueryResponse;
import com.yqboots.social.wechat.server.service.WeChatPayService;
import org.springframework.stereotype.Service;

@Service
public class WeChatPayServiceImpl implements WeChatPayService {
    public OrderQueryResponse queryOrder(OrderQueryRequest request) {
        OrderQueryResponse response = new OrderQueryResponse();
        response.setAppId(request.getAppId());
        response.setMchId(request.getMchId());
        response.setCashFee(100);
        return response;
    }
}
