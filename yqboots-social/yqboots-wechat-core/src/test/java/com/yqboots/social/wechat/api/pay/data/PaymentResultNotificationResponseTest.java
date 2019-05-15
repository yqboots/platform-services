package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.AbstractMarshallerTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.xml.transform.StringResult;

public class PaymentResultNotificationResponseTest extends AbstractMarshallerTest {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentResultNotificationResponseTest.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
        marshaller.setClassesToBeBound(PaymentResultNotificationResponse.class);
    }

    @Test
    public void testMarshaller() {
        PaymentResultNotificationResponse bean = new PaymentResultNotificationResponse();
        StringResult sr = new StringResult();
        marshaller.marshal(bean, sr);

        LOG.debug(sr.toString());
    }
}