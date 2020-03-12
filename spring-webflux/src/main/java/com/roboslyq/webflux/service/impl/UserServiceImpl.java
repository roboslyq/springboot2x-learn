/**
 * Copyright (C), 2015-2020
 * FileName: UserServiceImpl
 * Author:   luo.yongqian
 * Date:     2020/3/12 18:32
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/12 18:32      1.0.0               创建
 */
package com.roboslyq.webflux.service.impl;

import com.roboslyq.webflux.entity.User;
import com.roboslyq.webflux.localdb.LocalDb;
import com.roboslyq.webflux.mapper.UserMapper;
import com.roboslyq.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/12
 * @since 1.0.0
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    LocalDb localDb;

    @Override
    public Mono<User> createUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> localDb.put(user.getId()+"",user));
    }

    @Override
    public Mono<User> deleteUser(String userId) {

        return Mono.just((User)localDb.remove(userId));
    }

    @Override
    public Mono<User> updateUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> localDb.put(user.getId()+"",user));
    }

    @Override
    public Mono<User> queryUser(String id) {
        return Mono.just((User)localDb.get(id));
    }
}