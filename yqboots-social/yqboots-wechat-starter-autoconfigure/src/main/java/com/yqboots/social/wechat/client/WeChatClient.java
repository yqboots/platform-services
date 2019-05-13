package com.yqboots.social.wechat.client;

import com.yqboots.social.wechat.api.auth.data.OpenIdRequest;
import com.yqboots.social.wechat.api.auth.data.OpenIdResponse;
import com.yqboots.social.wechat.api.pay.data.*;

public interface WeChatClient {
    /**
     * Gets open id.
     *
     * @param request request
     * @return open id
     */
    OpenIdResponse getOpenID(OpenIdRequest request);

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
