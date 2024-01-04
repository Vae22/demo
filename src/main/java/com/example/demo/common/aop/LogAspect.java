package com.example.demo.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author liminghao.
 * @date 2022/7/9
 * @time 22:51
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.example.demo.service.impl.*.*(..))")
    public void pc1() {
    }

//    @Before(value = "pc1()")
//    public void before(JoinPoint jp) {
//        String name = jp.getSignature().getName();
//        System.out.println(name + "方法开始执行...");
//    }
//
//    @After(value = "pc1()")
//    public void after(JoinPoint jp) {
//        String name = jp.getSignature().getName();
//        System.out.println(name + "方法开始结束...");
//    }
//
//    @AfterReturning(value = "pc1()", returning = "result")
//    public void afterReturning(JoinPoint jp, Object result) {
//        String name = jp.getSignature().getName();
//        System.out.println(name + "方法返回值为:" + result);
//    }
//
//    @AfterThrowing(value = "pc1()", throwing = "e")
//    public void afterThrowing(JoinPoint jp, Exception e) {
//        String name = jp.getSignature().getName();
//        System.out.println(name + "方法抛异常了,异常是:" + e.getMessage());
//    }

    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();
            // 执行目标方法
            Object result = pjp.proceed();
            // 记录执行方法结束时间
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime; // 结束时间 - 开始时间
            String name = pjp.getSignature().getName();
            log.info("目标方法: "+ name +" 执行耗时:{}", time + "ms");
            return result;
        } catch (Throwable e) {
            log.error("after:{}", e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }


}
