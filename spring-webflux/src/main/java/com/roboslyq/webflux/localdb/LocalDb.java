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

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/12
 * @since 1.0.0
 */
@Component
public class LocalDb {

private ConcurrentHashMap<String,Object> db;

    public LocalDb() {
        db = new ConcurrentHashMap();
    }


    public Object put(String key, Object value){
        db.put(key,value);
        return value;
    }

    public Object remove(String key){
        return db.remove(key);
    }

    public Object update(String key, Object value){
        this.remove(key);
        this.put(key,value);
        return value;
    }

    public Object get(String key){
        return db.get(key);
    }

}