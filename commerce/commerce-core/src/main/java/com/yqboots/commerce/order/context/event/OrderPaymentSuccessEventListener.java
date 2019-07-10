package com.yqboots.commerce.order.context.event;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.commerce.order.entity.OrderStatus;
import com.yqboots.commerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPaymentSuccessEventListener implements ApplicationListener<OrderPaymentSuccessEvent> {
    private OrderService orderService;

    @Override
    public void onApplicationEvent(OrderPaymentSuccessEvent event) {
        Order order = orderService.getOrder(event.getOrderCode());
        if (order.getStatus() != OrderStatus.PENDING_PAYMENT) {
            return;
        }

        orderService.markAsPaid(order);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
