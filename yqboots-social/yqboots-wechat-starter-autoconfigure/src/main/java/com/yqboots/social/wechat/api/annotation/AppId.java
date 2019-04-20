package com.yqboots.social.wechat.api.annotation;

import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * AppId
 */
@Retention(RUNTIME)
@Target({FIELD})
@NonNull
@NotEmpty
@Length(max = 32)
public @interface AppId {
}
