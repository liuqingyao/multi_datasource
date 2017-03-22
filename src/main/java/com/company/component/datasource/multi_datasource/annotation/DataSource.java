package com.company.component.datasource.multi_datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: yaoliuqing
 * Time: 14-9-25 下午5:27
 * 指定操作的数据库
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.METHOD})
public @interface DataSource {

    /**
     * value dataSource的名称
     */
    String value();

}
