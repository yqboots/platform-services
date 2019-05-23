package com.yqboots.social.wechat.service;

import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationResponse;

public interface WeChatPayService {
    PaymentResultNotificationResponse notifyPayment(PaymentResultNotificationRequest request);
}
