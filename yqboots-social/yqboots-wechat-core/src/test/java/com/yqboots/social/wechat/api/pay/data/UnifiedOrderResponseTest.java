package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.AbstractMarshallerTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.xml.transform.StringResult;

public class UnifiedOrderResponseTest extends AbstractMarshallerTest {
    private static final Logger LOG = LoggerFactory.getLogger(UnifiedOrderResponseTest.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
        marshaller.setClassesToBeBound(UnifiedOrderResponse.class);
    }

    @Test
    public void testMarshaller() {
        UnifiedOrderResponse bean = new UnifiedOrderResponse();
        bean.setAppId("1");
        bean.setMchId("2");
        bean.setNonceStr("3");
        bean.setSign("4");
        StringResult sr = new StringResult();
        marshaller.marshal(bean, sr);

        LOG.debug(sr.toString());
    }
}