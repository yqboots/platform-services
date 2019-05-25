package com.yqboots.social.wechat.service.impl;

import com.yqboots.commerce.order.context.event.OrderPaymentSuccessEvent;
import com.yqboots.commerce.order.entity.Order;
import com.yqboots.commerce.order.service.OrderService;
import com.yqboots.social.wechat.api.pay.TradeType;
import com.yqboots.social.wechat.api.pay.data.InitiatePaymentRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationResponse;
import com.yqboots.social.wechat.api.pay.data.UnifiedOrderResponse;
import com.yqboots.social.wechat.client.WeChatClient;
import com.yqboots.social.wechat.client.builder.InitiatePaymentRequestBuilder;
import com.yqboots.social.wechat.client.builder.UnifiedOrderRequestBuilder;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import com.yqboots.social.wechat.constants.WeChatConstants;
import com.yqboots.social.wechat.service.WeChatPayService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class WeChatPayServiceImpl implements WeChatPayService, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private final OrderService orderService;
    private final WeChatClient weChatClient;

    @Autowired
    public WeChatPayServiceImpl(OrderService orderService, WeChatClient weChatClient) {
        this.orderService = orderService;
        this.weChatClient = weChatClient;
    }

    @Override
    public PaymentResultNotificationResponse notifyPayment(PaymentResultNotificationRequest request) {
        // 支付成功后
        if (WeChatConstants.RETURN_CODE_SUCCESS.equals(request.getReturnCode())) {
            // 同步的，若处理异常，则抛出，不会返回成功报文
            applicationContext.publishEvent(new OrderPaymentSuccessEvent(this, request.getOutTradeNo()));

            return PaymentResultNotificationResponse.successResponse();
        }

        return PaymentResultNotificationResponse.failResponse();
    }

    @Override
    public InitiatePaymentRequest getInitiatePaymentRequest(String orderCode,
                                                            String ipAddress,
                                                            TradeType tradeType) {
        UnifiedOrderRequestBuilder builder = applicationContext.getBean(UnifiedOrderRequestBuilder.class);

        Order order = orderService.getOrder(orderCode);
        UnifiedOrderResponse response = weChatClient.unifiedOrder(builder.build(
                new RequestBuilderParameters()
                        .setOrder(order)
                        .setClientIP(ipAddress)
                        .setTradeType(tradeType)
        ));

        InitiatePaymentRequestBuilder initiateBuilder = applicationContext.getBean(InitiatePaymentRequestBuilder.class);

        return initiateBuilder.build(new RequestBuilderParameters().setPrepayId(response.getPrepayId()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
