package com.yqboots.social.wechat.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeChatUserProfileRepository extends JpaRepository<WeChatUserProfile, Long> {
    WeChatUserProfile findByUnionId(String unionId);
}
