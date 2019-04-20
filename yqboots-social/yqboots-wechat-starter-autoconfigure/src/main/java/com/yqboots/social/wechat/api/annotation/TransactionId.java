package com.yqboots.social.wechat.api.annotation;

import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 交易ID
 */
@Retention(RUNTIME)
@Target({FIELD})
@NonNull
@NotEmpty
@Length(max = 32)
public @interface TransactionId {
}
