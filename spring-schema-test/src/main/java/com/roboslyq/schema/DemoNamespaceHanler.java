/**
 * Copyright (C), 2015-2020
 * FileName: DemoNamespaceHanler
 * Author:   luo.yongqian
 * Date:     2020/3/1 19:22
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/1 19:22      1.0.0               创建
 */
package com.roboslyq.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/1
 * @since 1.0.0
 */
public class DemoNamespaceHanler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("dateformat", new SimpleDateFormatBeanDefinitionParser());
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}