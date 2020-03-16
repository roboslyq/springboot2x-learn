/**
 * Copyright (C), 2015-2020
 * FileName: FileHandler
 * Author:   luo.yongqian
 * Date:     2020/3/16 14:52
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/16 14:52      1.0.0               创建
 */
package com.roboslyq.webflux.handler;

import com.oracle.tools.packager.IOUtils;
import com.roboslyq.webflux.common.Constants;
import com.roboslyq.webflux.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.springframework.web.reactive.function.BodyInserters.fromDataBuffers;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * 〈〉
 *
 * @author luo.yongqian
 * @date 2020/3/16
 * @since 1.0.0
 */
@Component
public class FileHandler {

    @Autowired
    FileService fileService;

    /**
     * 单个文件上传方式一
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> upload(ServerRequest serverRequest) {
        return serverRequest.multipartData().flatMap(multiValueMap -> {
            multiValueMap.forEach((key, file) -> {
                file.forEach(f -> fileService.save((FilePart) f));
            });
            return ServerResponse.ok().body(fromObject("successed"));
        });
    }

    /**
     * 单个文件上传方式2
     * @param request
     * @return
     */
    public Mono<ServerResponse> upload1(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(request.body(BodyExtractors.toMultipartData()).map(parts -> {
                            Map<String, Part> map = parts.toSingleValueMap();
                            FilePart filePart = (FilePart) map.get("file");
                            return fileService.save(filePart);
                        }).map(filename -> {
                            if (!StringUtils.isEmpty(filename)) {
                                return "OK";
                            } else {
                                return "error";
                            }
                        }), String.class
                );
    }

    /**
     * 文件下载
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> download(ServerRequest serverRequest) {
        String fileName = serverRequest.pathVariable("fileName");
        Path path = Paths.get(Constants.TEMP_FILE_DIR + fileName);
        File file = path.toFile();
        if (file.exists()) {
            return ServerResponse.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName)
                    .contentType(MediaType.TEXT_PLAIN)
                    .contentLength(file.length())
                    .body(fromDataBuffers(Mono.create(r -> {
                        DataBuffer buf = null;
                        try {
                            buf = new DefaultDataBufferFactory().wrap(IOUtils.readFully(file));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        r.success(buf);
                    })));
        } else {
            return ServerResponse.ok().body(fromObject("文件不存在"));
        }
    }
}

