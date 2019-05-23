package com.yqboots.social.wechat.service.impl;

import com.yqboots.commerce.order.context.event.OrderPaymentSuccessEvent;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationResponse;
import com.yqboots.social.wechat.constants.WeChatConstants;
import com.yqboots.social.wechat.service.WeChatPayService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class WeChatPayServiceImpl implements WeChatPayService, ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public PaymentResultNotificationResponse notifyPayment(PaymentResultNotificationRequest request) {
        // 支付成功后
        if (WeChatConstants.RETURN_CODE_SUCCESS.equals(request.getReturnCode())) {
            // 同步的，若处理异常，则抛出，不会返回成功报文
            applicationEventPublisher.publishEvent(new OrderPaymentSuccessEvent(this, request.getOutTradeNo()));

            return PaymentResultNotificationResponse.successResponse();
        }

        return PaymentResultNotificationResponse.failResponse();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
