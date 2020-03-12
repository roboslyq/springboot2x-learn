package com.roboslyq.webflux.handler;

import com.roboslyq.webflux.entity.User;
import com.roboslyq.webflux.mapper.UserMapper;
import com.roboslyq.webflux.service.UserService;
import com.roboslyq.webflux.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

@Service(value = "userHandler")
public class UserHandler {

    @Autowired
    UserService userService;


    public Mono<ServerResponse> createUser(ServerRequest request) {
       return ServerResponse
               .ok()
               .body(userService.createUser(request.bodyToMono(User.class)),User.class);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(userService.deleteUser(request.pathVariable("id")),User.class);

    }

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(userService.updateUser(request.bodyToMono(User.class)),User.class);

    }

    public Mono<ServerResponse> queryUser(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(userService.queryUser(request.pathVariable("id")),User.class);
    }
}
