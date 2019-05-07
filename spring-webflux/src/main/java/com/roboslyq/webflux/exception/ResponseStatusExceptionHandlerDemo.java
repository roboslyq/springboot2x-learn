package com.roboslyq.webflux.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import reactor.core.publisher.Mono;

public class ResponseStatusExceptionHandlerDemo extends ResponseStatusExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        Mono<Void>  result =  super.handle(exchange,ex);
        return result;
        }
}
