package com.bestwu.aspect.annotation;

import java.lang.annotation.*;

/**
 * <br>
 *
 * @author Best Wu
 * @date 2020/7/14 20:17 <br>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Encrypt {

    String value() default "base64";

}
