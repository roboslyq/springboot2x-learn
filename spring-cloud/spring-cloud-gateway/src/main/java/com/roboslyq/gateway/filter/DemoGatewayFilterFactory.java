/**
 * Copyright (C), 2015-2020
 * FileName: GatewayFilterFactoryDemo
 * Author:   luo.yongqian
 * Date:     2020/3/20 15:08
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/20 15:08      1.0.0               创建
 */
package com.roboslyq.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 *
 * 〈 1、类名必须为xxxGatewayFilterFactory，例如DemoGatewayFilterFactory
 *    2、必须定义一个自己的配置类(DemoConfig)，此类作为AbstractGatewayFilterFactory<T>的具体类型：AbstractGatewayFilterFactory<DemoGatewayFilterFactory.DemoConfig>
 *    3、必须有一个构造函数，构造函数必须调用父类的构造函数，传参为自定义的配置类： super(DemoGatewayFilterFactory.DemoConfig.class);
 *    4、在application.yml或者properties文件中使用时，filter的name属性即为"xxx"，就是DemoGatewayFilterFactory中的“Demo”
 *    5、示例配置如下：
 *      spring:
 *       cloud:
 *         gateway:
 *           enabled: true
 *           discovery:
 *             locator:
 *               lowerCaseServiceId: true
 *               enabled: true
 *           routes:
 *             # routes: =====================================
 *             - id: user-channel
 *               uri: http://127.0.0.1:8081
 *               order: 8000
 *               predicates:
 *               - Path=/user/**
 *               filters:
 *               - name: Demo
 *                 args:
 *                   id: 2
 *                   val: 2
 *             - id: g
 *               uri: https://github.com/roboslyq/
 *               order: 8000
 *               predicates:
 *               - Path=/g/**
 *               filters:
 *               - name: Demo
 *                 args:
 *                   id: 1
 *                   val: 1
 *
 *   〉
 * @author luo.yongqian
 * @date 2020/3/20
 * @since 1.0.0
 */
@Component
public class DemoGatewayFilterFactory extends AbstractGatewayFilterFactory<DemoGatewayFilterFactory.DemoConfig> {
    /**
     * 构造函数，必须调用父类的构造函数，传入Config的相关类型
     */
    public DemoGatewayFilterFactory() {
        super(DemoGatewayFilterFactory.DemoConfig.class);
    }

    /**
     * 返回具体的filter，可以是匿名类，也可以是new一个已经存在filter
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(DemoConfig config) {
        System.out.println("config的值: "+ config.getId() + ":" + config.val);
        return new GatewayFilterDemo();
    }

    /**
     * 配置文件
     */
    @Validated
    public static class DemoConfig{
        String id;
        String val;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }
}