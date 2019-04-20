package com.yqboots.social.wechat.api.pay.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yqboots.social.wechat.WeChatConstants;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * <h3><a href="https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_12&index=2">调起支付接口</a></h3>
 * <p>APP端调起支付的参数列表</p>
 * <ul>返回结果
 * <li>0 - 成功 - 展示成功页面</li>
 * <li>-1 - 错误 - 可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。</li>
 * <li>-2 - 用户取消 - 无需处理。发生场景：用户不支付了，点击取消，返回APP。</li>
 * </ul>
 */
@Data
public class InitiatePaymentRequest {
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @JsonProperty("appid")
    private String appId;
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @JsonProperty("partnerid")
    private String partnerId;
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @JsonProperty("prepayid")
    private String prepayId;
    @NonNull
    @NotEmpty
    @Length(max = 128)
    @JsonProperty("package")
    private String pkg = WeChatConstants.PACKAGE;
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @JsonProperty("noncestr")
    private String nonceStr;
    @NonNull
    @NotEmpty
    @Length(max = 10)
    @JsonProperty("timestamp")
    private String timestamp;
    @NonNull
    @NotEmpty
    @Length(max = 32)
    @JsonProperty("sign")
    private String sign;
}
