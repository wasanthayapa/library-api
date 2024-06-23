package com.api.library.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.api.library.service..*)")
    public void applicationPointcut() {
    }

    @Before("applicationPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("Entering in Method :  " + joinPoint.getSignature().getName());
        log.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("applicationPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Exiting in Method :  " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "applicationPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Method Return value : " + result);
    }

    @AfterThrowing(pointcut = "applicationPointcut()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.error("Method Exception : " + error);
    }

    @Around("applicationPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return result;
    }
}
