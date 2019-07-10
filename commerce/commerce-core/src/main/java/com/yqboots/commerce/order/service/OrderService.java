package com.yqboots.commerce.order.service;

import com.yqboots.commerce.order.entity.Order;

public interface OrderService {
    Order getOrder(String code);

    void markAsPaid(Order order);
}
