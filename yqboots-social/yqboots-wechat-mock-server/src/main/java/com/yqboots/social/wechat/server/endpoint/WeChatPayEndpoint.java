package com.yqboots.social.wechat.server.endpoint;

import com.yqboots.social.wechat.api.pay.data.OrderQueryRequest;
import com.yqboots.social.wechat.api.pay.data.OrderQueryResponse;
import com.yqboots.social.wechat.server.service.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        produces = {MediaType.APPLICATION_XML_VALUE},
        consumes = {MediaType.APPLICATION_XML_VALUE}
)
public class WeChatPayEndpoint {
    private WeChatPayService weChatPayService;

    @RequestMapping(value = "/pay/orderquery", method = RequestMethod.POST)
    public OrderQueryResponse queryOrder(@RequestBody OrderQueryRequest request) {
        return weChatPayService.queryOrder(request);
    }

    @Autowired
    public void setWeChatPayService(WeChatPayService weChatPayService) {
        this.weChatPayService = weChatPayService;
    }
}
