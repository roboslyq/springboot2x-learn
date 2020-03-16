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
import com.roboslyq.webflux.localdb.SimpleDb;
import com.roboslyq.webflux.mapper.UserMapper;
import com.roboslyq.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

/**
 * 〈〉
 *
 * @author luo.yongqian
 * @date 2020/3/12
 * @since 1.0.0
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    SimpleDb<User> localDb;

    @Override
    public Mono<User> createUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            System.out.println("start insert / update a user : " + user.getName());
            localDb.put(user.getId() + "", user);
            System.out.println("insert / update successed");
        });
    }

    @Override
    public Mono<User> deleteUser(String id) {

        return Mono.defer(() -> {
            System.out.println("start remove a user : " + id);
            User user = localDb.remove(id);
            System.out.println("end remove a user ");
            return Objects.isNull(user) ? Mono.empty() : Mono.just(user);
        });
    }

    @Override
    public Mono<User> updateUser(Mono<User> userMono) {
        return createUser(userMono);

    }

    @Override
    public Mono<User> queryUser(String id) {

        return Mono.defer(() -> Objects.isNull(localDb.get(id)) ? Mono.empty() : Mono.just(localDb.get(id)));
    }

    @Override
    public Flux<User> findAll() {
        return Flux.fromIterable(localDb.getAll().values()).switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Map<String, User>> findAll2() {
        return Mono.just(localDb.getAll()).switchIfEmpty(Mono.empty());
    }
}