package com.yqboots.social.wechat.config;

import com.yqboots.commerce.order.entity.Order;
import com.yqboots.commerce.order.entity.OrderEntry;
import com.yqboots.commerce.order.entity.OrderRepository;
import com.yqboots.commerce.order.entity.OrderStatus;
import com.yqboots.commerce.product.entity.Product;
import com.yqboots.commerce.product.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WeChatOrderConfiguration {
    @Configuration
    @Profile(value = {"integration-test"})
    public static class H2InitialDataConfiguration {
        @Autowired
        private ProductRepository productRepository;
        @Autowired
        private OrderRepository orderRepository;

        @PostConstruct
        public void init() throws Exception {
            Product product = new Product();
            product.setCode("P00000001");
            product.setName("测试产品");
            productRepository.save(product);

            Order order = new Order();
            order.setStatus(OrderStatus.PENDING_PAYMENT);
            order.setCode("D00000002");
            order.setTotalPrice(100D);

            List<OrderEntry> entries = new ArrayList<>();
            OrderEntry orderEntry = new OrderEntry();
            orderEntry.setEntryNumber(1);
            orderEntry.setBasePrice(100D);
            orderEntry.setQuantity(1L);
            orderEntry.setProduct(product);
            orderEntry.setOrder(order);
            entries.add(orderEntry);
            order.setEntries(entries);

            orderRepository.save(order);
        }
    }
}
