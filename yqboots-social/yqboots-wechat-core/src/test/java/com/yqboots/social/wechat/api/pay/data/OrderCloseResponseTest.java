package com.yqboots.social.wechat.api.pay.data;

import com.yqboots.social.wechat.api.AbstractMarshallerTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.xml.transform.StringResult;

public class OrderCloseResponseTest extends AbstractMarshallerTest {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCloseResponseTest.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
        marshaller.setClassesToBeBound(OrderCloseResponse.class);
    }

    @Test
    public void testMarshaller() {
        OrderCloseResponse bean = new OrderCloseResponse();
        bean.setAppId("1");
        bean.setMchId("2");
        bean.setNonceStr("3");
        bean.setSign("4");
        bean.setReturnCode("SUCCESS");
        bean.setResultMsg("SUCCESS");
        bean.setReturnMsg("SUCCESS");
        bean.setErrCode("ERROR");
        bean.setResultCode("SUCCESS");
        bean.setErrCodeDes("DESC");
        StringResult sr = new StringResult();
        marshaller.marshal(bean, sr);

        LOG.debug(sr.toString());
    }
}