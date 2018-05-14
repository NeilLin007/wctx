package com.cn.wctx.advice;

import com.cn.wctx.model.Resp;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandlerException {
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Resp handlerValidatorException(MethodArgumentNotValidException ex) {
        return new Resp(Resp.FAILD, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}