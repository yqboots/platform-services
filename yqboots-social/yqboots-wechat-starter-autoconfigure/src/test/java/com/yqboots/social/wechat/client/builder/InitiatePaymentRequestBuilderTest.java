package com.yqboots.social.wechat.client.builder;

import com.yqboots.social.wechat.WeChatApplication;
import com.yqboots.social.wechat.api.pay.data.InitiatePaymentRequest;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {WeChatApplication.class})
public class InitiatePaymentRequestBuilderTest {
    private static final Logger LOG = LoggerFactory.getLogger(InitiatePaymentRequestBuilderTest.class);

    @Autowired
    private InitiatePaymentRequestBuilder builder;

    @Test
    public void build() {
        InitiatePaymentRequest request = builder.build(new RequestBuilderParameters()
                .setPrepayId("prepayID001"));

        LOG.info(ToStringBuilder.reflectionToString(request, ToStringStyle.JSON_STYLE));
    }
}
