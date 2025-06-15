package org.example.java_4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* org.example.java_4.controller.*.*(..))")
    public Object logBefore(JoinPoint pjp) {
        System.out.println("Log Before the execution of " + pjp.getSignature().getName());
        return pjp;
    }
}
