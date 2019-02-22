package com.ggblog.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明注解的保留期限
@Retention(RetentionPolicy.RUNTIME)
//声明可以使用该注解的目标类型
@Target(ElementType.METHOD)
public @interface Log {
	String value() default "";
}
