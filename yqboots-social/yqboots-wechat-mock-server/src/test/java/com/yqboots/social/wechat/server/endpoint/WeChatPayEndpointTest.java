package com.yqboots.social.wechat.server.endpoint;

import com.yqboots.social.wechat.api.pay.data.OrderQueryRequest;
import com.yqboots.social.wechat.api.pay.data.OrderQueryResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class WeChatPayEndpointTest {
    private WebServiceTemplate webServiceTemplate;

    @Before
    public void setUp() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(OrderQueryRequest.class, OrderQueryResponse.class);
        webServiceTemplate = new WebServiceTemplate(marshaller);
    }

    @Test
    public void queryOrder() {
        OrderQueryResponse response = (OrderQueryResponse) webServiceTemplate.marshalSendAndReceive(
                "http://localhost:8090/ws/weChatPayService/wechat-order-query.wsdl",
                new OrderQueryRequest()
        );

        System.out.println(response.toString());
    }
}