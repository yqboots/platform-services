package com.yqboots.social.wechat.client.builder;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.social.wechat.WeChatProperties;
import com.yqboots.social.wechat.api.pay.FeeType;
import com.yqboots.social.wechat.api.pay.SignType;
import com.yqboots.social.wechat.api.pay.data.RefundRequest;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import com.yqboots.social.wechat.constants.WeChatConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RefundRequestBuilder extends AbstractRequestBuilder<RefundRequest> {
    public RefundRequestBuilder(@Autowired WeChatProperties properties) {
        super(properties);
    }

    @Override
    protected RefundRequest build(RequestBuilderParameters builderParameters) {
        Order order = builderParameters.getOrder();
        addParameter(WeChatConstants.FIELD_NONCE_STR, getParams().generateNonce());
        addParameter(WeChatConstants.FIELD_SIGN_TYPE, SignType.MD5.getCode());
        addParameter(WeChatConstants.FIELD_TRANSACTION_ID, "");
        addParameter(WeChatConstants.FIELD_OUT_TRADE_NO, order.getCode());
        // TODO: refund no is required
        addParameter(WeChatConstants.FIELD_OUT_REFUND_NO, "");
        if (getProperties().getTestMode()) {
            addParameter(WeChatConstants.FIELD_TOTAL_FEE, "1");
            addParameter(WeChatConstants.FIELD_REFUND_FEE, "1");
        } else {
            addParameter(WeChatConstants.FIELD_TOTAL_FEE, String.valueOf(order.getTotalPrice() * 100));
            // TODO: refund fee
            addParameter(WeChatConstants.FIELD_REFUND_FEE, "0");
        }
        addParameter(WeChatConstants.FIELD_FEE_TYPE, FeeType.CNY.name());
        addParameter(WeChatConstants.FIELD_REFUND_DESC, "");
        addParameter(WeChatConstants.FIELD_REFUND_ACCOUNT, "");
        addParameter(WeChatConstants.FIELD_NOTIFY_URL, getProperties().getPay().getRefundNotifyUrl());
        addParameter(WeChatConstants.FIELD_SIGN, generateSignature());

        return convertToBean(new RefundRequest());
    }
}
