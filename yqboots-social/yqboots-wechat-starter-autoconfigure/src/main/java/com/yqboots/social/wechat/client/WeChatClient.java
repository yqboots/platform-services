package com.yqboots.social.wechat.client;

import com.yqboots.social.wechat.api.auth.data.OpenIdRequest;
import com.yqboots.social.wechat.api.pay.data.RefundRequest;
import com.yqboots.social.wechat.api.pay.data.RefundResponse;

public interface WeChatClient {
    /**
     * Gets open id.
     *
     * @param request request
     * @return open id
     */
    String getOpenID(OpenIdRequest request);

    RefundResponse doRefund(RefundRequest request);
}
