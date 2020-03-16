/**
 * Copyright (C), 2015-2020
 * FileName: FileRoute
 * Author:   luo.yongqian
 * Date:     2020/3/16 14:52
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/16 14:52      1.0.0               创建
 */
package com.roboslyq.webflux.route;

import com.roboslyq.webflux.handler.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/16
 * @since 1.0.0
 */
@Configuration
public class FileRoute {
    @Autowired
    private FileHandler fileHandler;

    @Bean
    public RouterFunction<ServerResponse> fileRoutes(){
        return RouterFunctions.nest(
                RequestPredicates.path("/file"),
                //文件上传 json响应
                RouterFunctions.route(RequestPredicates.POST("/upload").and(accept(MediaType.MULTIPART_FORM_DATA)), fileHandler::upload)
                        .andRoute(RequestPredicates.POST("/upload1").and(accept(MediaType.MULTIPART_FORM_DATA)), fileHandler::upload1)
                        //文件下载 stream IO
                        .andRoute(RequestPredicates.GET("/download/{fileName}"), fileHandler::download)
        );
    }

}