package com.roboslyq.webflux.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AnnotationExceptionHandler {
//    @ExceptionHandler(CustomException.class)
//    @ResponseStatus(code = HttpStatus.NOT_FOUND)
//    public DefaultResult handleCustomException(CustomException e) {
//        logger.error(e.getMessage());
//        return DefaultResult.fail(e.getCode(), e.getMsg());
//    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public DefaultResult handleException(Exception e) {
        DefaultResult defaultResult = new DefaultResult();
        defaultResult.setErrMessage("fi");
        return defaultResult;
    }
    class DefaultResult{
        private String errMessage;

        public String getErrMessage() {
            return errMessage;
        }

        public void setErrMessage(String errMessage) {
            this.errMessage = errMessage;
        }
    }
}

