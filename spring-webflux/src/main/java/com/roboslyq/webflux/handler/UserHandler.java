package com.roboslyq.webflux.handler;

import com.roboslyq.webflux.entity.User;
import com.roboslyq.webflux.exception.LocalException;
import com.roboslyq.webflux.mapper.UserMapper;
import com.roboslyq.webflux.service.UserService;
import com.roboslyq.webflux.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service(value = "userHandler")
public class UserHandler {

    @Autowired
    UserService userService;


    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<ServerResponse> responseMono =
                ok()
                .body(userService.createUser(request.bodyToMono(User.class)), User.class);
        System.out.println("create user controller 完成！！");
        return responseMono;
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        return ok()
                .body(userService.deleteUser(request.pathVariable("id")), User.class);

    }

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        return ok()
                .body(userService.updateUser(request.bodyToMono(User.class)), User.class);

    }

    public Mono<ServerResponse> queryUser(ServerRequest request) {
        System.out.println("收到请求的 id = " + request.pathVariable("id"));

        return userService.queryUser(request.pathVariable("id"))
                .flatMap(user -> ok().body(fromObject(user)))
                .switchIfEmpty(ok().body(fromObject(new LocalException("500","异常"))));
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
       return ServerResponse.ok()
               .body(userService.findAll(), User.class)
               .switchIfEmpty(ServerResponse.ok().body(fromObject(new LocalException("500","异常"))));
//        return userService.findAll()
//                .flatMap(user -> ServerResponse.ok().body(fromObject(user)))
//                .switchIfEmpty(ServerResponse.ok().body(fromObject(new LocalException("500","异常"))));
    }
    public Mono<ServerResponse> findAll2(ServerRequest request) {

        return userService.findAll2()
                .flatMap(userMap -> ServerResponse.ok().body(fromObject(userMap)))
                .switchIfEmpty(ServerResponse.ok().body(fromObject(new LocalException("500","异常"))));
    }
}
