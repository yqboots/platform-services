package com.yqboots.commerce.product.entity;

import com.yqboots.commerce.user.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "products")
@AssociationOverrides({
        @AssociationOverride(name = "createdBy", joinColumns = @JoinColumn(name = "CREATED_BY")),
        @AssociationOverride(name = "lastModifiedBy", joinColumns = @JoinColumn(name = "LAST_MODIFIED_BY"))
})
public abstract class AbstractProduct extends AbstractAuditable<User, Long> {
    private String code;
    private String name;
    private String description;
}
