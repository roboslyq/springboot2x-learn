package com.roboslyq.webflux.route;

import com.roboslyq.webflux.handler.EchoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
/**
 * Route配置示例
 */
@Configuration
public class RouteDemo {
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(EchoHandler echoHandler) {

        System.out.println("[com.roboslyq.webflux.route.RouteDemo ]  : start route define ...");
        // 添加多个route并且指定对应的handler
        return route(GET("/echo"), echoHandler::echo)
                .andRoute(GET("/echo1"), echoHandler::echo)
                .andRoute(GET("/echo2"), echoHandler::echo)
                /*1、给route添加过滤器
                 *2、类关系如下：
                 *RouterFunctions.filter(ServerRequest request, HandlerFunction<T> next)
                 *  -->HandlerFilterFunction.filter(ServerRequest request, HandlerFunction<T> next)
                 *      -->HandlerFunction.handle(ServerRequest request);
                 *3、断点调试，参数值形式如下：
                 *      request = org.springframework.web.reactive.function.server.DefaultServerRequest
                 *      next = com.roboslyq.webflux.route.RouteDemo$$Lambda$230/687501326
                 */
                .filter((request, next) -> {
                    System.out.println(request.getClass());
                    System.out.println(next.getClass());
                    System.out.println("[com.roboslyq.webflux.route.RouteDemo ] request path is : " + request.path());
                    if(request.path().equals("/echo")){
                        System.out.println("[com.roboslyq.webflux.route.RouteDemo ] 模拟被拦截，返回 status = 401");
                        return ServerResponse.status(UNAUTHORIZED).build();
                    }else{
                        return next.handle(request);
                    }
                });
    }
}
