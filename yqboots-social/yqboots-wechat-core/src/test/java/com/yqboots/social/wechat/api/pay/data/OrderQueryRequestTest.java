package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.AbstractMarshallerTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.xml.transform.StringResult;

public class OrderQueryRequestTest extends AbstractMarshallerTest {
    private static final Logger LOG = LoggerFactory.getLogger(OrderQueryRequestTest.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
        marshaller.setClassesToBeBound(OrderQueryRequest.class);
    }

    @Test
    public void testMarshaller() {
        OrderQueryRequest bean = new OrderQueryRequest();
        bean.setAppId("1");
        bean.setMchId("2");
        bean.setNonceStr("3");
        bean.setSign("4");
        bean.setOutTradeNo("5");
        bean.setTransactionId("6");

        StringResult sr = new StringResult();
        marshaller.marshal(bean, sr);

        LOG.debug(sr.toString());
    }
}