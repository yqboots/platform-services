package com.yqboots.commerce.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user_profiles")
public class UserProfile extends AbstractPersistable<Long> {
    @ManyToOne(optional = false)
    @JoinColumn(name = "OWNER")
    private User owner;
}
