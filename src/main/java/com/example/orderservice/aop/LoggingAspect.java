package com.example.orderservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterReturning("execution(* com.example.orderservice.service.*.*(..))")
    public void logAfterServiceMethods(JoinPoint joinPoint) {
        System.out.println("[LOG] Executed: " + joinPoint.getSignature().toShortString());
    }
}
