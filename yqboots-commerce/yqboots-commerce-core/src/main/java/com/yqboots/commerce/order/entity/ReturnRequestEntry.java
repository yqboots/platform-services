package com.yqboots.commerce.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RETURN_REQUEST_ENTRIES")
public class ReturnRequestEntry extends AbstractPersistable<Long> {
    @ManyToOne(optional = false)
    @JoinColumn(name = "RETURN_REQUEST", nullable = false)
    private ReturnRequest returnRequest;

    @OneToOne(optional = false)
    @JoinColumn(name = "ORDER_ENTRY", nullable = false)
    private OrderEntry orderEntry;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReturnRequestStatus status;

    @Column(name = "EXPECTED_QUANTITY", nullable = false)
    private Long expectedQuantity;

    @Column(name = "RECEIVED_QUANTITY")
    private Long receivedQuantity;

    @Column(name = "RECEIVED_DATE")
    private LocalDateTime receivedDate;

    @Column(name = "NOTES")
    private String notes;
}
