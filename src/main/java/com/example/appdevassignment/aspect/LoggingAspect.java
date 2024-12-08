package com.example.appdevassignment.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.appdevassignment.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Executing: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.appdevassignment.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method {} completed successfully", joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.example.appdevassignment.service.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Error in {}: {}", joinPoint.getSignature().getName(), error.getMessage());
    }

    @Around("execution(* com.example.appdevassignment.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("{} executed in {}ms", joinPoint.getSignature().getName(), (end - start));
        return result;
    }
}