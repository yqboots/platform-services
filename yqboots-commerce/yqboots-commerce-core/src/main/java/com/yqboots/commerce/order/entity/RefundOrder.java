package com.yqboots.commerce.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 退款单
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("REFUND")
public class RefundOrder extends Order {
    @Enumerated(EnumType.STRING)
    private ReturnFulfillmentStatus fulfillmentStatus;
    private String notes;
}
