package com.yqboots.social.wechat.server.web.controller;

import com.yqboots.social.wechat.api.pay.data.OrderQueryRequest;
import com.yqboots.social.wechat.api.pay.data.OrderQueryResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeChatPayControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    private Jaxb2Marshaller marshaller;

    @Before
    public void setUp() {
        marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(OrderQueryRequest.class, OrderQueryResponse.class);
    }

    @Test
    public void queryOrder() throws Exception {
        OrderQueryRequest requestObj = new OrderQueryRequest();
        requestObj.setAppId("123");
        requestObj.setMchId("321");

        final String baseUrl = "http://localhost:" + randomServerPort + "/pay/orderquery";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.set("Content-Type", MediaType.APPLICATION_XML_VALUE);

        StringResult requestStr = new StringResult();
        marshaller.marshal(requestObj, requestStr);

        HttpEntity<String> request = new HttpEntity<>(requestStr.toString(), headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                uri,
                request,
                String.class
        );
        OrderQueryResponse result = (OrderQueryResponse) marshaller.unmarshal(new StringSource(response.getBody()));
        System.out.println(result);
    }
}