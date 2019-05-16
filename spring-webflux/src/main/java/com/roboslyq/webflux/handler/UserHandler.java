package com.roboslyq.webflux.handler;

import com.roboslyq.webflux.entity.User;
import com.roboslyq.webflux.mapper.UserMapper;
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
   private UserMapper userMapper;
    public Mono<ServerResponse> selectOneUser(ServerRequest request) {
        Map<String,String> variables = request.pathVariables();

        Long id = Long.valueOf(variables.get("id"));

        if(null == id) return ServerResponse.ok().body(Mono
                .just("传入ID不能为空"),String.class);

        return ServerResponse.ok().body(Mono
               .just(userMapper.selectById(id)),User.class);
    }
}
