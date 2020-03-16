/**
 * Copyright (C), 2015-2020
 * FileName: FileService
 * Author:   luo.yongqian
 * Date:     2020/3/16 22:42
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/16 22:42      1.0.0               创建
 */
package com.roboslyq.webflux.service;

import org.springframework.http.codec.multipart.FilePart;

import java.io.File;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/16
 * @since 1.0.0
 */
public interface FileService {

    public String save(FilePart file);

}