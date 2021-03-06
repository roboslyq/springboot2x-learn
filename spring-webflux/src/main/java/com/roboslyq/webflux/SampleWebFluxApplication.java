package com.roboslyq.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author luo.yongqian
 */
@SpringBootApplication
@EnableWebFlux
public class SampleWebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleWebFluxApplication.class);
    }
}
