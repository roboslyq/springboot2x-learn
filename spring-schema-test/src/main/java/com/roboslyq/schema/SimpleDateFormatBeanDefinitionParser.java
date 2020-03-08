/**
 * Copyright (C), 2015-2020
 * FileName: SimpleDateFormatBeanDefinitionParser
 * Author:   luo.yongqian
 * Date:     2020/3/1 23:23
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/1 23:23      1.0.0               创建
 */
package com.roboslyq.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import java.text.SimpleDateFormat;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/1
 * @since 1.0.0
 */
public class SimpleDateFormatBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class getBeanClass(Element element) {
        return SimpleDateFormat.class;
    }
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        // this will never be null since the schema explicitly requires that a value be supplied
        String pattern = element.getAttribute("pattern");
        bean.addConstructorArgValue(pattern);

        // this however is an optional property
        String lenient = element.getAttribute("lenient");
        if (StringUtils.hasText(lenient)) {
            bean.addPropertyValue("lenient", Boolean.valueOf(lenient));
        }
        // this however is an optional property
        String age = element.getAttribute("age");
        if (StringUtils.hasText(age)) {
            bean.addPropertyValue("age", Integer.valueOf(age));
        }
    }

}