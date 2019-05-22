package com.yqboots.commerce.order.entity;

import com.yqboots.commerce.product.entity.AbstractProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "order_entries")
public class OrderEntry extends AbstractPersistable<Long> {
    @ManyToOne(optional = false)
    @JoinColumn(name = "`ORDER`")
    private Order order;
    private Integer entryNumber;
    private Double basePrice;
    private Long quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT")
    private AbstractProduct product;
}
