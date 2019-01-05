package org.springframework.test.context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author roboslyq
 * @data 2019/1/5 10:03
 * @desc :
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "user.id=9" ,classes = TestPropertySourceTest.class,
                webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(
        locations = "classpath:META-INF/default.properties")
public class TestPropertySourceTest {
    @Value( "${user.id}" )
    private Long userId;

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    public void enviromentEquals(){
        Assert.assertSame( environment,context.getEnvironment() );
    }

    @Test
    public void propertySourcesTest(){
//        System.out.printf("property sources %s \n",environment.getPropertySources());
        environment.getPropertySources().forEach( propertySource ->{
            System.out.printf("property source name is %s, %s \n",propertySource.getName(),propertySource);
        } );
    }

    @Test
    public void testUserId(){
        Assert.assertEquals(Long.valueOf( 9 ),userId);
    }
}
