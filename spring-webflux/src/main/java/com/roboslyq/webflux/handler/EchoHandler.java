package com.roboslyq.webflux.handler;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class EchoHandler {

    public Mono<ServerResponse> echo(ServerRequest request) {
        User user = new User();
        user.setId(1);
        user.setName("roboslyq");
        return ServerResponse.ok().body(Mono.just(user), User.class);
    }

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