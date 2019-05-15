package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.AbstractMarshallerTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.xml.transform.StringResult;

public class OrderQueryResponseTest extends AbstractMarshallerTest {
    private static final Logger LOG = LoggerFactory.getLogger(OrderQueryResponseTest.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
        marshaller.setClassesToBeBound(OrderQueryResponse.class);
    }

    @Test
    public void testMarshaller() {
        OrderQueryResponse bean = new OrderQueryResponse();
        bean.setAppId("1");
        bean.setMchId("2");
        bean.setNonceStr("3");
        bean.setSign("4");
        bean.setOutTradeNo("5");
        bean.setTransactionId("6");
        bean.setCashFee(1);
        bean.setAttach("7");
        bean.setBankType("TYPE");
        bean.setCashFeeType("TYPE1");
        bean.setDeviceInfo("WEB");
        bean.setFeeType("TYPE");

        StringResult sr = new StringResult();
        marshaller.marshal(bean, sr);

        LOG.debug(sr.toString());
    }
}