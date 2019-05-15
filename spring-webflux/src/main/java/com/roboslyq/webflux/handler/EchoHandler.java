package com.roboslyq.webflux.handler;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 定义webflux中的handler处理器，即具体的业务逻辑处理器
 */
@Component
public class EchoHandler {

    public Mono<ServerResponse> echo(ServerRequest request) {
        User user = new User();
        user.setId(1);
        user.setName("roboslyq");
        return ServerResponse.ok().body(Mono.just(user), User.class);
    }

    /**
     * 简单的实体抽像
     */
    static class User {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}