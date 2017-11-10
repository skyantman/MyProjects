package com.yundongjia.oa.system;

import java.lang.annotation.*;

/**
 * Created by ltlxy on 2016/9/18.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authority {

    String[] value() default {};

}
