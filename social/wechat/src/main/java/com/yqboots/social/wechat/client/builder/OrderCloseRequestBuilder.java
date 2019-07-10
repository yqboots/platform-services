package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.pay.data.OrderCloseRequest;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import com.yqboots.social.wechat.constants.WeChatConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderCloseRequestBuilder extends AbstractRequestBuilder<OrderCloseRequest> {
    public OrderCloseRequestBuilder(@Autowired WeChatProperties properties) {
        super(properties);
    }

    @Override
    protected OrderCloseRequest build(RequestBuilderParameters builderParameters) {
        addParameter(WeChatConstants.FIELD_OUT_TRADE_NO, builderParameters.getOrder().getCode());
        addParameter(WeChatConstants.FIELD_NONCE_STR, getParams().generateNonce());
        addParameter(WeChatConstants.FIELD_SIGN, generateSignature());

        return convertToBean(new OrderCloseRequest());
    }
}
