/**
 * Copyright (C), 2015-2020
 * FileName: FileServiceImpl
 * Author:   luo.yongqian
 * Date:     2020/3/16 22:44
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/16 22:44      1.0.0               创建
 */
package com.roboslyq.webflux.service.impl;

import com.roboslyq.webflux.common.Constants;
import com.roboslyq.webflux.service.FileService;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 〈〉
 *
 * @author luo.yongqian
 * @date 2020/3/16
 * @since 1.0.0
 */
@Service
public class FileServiceImpl implements FileService {


    @Override
    public String save(FilePart filePart) {
        String fileName = filePart.filename();
        Path path = Paths.get(Constants.TEMP_FILE_DIR + fileName);
        File dest = path.toFile();
        filePart.transferTo(dest);
        System.out.println("文件"+ Constants.TEMP_FILE_DIR + fileName +"上传测试成功！！");
        return Constants.TEMP_FILE_DIR + fileName;
    }
}