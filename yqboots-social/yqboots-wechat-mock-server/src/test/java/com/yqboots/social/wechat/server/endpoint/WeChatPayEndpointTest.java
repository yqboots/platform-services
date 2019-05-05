package com.yqboots.social.wechat.server.endpoint;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatPayEndpointTest {
    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @Before
    public void setUp() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    public void queryOrder() {
        Source requestPayload = new StringSource(
                "<xml>" +
                        "<appid>123</appid>" +
                        "<mch_id>321</mch_id>" +
                        "</xml>");
        Source responsePayload = new StringSource(
                "<xml>" +
                        "<appid>123</appid>" +
                        "<mch_id>321</mch_id>" +
                        "<device_info>WEB</device_info>" +
                        "<fee_type>CNY</fee_type>" +
                        "<cash_fee>100</cash_fee>" +
                        "</xml>");

        mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload));
    }
}