package com.roboslyq.autoconfiguration.condition;

import com.roboslyq.autoconfiguration.condition.service.SumService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author roboslyq
 * @data 2018/12/31 10:22
 * @desc :
 **/
@SpringBootApplication(scanBasePackages = "com.roboslyq.autoconfiguration.condition")
//@ComponentScan(basePackages ="com.roboslyq.autoconfiguration.condition")
public class ProfileBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
        new SpringApplicationBuilder( ProfileBootstrap.class )
                .web( WebApplicationType.NONE )
                .profiles( "java7")
                .run( args );
        SumService sumService = configurableApplicationContext.getBean( SumService.class );
        System.out.println(sumService.sum( 1,2,3,4,5,6,7,8,9,10 ));
        configurableApplicationContext.close();
    }
}
