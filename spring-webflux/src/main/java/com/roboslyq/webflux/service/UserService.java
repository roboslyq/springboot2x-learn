/**
 * Copyright (C), 2015-2020
 * FileName: UserService
 * Author:   luo.yongqian
 * Date:     2020/3/12 18:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * luo.yongqian         2020/3/1218:31      1.0.0               创建
 */
package com.roboslyq.webflux.service;

import com.roboslyq.webflux.entity.User;
import reactor.core.publisher.Mono;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @create 2020/3/12
 * @since 1.0.0
 */
public interface UserService {

    Mono<User> createUser(Mono<User> userMono);

    Mono<User> deleteUser(String id);

    Mono<User> updateUser(Mono<User> userMono);

    Mono<User> queryUser(String id);

}