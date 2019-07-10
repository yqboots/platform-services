package com.yqboots.commerce.order.context.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 订单支付成功后事件
 */
public class OrderPaymentSuccessEvent extends ApplicationEvent {
    @Getter
    private final String orderCode;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source    the object on which the event initially occurred (never {@code null})
     * @param orderCode order code
     */
    public OrderPaymentSuccessEvent(Object source, String orderCode) {
        super(source);

        this.orderCode = orderCode;
    }
}
