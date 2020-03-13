package com.roboslyq.webflux.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 * 1、@Data： lombok注解：生成很多方法，不仅是Getter和setter。很暴力！！！
 * 2、@Accessors： lombok注解：生成链式调用的getter和setter方法
 *
 * @author luo.yongqian
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private Integer age;
    private String email;
    private String name;
    private String nickname;
    private String sex;
    private String password;

    public static void main(String[] args) {
        User user = new User();
        user.setEmail("robosloveu@163.com")
                .setName("luoyq");
    }
}
