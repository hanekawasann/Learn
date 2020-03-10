package com.yukms.learn.apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/23 16:32
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.TYPE})
public @interface Name {
    String value();
}
