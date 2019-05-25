package com.yqboots.social.wechat.client.builder.support;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.social.wechat.api.pay.TradeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RequestBuilderParameters implements Serializable {
    private Order order;
    private String clientIP;
    private TradeType tradeType;
    private String prepayId;
}
