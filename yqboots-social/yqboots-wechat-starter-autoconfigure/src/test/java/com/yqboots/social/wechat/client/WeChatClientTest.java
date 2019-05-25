package com.yqboots.social.wechat.client;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.commerce.order.entity.OrderEntry;
import com.yqboots.commerce.product.entity.Product;
import com.yqboots.social.wechat.WeChatApplication;
import com.yqboots.social.wechat.api.pay.TradeType;
import com.yqboots.social.wechat.api.pay.data.UnifiedOrderRequest;
import com.yqboots.social.wechat.api.pay.data.UnifiedOrderResponse;
import com.yqboots.social.wechat.builder.UnifiedOrderRequestBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {WeChatApplication.class})
public class WeChatClientTest {
    private static final Logger LOG = LoggerFactory.getLogger(WeChatClientTest.class);

    @Autowired
    private WeChatClient weChatClient;

    @Autowired
    private ApplicationContext applicationContext;

    private transient Order order;

    @Before
    public void setUp() throws Exception {
        order = new Order();
        order.setCode("D00000001");

        OrderEntry entry = new OrderEntry();

        Product product = new Product();
        product.setName("Product Name");
        entry.setProduct(product);

        order.setEntries(Collections.singletonList(entry));
    }

    @Test
    public void unifiedOrder() {
        UnifiedOrderRequestBuilder builder = applicationContext.getBean(UnifiedOrderRequestBuilder.class);
        UnifiedOrderRequest request = builder.build(order, "0.0.0.0", TradeType.APP);

        UnifiedOrderResponse response = weChatClient.unifiedOrder(request);

        LOG.debug(ToStringBuilder.reflectionToString(response, ToStringStyle.JSON_STYLE));
    }
}
