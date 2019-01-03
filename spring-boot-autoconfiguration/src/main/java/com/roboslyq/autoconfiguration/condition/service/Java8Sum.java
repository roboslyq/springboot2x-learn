package com.roboslyq.autoconfiguration.condition.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author roboslyq
 * @data 2018/12/31 20:49
 * @desc :
 **/
@Service
@Profile( "java8" )
public class Java8Sum implements SumService{
    @Override
    public Integer sum(Integer... src) {
        System.out.println("java8 sum");

        Integer result = Stream.of(src).reduce( 0,Integer::sum );
        return result.intValue();
    }

    public static void main(String[] args) {
        Java8Sum java8Sum = new Java8Sum();
        System.out.println( java8Sum.sum( 1,2,3,4,5,6,7,8,9,10) );
    }
}
