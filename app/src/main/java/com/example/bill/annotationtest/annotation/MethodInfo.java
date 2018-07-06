package com.example.bill.annotationtest.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Bill on 2018/5/17.
 */


/**
 * @Documented 是否会保存到 Javadoc 文档中
 */

/**
 * @Target
 * ANONOTATION_TYPE(注解类型声明），
 * PACKAGE（包）
 * TYPE （类，包括enum及接口，注解类型）
 * METHOD （方法）
 * CONSTRUCTOR （构造方法）
 * FIFLD （成员变量）
 * PARAMATER （参数）
 * LOCAL_VARIABLE （局部 变量）
 */

/**
 * @Retention
 * SOURCE（源码时），CLASS（编译时），RUNTIME（运行时）
 */

/**
 * @Inherited 是否可以被继承，默认为 false
 */

@Documented
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodInfo {
    /**
     * 定义注解MethodInfo
     * 注解目标为类、构造方法、属性、方法
     * 注解中有三个元素id、name、gid
     */
    int id() default 0;
    String name() default "Bill";
    Class gid();
}
