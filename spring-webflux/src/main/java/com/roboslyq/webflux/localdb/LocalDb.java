/**
 * Copyright (C), 2015-2020
 * FileName: LocalDb
 * Author:   luo.yongqian
 * Date:     2020/3/12 18:48
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/12 18:48      1.0.0               创建
 */
package com.roboslyq.webflux.localdb;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/12
 * @since 1.0.0
 */
@Component
public class LocalDb<T> {

private Map<String,T> db;

    public LocalDb() {
        db = new ConcurrentHashMap();
    }


    public T put(String key, T value){
        db.put(key,value);
        return value;
    }

    public T remove(String key){
        return db.remove(key);
    }

    public T update(String key, T value){
        this.remove(key);
        this.put(key,value);
        return value;
    }

    public T get(String key){
        return db.get(key);
    }

    public Map<String,T> getAll(){
        return db;
    }

}
