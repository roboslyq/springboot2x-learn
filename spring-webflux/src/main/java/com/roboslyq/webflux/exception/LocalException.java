/**
 * Copyright (C), 2015-2020
 * FileName: LocalException
 * Author:   luo.yongqian
 * Date:     2020/3/13 16:21
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/13 16:21      1.0.0               创建
 */
package com.roboslyq.webflux.exception;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/13
 * @since 1.0.0
 */
public class LocalException {
    private String errorCode;
    private String errorMessage;

    public LocalException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}