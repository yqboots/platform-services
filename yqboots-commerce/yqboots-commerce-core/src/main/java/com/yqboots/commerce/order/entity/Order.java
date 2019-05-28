package com.yqboots.commerce.order.entity;

import com.yqboots.commerce.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@DiscriminatorColumn(name = "TYPE")
@AssociationOverrides({
        @AssociationOverride(name = "createdBy", joinColumns = @JoinColumn(name = "CREATED_BY")),
        @AssociationOverride(name = "lastModifiedBy", joinColumns = @JoinColumn(name = "LAST_MODIFIED_BY"))
})
public class Order extends AbstractAuditable<User, Long> {
    @Column(nullable = false, unique = true, length = 30)
    private String code;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderEntry> entries;
    private Double totalPrice;
}
