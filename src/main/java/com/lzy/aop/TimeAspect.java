package com.lzy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*@Slf4j
@Component
@Aspect//AOP类*/
public class TimeAspect {
    /*@Around("execution(* com.lzy.service.*.*(..))")//切入点表达式
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //记录方法开始时间
        long begin = System.currentTimeMillis();
        //执行原始方法
        Object result = proceedingJoinPoint.proceed();
        //记录方法执行结束时间
        long end = System.currentTimeMillis();
        //计算方法执行耗时
        log.info(proceedingJoinPoint.getSignature()+"执行耗时: {}毫秒",end-begin);//getSignature()--->获取当前执行方法
        return result;
    }*/
}
