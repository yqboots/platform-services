package com.yqboots.social.wechat.api.pay.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

/**
 * 微信支付结果通知返回报文
 */
@Data
@NoArgsConstructor
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentResultNotificationResponse implements Serializable {
    private PaymentResultNotificationResponse(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    /**
     * 返回状态码
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = FIELD_RETURN_CODE)
    private String returnCode;

    /**
     * 返回信息
     */
    @NonNull
    @NotEmpty
    @Length(max = 128)
    @XmlElement(name = FIELD_RETURN_MSG)
    private String returnMsg;

    public static PaymentResultNotificationResponse successResponse() {
        return new PaymentResultNotificationResponse(RETURN_CODE_SUCCESS, RETURN_MSG_OK);
    }

    public static PaymentResultNotificationResponse failResponse() {
        return null;
    }
}
