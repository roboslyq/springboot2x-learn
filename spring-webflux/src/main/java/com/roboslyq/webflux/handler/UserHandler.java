package com.roboslyq.webflux.handler;

import com.roboslyq.webflux.entity.User;
import com.roboslyq.webflux.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service(value = "userHandler")
public class UserHandler {
    @Autowired
    UserMapper userMapper;
    public Mono<ServerResponse> selectOneUser(ServerRequest request) {
        Long id = request.exchange().getAttribute("id");
        if(null == id) id = 1L;
       return ServerResponse.ok().body(Mono
               .just(userMapper.selectById(1)),User.class);
    }
}
