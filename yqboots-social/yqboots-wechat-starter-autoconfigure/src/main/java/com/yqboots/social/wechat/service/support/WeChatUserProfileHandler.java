package com.yqboots.social.wechat.service.support;

import com.yqboots.commerce.user.entity.Customer;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.entity.WeChatUserProfile;
import com.yqboots.social.wechat.entity.WeChatUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class WeChatUserProfileHandler {
    private final WeChatUserProfileRepository userProfileRepository;

    @Autowired
    public WeChatUserProfileHandler(WeChatUserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    /**
     * 根据获取的token创建/更新用户信息
     *
     * @param tokenResponse tokenResponse
     * @return wechat user profile with user
     */
    public WeChatUserProfile storeUserProfile(GetAccessTokenResponse tokenResponse) {
        WeChatUserProfile result = userProfileRepository.findByUnionId(tokenResponse.getUnionId());

        return result == null ? createUserProfile(tokenResponse) : updateUserProfile(result, tokenResponse);
    }

    private WeChatUserProfile createUserProfile(GetAccessTokenResponse tokenResponse) {
        WeChatUserProfile result = new WeChatUserProfile();

        result.setUnionId(tokenResponse.getUnionId());
        result.setScope(tokenResponse.getScope());
        result.setAccessToken(tokenResponse.getAccessToken());
        result.setRefreshToken(tokenResponse.getRefreshToken());
        result.setOpenId(tokenResponse.getOpenId());
        // TODO: calculate the expired time
        // profile.setTokenExpiredTime();
        // TODO: create new user or attach to existed user

        return userProfileRepository.save(result);
    }

    private Customer createUser() {
        Customer result = new Customer();
        result.setUsername("");
        result.setPassword("password");

        return result;
    }

    private WeChatUserProfile updateUserProfile(WeChatUserProfile exitedUserProfile, GetAccessTokenResponse tokenResponse) {
        Assert.notNull(exitedUserProfile, "User Profile is required");
        exitedUserProfile.setAccessToken(tokenResponse.getAccessToken());
        exitedUserProfile.setRefreshToken(tokenResponse.getRefreshToken());
        exitedUserProfile.setOpenId(tokenResponse.getOpenId());

        return userProfileRepository.save(exitedUserProfile);
    }
}
