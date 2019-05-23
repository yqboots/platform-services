package com.yqboots.social.wechat.web.controller;

import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationResponse;
import com.yqboots.social.wechat.service.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信支付REST API
 */
@RestController
@RequestMapping(value = "/wechat/pay")
public class WeChatPayController {
    private WeChatPayService weChatPayService;

    @RequestMapping(value = "/payment/notify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE})
    public PaymentResultNotificationResponse notifyPaymentResult(@RequestBody PaymentResultNotificationRequest request) {
        // TODO: do validation，验证报文的有效性，比如签名等数据是否一致等。
        return weChatPayService.notifyPayment(request);
    }

    @Autowired
    public void setWeChatPayService(WeChatPayService weChatPayService) {
        this.weChatPayService = weChatPayService;
    }
}
