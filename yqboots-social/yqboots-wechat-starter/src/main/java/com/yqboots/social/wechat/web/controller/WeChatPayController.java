package com.yqboots.social.wechat.web.controller;

import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationRequest;
import com.yqboots.social.wechat.api.pay.data.PaymentResultNotificationResponse;
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
    @RequestMapping(value = "/payment/notify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE})
    public PaymentResultNotificationResponse notifyPaymentResult(@RequestBody PaymentResultNotificationRequest request) {
        // TODO: return result
        return new PaymentResultNotificationResponse();
    }
}
