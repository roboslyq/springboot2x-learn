package com.roboslyq.webflux.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户实体对应表 user
 */
//lombok注解：生成很多方法，不仅是Getter和setter。很暴力！！！
@Data
//lombok注解：生成链式调用的getter和setter方法
@Accessors(chain = true)
public class User {
    private Long id;
    private Integer age;
    private String email;
    private String name;
    private String nickname;
    private String sex;
    private String password;
}
