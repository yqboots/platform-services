package com.yqboots.commerce.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 换货单
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("REPLACEMENT")
public class ReplacementOrder extends Order {
    @Enumerated(EnumType.STRING)
    private ReturnFulfillmentStatus fulfillmentStatus;
    private String notes;
}
