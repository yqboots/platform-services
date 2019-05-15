package com.yqboots.social.wechat.api.pay.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import static com.yqboots.social.wechat.constants.WeChatConstants.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractWeChatPayResponseData extends AbstractWeChatPayData {
    /**
     * 业务结果 - SUCCESS/FAIL
     */
    @Length(max = 16)
    @XmlElement(name = FIELD_RESULT_CODE)
    private String resultCode;
    /**
     * 错误代码
     */
    @Length(max = 32)
    @XmlElement(name = FIELD_ERROR_CODE)
    private String errCode;
    /**
     * 错误代码描述
     */
    @Length(max = 128)
    @XmlElement(name = FIELD_ERROR_CODE_DESCRIPTION)
    private String errCodeDes;
}
