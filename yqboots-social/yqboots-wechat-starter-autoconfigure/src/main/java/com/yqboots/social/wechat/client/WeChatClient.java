package com.yqboots.social.wechat.client;

import com.yqboots.social.wechat.api.auth.data.GetAccessTokenRequest;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.api.auth.data.RefreshAccessTokenRequest;
import com.yqboots.social.wechat.api.pay.data.*;

import java.io.IOException;

public interface WeChatClient {
    /**
     * Unified Order.
     *
     * @param request request
     * @return response
     */
    UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request);

    /**
     * Gets access token.
     *
     * @param request request
     * @return access token & open id
     */
    GetAccessTokenResponse getAccessToken(GetAccessTokenRequest request) throws IOException;

    /**
     * Gets refreshed access token
     *
     * @param request request
     * @return access token & open id
     */
    GetAccessTokenResponse getRefreshedAccessToken(RefreshAccessTokenRequest request) throws IOException;

    /**
     * 申请退款
     *
     * @param request request
     * @return 退款结果
     */
    RefundResponse doRefund(RefundRequest request);

    /**
     * 查询退款
     *
     * @param request request
     * @return 退款结果
     */
    RefundQueryResponse queryRefund(RefundQueryRequest request);

    /**
     * 查询订单
     *
     * @param request request
     * @return 查询结果
     */
    OrderQueryResponse queryOrder(OrderQueryRequest request);

    /**
     * 关闭订单
     *
     * @param request request
     * @return 关闭结果
     */
    OrderCloseResponse closeOrder(OrderCloseRequest request);
}
