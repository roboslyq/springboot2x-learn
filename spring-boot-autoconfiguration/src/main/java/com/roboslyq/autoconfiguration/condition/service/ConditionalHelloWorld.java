package com.roboslyq.autoconfiguration.condition.service;

import com.roboslyq.autoconfiguration.condition.annotation.ConditionalOnSystemProperty;
import org.springframework.stereotype.Service;

/**
 * @author roboslyq
 * @data 2018/12/31 21:32
 * @desc :
 **/
@Service(value = "conditionalHelloWorld")
@ConditionalOnSystemProperty( name ="user.name",value = "robos")
public class ConditionalHelloWorld {

}
