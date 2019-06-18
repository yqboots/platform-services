package com.yqboots.social.wechat.client;

import com.yqboots.social.wechat.api.auth.data.*;
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
     * @throws IOException if can not parse the response
     */
    GetAccessTokenResponse getAccessToken(GetAccessTokenRequest request) throws IOException;

    /**
     * Gets refreshed access token
     *
     * @param request request
     * @return access token & open id
     * @throws IOException if can not parse the response
     */
    GetAccessTokenResponse getRefreshedAccessToken(RefreshAccessTokenRequest request) throws IOException;

    /**
     * @param request request
     * @return token valid response
     * @throws IOException if can not parse the response
     */
    CheckAccessTokenValidResponse getCheckAccessTokenValid(CheckAccessTokenValidRequest request) throws IOException;

    /**
     * 获取当前登录用户信息
     *
     * @param request request
     * @return user info
     * @throws IOException if can not parse the response
     */
    GetUserInfoResponse getCurrentUserInfo(GetUserInfoRequest request) throws IOException;

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
