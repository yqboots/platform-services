package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.pay.data.RefundQueryRequest;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import com.yqboots.social.wechat.constants.WeChatConstants;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RefundQueryRequestBuilder extends AbstractRequestBuilder<RefundQueryRequest> {
    public RefundQueryRequestBuilder(WeChatProperties properties) {
        super(properties);
    }

    @Override
    protected RefundQueryRequest build(RequestBuilderParameters builderParameters) {
        addParameter(WeChatConstants.FIELD_TRANSACTION_ID, "");
        addParameter(WeChatConstants.FIELD_OUT_TRADE_NO, builderParameters.getOrder().getCode());
        // TODO: refund no is required
        addParameter(WeChatConstants.FIELD_OUT_REFUND_NO, "");
        addParameter(WeChatConstants.FIELD_REFUND_ID, "");
        addParameter(WeChatConstants.FIELD_OFFSET, "0");
        addParameter(WeChatConstants.FIELD_NONCE_STR, getParams().generateNonce());
        addParameter(WeChatConstants.FIELD_SIGN, generateSignature());

        return convertToBean(new RefundQueryRequest());
    }
}
