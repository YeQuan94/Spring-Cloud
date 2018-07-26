package com.cave.sc.provider.providercluster.aspect;

import com.cave.sc.provider.providercluster.annotation.LBAnnotation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP注解实现方式
 * 在这个工程中的作用是：验证是否实现了负载均衡
 */
@Aspect
@Component
public class AopAnnotation {

    // AOP注解方式实现在网上有很多博客，需要详细理解的时候去看看
    // @annotation(lb)，lb指的是after(LBAnnotation lb)中的lb

    @After("@annotation(lb)")
    public void after(LBAnnotation lb){
        System.out.println("LoadBalancer");
    }

}
