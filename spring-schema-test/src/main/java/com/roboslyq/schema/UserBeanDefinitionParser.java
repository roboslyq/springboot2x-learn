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

import com.roboslyq.schema.bean.UserConfig;
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
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class getBeanClass(Element element) {
        return UserConfig.class;
    }
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {

        // this however is an optional property
        String age = element.getAttribute("age");
        if (StringUtils.hasText(age)) {
            bean.addPropertyValue("age", Integer.valueOf(age));
        }
    }

}