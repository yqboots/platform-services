package com.yqboots.social.wechat.service.support;

import com.yqboots.commerce.core.id.KeyGenerator;
import com.yqboots.commerce.user.entity.Customer;
import com.yqboots.commerce.user.entity.CustomerRepository;
import com.yqboots.social.wechat.api.auth.data.GetAccessTokenResponse;
import com.yqboots.social.wechat.entity.WeChatUserProfile;
import com.yqboots.social.wechat.entity.WeChatUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

import static com.yqboots.social.wechat.WeChatBeans.WECHAT_CUSTOMER_NAME_KEY_GENERATOR;

@Service
public class WeChatUserProfileHandler {
    private final KeyGenerator keyGenerator;
    private final CustomerRepository customerRepository;
    private final WeChatUserProfileRepository userProfileRepository;

    @Autowired
    public WeChatUserProfileHandler(@Qualifier(value = WECHAT_CUSTOMER_NAME_KEY_GENERATOR) final KeyGenerator keyGenerator,
                                    final CustomerRepository customerRepository,
                                    final WeChatUserProfileRepository userProfileRepository) {
        this.keyGenerator = keyGenerator;
        this.customerRepository = customerRepository;
        this.userProfileRepository = userProfileRepository;
    }

    /**
     * 根据获取的token创建/更新用户信息
     *
     * @param tokenResponse tokenResponse
     * @return wechat user profile with user
     */
    @Transactional
    public WeChatUserProfile storeUserProfile(GetAccessTokenResponse tokenResponse) {
        WeChatUserProfile result = userProfileRepository.findByUnionId(tokenResponse.getUnionId());

        return result == null ? createUserProfile(tokenResponse) : updateUserProfile(result, tokenResponse);
    }

    private WeChatUserProfile createUserProfile(GetAccessTokenResponse tokenResponse) {
        Customer customer = createCustomerRandomly();
        customer = customerRepository.save(customer);

        WeChatUserProfile result = new WeChatUserProfile();

        result.setUnionId(tokenResponse.getUnionId());
        result.setScope(tokenResponse.getScope());
        result.setAccessToken(tokenResponse.getAccessToken());
        result.setRefreshToken(tokenResponse.getRefreshToken());
        result.setOpenId(tokenResponse.getOpenId());
        // calculate the expired time
        result.setTokenExpiredTime(LocalDateTime.now().plusSeconds(Long.parseLong(tokenResponse.getExpiresIn())));
        // attach to auto created user
        result.setOwner(customer);

        return userProfileRepository.save(result);
    }

    private Customer createCustomerRandomly() {
        Customer result = new Customer();
        result.setUsername((String) keyGenerator.generate());
        result.setPassword("");
        result.setInitialPasswordChanged(false);
        result.setInitialUsernameChanged(false);

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
