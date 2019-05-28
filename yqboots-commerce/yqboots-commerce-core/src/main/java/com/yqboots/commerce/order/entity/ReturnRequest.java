package com.yqboots.commerce.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "return_requests")
public class ReturnRequest extends AbstractPersistable<Long> {
    @Column(nullable = false, unique = true, length = 30)
    private String code;
    @Enumerated(EnumType.STRING)
    private ReturnRequestStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "`ORDER`")
    private Order order;
    @Column(nullable = false, scale = 2)
    private BigDecimal subtotal;
}
