package com.roboslyq.webflux.route;

import com.roboslyq.webflux.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author luo.yongqian
 */
@Configuration
public class UserRoute {

@Bean
public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler){
        return RouterFunctions.nest( RequestPredicates.path("/user"),
                route(POST("/create").and(accept(APPLICATION_JSON)),userHandler::createUser)
                .andRoute(DELETE("/delete/{id}").and(accept(APPLICATION_JSON)),userHandler::deleteUser)
                .andRoute(POST("/update").and(accept(APPLICATION_JSON)),userHandler::updateUser)
                .andRoute(GET("/query/{id}"),userHandler::queryUser)
                .andRoute(GET("/findall"),userHandler::findAll)
                .andRoute(GET("/findall2"),userHandler::findAll2)
                );
    }
}
