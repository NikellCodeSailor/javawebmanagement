package com.lzy.exception;

import com.lzy.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//全局异常处理器
public class GlobalExceptionHandler {
    //处理异常
    @ExceptionHandler(Exception.class)//指定能够处理的异常内容
    public Result ex(Exception e){
        e.printStackTrace();//打印推栈的异常信息

        //捕获异常，响应一个标准的Result
        return Result.error("错误---->请重试或联系管理员");
    }
}
