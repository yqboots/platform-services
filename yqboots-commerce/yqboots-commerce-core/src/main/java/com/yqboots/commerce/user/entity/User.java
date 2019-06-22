package com.yqboots.commerce.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
public class User extends AbstractPersistable<Long> {
    private String username;
    private String password;
    /**
     * 当第三方登录时，设置了默认密码，如果使用了用户名/密码登录了，则需要重置密码
     */
    @Column(name = "INITIAL_USERNAME_CHANGED")
    private boolean initialUsernameChanged = false;
    @Column(name = "INITIAL_PASSWORD_CHANGED")
    private boolean initialPasswordChanged = false;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserProfile> profiles;
}
