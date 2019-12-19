package com.imooc.demo.myinterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author CBeann
 * @create 2019-12-18 22:23
 */
//Async注解
@Target(ElementType.METHOD)//方法注解
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface MyAsyncInterface {
}
