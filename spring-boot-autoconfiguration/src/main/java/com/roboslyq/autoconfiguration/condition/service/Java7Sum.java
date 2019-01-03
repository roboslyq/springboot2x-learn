package com.roboslyq.autoconfiguration.condition.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author roboslyq
 * @data 2018/12/31 20:49
 * @desc :
 **/
@Service
@Profile( "java7" )
public class Java7Sum implements SumService{
    @Override
    public Integer sum(Integer... src) {
        int result = 0;
        System.out.println("java7 sum");
        for(int tmp : src){
            result += tmp ;
        }
        return result;
    }

    public static void main(String[] args) {
        Java7Sum java7Sum = new Java7Sum();
        System.out.println( java7Sum.sum( 1,2,3,4,5,6,7,8,9,10) );
    }
}
