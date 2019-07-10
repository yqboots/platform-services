package com.yqboots.commerce.order.entity;

import lombok.Getter;

/**
 * 订单不存在异常
 */
public class OrderNotFoundException extends RuntimeException {
    @Getter
    private final String code;
    @Getter
    private final String errorCode;

    public OrderNotFoundException(String code, String errorCode) {
        super(code != null ? code : "");

        this.code = code;
        this.errorCode = errorCode;
    }

    public OrderNotFoundException(String code, String errorCode, String errorMsg) {
        super(errorMsg);

        this.code = code;
        this.errorCode = errorCode;
    }
}
