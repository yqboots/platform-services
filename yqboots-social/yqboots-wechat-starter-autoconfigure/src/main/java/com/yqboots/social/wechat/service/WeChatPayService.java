package com.yqboots.social.wechat.service;

import com.yqboots.social.wechat.api.pay.TradeType;
import com.yqboots.social.wechat.api.pay.data.InitiatePaymentRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationResponse;

public interface WeChatPayService {
    PaymentResultNotificationResponse notifyPayment(PaymentResultNotificationRequest request);

    InitiatePaymentRequest getInitiatePaymentRequest(String orderCode,
                                                     String ipAddress,
                                                     TradeType tradeType);
}
