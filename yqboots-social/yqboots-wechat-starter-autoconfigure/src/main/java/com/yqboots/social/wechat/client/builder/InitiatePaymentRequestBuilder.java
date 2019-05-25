package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.pay.data.InitiatePaymentRequest;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import com.yqboots.social.wechat.constants.WeChatConstants;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InitiatePaymentRequestBuilder extends AbstractRequestBuilder<InitiatePaymentRequest> {
    public InitiatePaymentRequestBuilder(@Autowired WeChatProperties properties) {
        super(properties);
    }

    @Override
    public InitiatePaymentRequest build(RequestBuilderParameters builderParameters) {
        removeParameter(WeChatConstants.FIELD_MERCHANT_ID);
        addParameter(WeChatConstants.FIELD_PARTNER_ID, getProperties().getPartnerId());
        addParameter(WeChatConstants.FIELD_PREPAYID, builderParameters.getPrepayId());
        addParameter(WeChatConstants.FIELD_PACKAGE, WeChatConstants.PACKAGE);
        addParameter(WeChatConstants.FIELD_NONCE_STR, getParams().generateNonce());
        addParameter(WeChatConstants.FIELD_TIMESTAMP, String.valueOf(System.currentTimeMillis() / DateUtils.MILLIS_PER_SECOND));
        addParameter(WeChatConstants.FIELD_SIGN, generateSignature());

        return convertToBean(new InitiatePaymentRequest());
    }
}
