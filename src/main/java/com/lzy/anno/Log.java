package com.lzy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义Log注解
 */

@Retention(RetentionPolicy.RUNTIME)//什么时候运行-->程序运行时运行
@Target(ElementType.METHOD)//在哪里运行-->方法
public @interface Log {
}
