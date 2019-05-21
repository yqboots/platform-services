package com.yqboots.social.wechat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * WeChat properties
 *
 * @author Eric H B Zhan
 * @version 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "yqboots.social.wechat")
public class WeChatProperties {
    /**
     * 服务号的应用ID
     */
    private String appId;
    /**
     * 服务号的应用密钥
     */
    private String appSecret;
    /**
     * 商户号
     */
    private String partnerId;
    /**
     * 商户号 API密钥
     */
    private String partnerKey;
    /**
     * 服务号的配置token
     */
    private String token;
    /**
     * 是否处于测试环境
     */
    private Boolean testMode;
    /**
     * 支付属性
     */
    private PayProperties pay;
    private AuthProperties auth;

    @Data
    public static class PayProperties {
        /**
         * 微信支付证书名称
         */
        private String certPath;
        /**
         * 统一下单
         */
        private String unifiedOrderUrl;
        /**
         * 支付结果通知
         */
        private String payNotifyUrl;
        /**
         * 查询订单
         */
        private String orderQueryUrl;
        /**
         * 关闭订单
         */
        private String orderCloseUrl;
        /**
         * 申请退款
         */
        private String refundUrl;
        /**
         * 退款结果通知
         */
        private String refundNotifyUrl;
        /**
         * 查询退款
         */
        private String refundQueryUrl;
        /**
         * 下载对账单
         */
        private String downloadBillUrl;
        /**
         * 下载资金账单
         */
        private String downloadFundFlowUrl;
        /**
         * 交易保障
         */
        private String reportUrl;
        /**
         * 拉取订单评价数据
         */
        private String batchQueryCommentUrl;
    }

    @Data
    public static class AuthProperties {
        private String accessTokenUrl;
    }
}
