package com.bestwu.aspect.annotation;

import java.lang.annotation.*;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:18 <br>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Decrypt {

    String value() default "base64";
}
