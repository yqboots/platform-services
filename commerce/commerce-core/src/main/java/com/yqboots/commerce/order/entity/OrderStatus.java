package com.yqboots.commerce.order.entity;

/**
 * 订单状态
 */
public enum OrderStatus {
    /**
     * 待付款
     */
    PENDING_PAYMENT,
    /**
     * 待发货
     */
    PENDING_DELIVERY,
    /**
     * 待收货
     */
    PENDING_RECEIVED,
    /**
     * 已完成
     */
    COMPLETED,
    /**
     * 已取消
     */
    CANCELLED
}
