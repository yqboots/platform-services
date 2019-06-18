package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.api.auth.data.GetUserInfoRequest;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GetUserInfoRequestBuilder {
    /**
     * 获取当前用户的accessToken和openid
     *
     * @return request
     */
    public GetUserInfoRequest build() {
        GetUserInfoRequest result = new GetUserInfoRequest();
        result.setAccessToken("");
        result.setOpenId("");
        result.setLanguage("zh_CN");

        return result;
    }
}
