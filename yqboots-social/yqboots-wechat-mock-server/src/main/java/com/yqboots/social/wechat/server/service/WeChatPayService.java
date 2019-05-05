package com.yqboots.social.wechat.server.service;

import com.yqboots.social.wechat.api.pay.data.OrderQueryRequest;
import com.yqboots.social.wechat.api.pay.data.OrderQueryResponse;

public interface WeChatPayService {
    OrderQueryResponse queryOrder(OrderQueryRequest request);
}
