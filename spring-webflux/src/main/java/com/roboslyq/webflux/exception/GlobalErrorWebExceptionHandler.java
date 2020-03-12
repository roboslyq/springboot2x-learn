package com.roboslyq.webflux.exception;

import com.roboslyq.webflux.exception.util.JsonHttpMessageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

/**
 * 此类可以正常工作，与{@link ErrorWebExceptionHandlerDemo}通过order来确定优先级
 */
@Component
@Order(-3)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler  {

    @Autowired
    JsonHttpMessageWriter jsonHttpMessageWriter;
    public GlobalErrorWebExceptionHandler(JsonHttpMessageWriter jsonHttpMessageWriter,
                                        ErrorAttributes errorAttributes,
                                        ResourceProperties resourceProperties,
                                        ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, applicationContext);
        setMessageWriters(Collections.singletonList(jsonHttpMessageWriter));
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        System.out.println("GlobalWebExceptionHandlerDemo... ..." + errorAttributes.toString());
        return RouterFunctions.route(
                RequestPredicates.all(), this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse(
            ServerRequest request) {
        Map<String, Object> errorPropertiesMap = getErrorAttributes(request, false);
        return ServerResponse
                .status(Integer.valueOf(errorPropertiesMap.getOrDefault("code", 500).toString()))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(errorPropertiesMap));
    }
}