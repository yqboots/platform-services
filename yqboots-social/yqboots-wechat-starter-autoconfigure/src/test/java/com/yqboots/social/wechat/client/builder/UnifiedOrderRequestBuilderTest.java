package com.yqboots.social.wechat.client.builder;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.commerce.order.entity.OrderEntry;
import com.yqboots.commerce.product.entity.Product;
import com.yqboots.social.wechat.WeChatApplication;
import com.yqboots.social.wechat.api.pay.TradeType;
import com.yqboots.social.wechat.api.pay.data.UnifiedOrderRequest;
import com.yqboots.social.wechat.client.builder.support.RequestBuilderParameters;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {WeChatApplication.class})
public class UnifiedOrderRequestBuilderTest {
    private static final Logger LOG = LoggerFactory.getLogger(UnifiedOrderRequestBuilderTest.class);

    @Autowired
    private UnifiedOrderRequestBuilder builder;

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
    public void build() {
        UnifiedOrderRequest request = builder.build(new RequestBuilderParameters()
                .setOrder(order)
                .setClientIP("0.0.0.0")
                .setTradeType(TradeType.APP)
        );

        LOG.info(ToStringBuilder.reflectionToString(request, ToStringStyle.JSON_STYLE));
    }
}
