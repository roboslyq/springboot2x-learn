/**
 * Copyright (C), 2015-2020
 * FileName: User
 * Author:   luo.yongqian
 * Date:     2020/3/1 19:14
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/1 19:14      1.0.0               创建
 */
package com.roboslyq.schema.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/1
 * @since 1.0.0
 */

public class UserConfig implements InitializingBean,ApplicationContextInitializer,ApplicationListener {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private int age;
    private String sex;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("applicatoin 事件111");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("initialize 事件111");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet 事件111");

    }
}