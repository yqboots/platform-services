package com.yqboots.commerce.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sequences")
public class Sequence extends AbstractPersistable<Long> {
    @Column(name = "CURRENT_VALUE", nullable = false)
    private String currentValue;
    @Column(name = "TYPE", unique = true, nullable = false, length = 64)
    private String type;
}
