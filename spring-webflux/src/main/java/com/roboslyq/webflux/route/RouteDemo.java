package com.roboslyq.webflux.route;

import com.roboslyq.webflux.handler.EchoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouteDemo {
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(EchoHandler echoHandler) {
        System.out.println("init....");
        return route(GET("/echo"), echoHandler::echo)
                .andRoute(GET("/echo1"), echoHandler::echo)
                .andRoute(GET("/echo2"), echoHandler::echo)
                .filter((request, next) -> {
                    System.out.println("route filter");
                    System.out.println(request.path());
                    if(request.path().equals("/echo")){
                        return ServerResponse.status(UNAUTHORIZED).build();
                    }else{
                        return next.handle(request);
                    }
                });
    }
}
