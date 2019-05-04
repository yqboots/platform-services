package com.yqboots.social.wechat.server.service;

import com.yqboots.social.wechat.schemas.OrderQueryRequest;
import com.yqboots.social.wechat.schemas.OrderQueryResponse;

public interface WeChatPayService {
    OrderQueryResponse queryOrder(OrderQueryRequest request);
}
