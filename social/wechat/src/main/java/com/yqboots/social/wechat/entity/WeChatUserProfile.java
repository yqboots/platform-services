package com.yqboots.social.wechat.entity;

import com.yqboots.commerce.user.entity.UserProfile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("WECHAT")
public class WeChatUserProfile extends UserProfile {
    @Column(name = "ACCESS_TOKEN")
    private String accessToken;
    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;
    @Column(name = "TOKEN_EXPIRED_TIME")
    private LocalDateTime tokenExpiredTime;
    @Column(name = "OPEN_ID")
    private String openId;
    @Column(name = "SCOPE")
    private String scope;
    @Column(name = "UNION_ID", unique = true)
    private String unionId;
}
