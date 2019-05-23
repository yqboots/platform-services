package com.yqboots.social.wechat.api.pay.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;
import static com.yqboots.social.wechat.constants.WeChatConstants.FIELD_RETURN_MSG;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = FIELD_ROOT_ELEMENT)
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderCloseResponse extends AbstractWeChatPayResponseData {
    /**
     * 返回状态码 - SUCCESS/FAIL
     */
    @NonNull
    @NotEmpty
    @Length(max = 16)
    @XmlElement(name = FIELD_RETURN_CODE)
    private String returnCode;
    /**
     * 返回信息
     */
    @Length(max = 128)
    @XmlElement(name = FIELD_RETURN_MSG)
    private String returnMsg;
    /**
     * 业务结果描述
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_RESULT_MSG)
    private String resultMsg;
}
