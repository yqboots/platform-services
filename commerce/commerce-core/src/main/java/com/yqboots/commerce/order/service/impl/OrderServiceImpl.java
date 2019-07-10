package com.yqboots.commerce.order.service.impl;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.commerce.order.entity.OrderNotFoundException;
import com.yqboots.commerce.order.entity.OrderRepository;
import com.yqboots.commerce.order.entity.OrderStatus;
import com.yqboots.commerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public Order getOrder(String code) {
        Optional<Order> result = orderRepository.findByCode(code);
        if (result.isPresent()) {
            return result.get();
        }

        throw new OrderNotFoundException(code, "Order.NotFound");
    }

    @Override
    @Transactional
    public void markAsPaid(Order order) {
        Assert.notNull(order, "order is required");
        order.setStatus(OrderStatus.PENDING_DELIVERY);

        orderRepository.save(order);
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
