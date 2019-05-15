package com.roboslyq.webflux.route;

import com.roboslyq.webflux.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserRoute {

@Bean
public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler){
        return route(GET("/selectOne"),userHandler::selectOneUser);
    }
}
