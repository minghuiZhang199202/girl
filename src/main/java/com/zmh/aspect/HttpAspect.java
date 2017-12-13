package com.zmh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>@author minghuiZhang.</p>
 * <p>description：</p>
 * <p>date: created in 10:22 2017/12/13</p>
 * <p>modified By: </p>
 */
@Aspect()
@Order(2)
@Component
public class HttpAspect extends BaseAspect{

    @Pointcut("execution(public * com.girl.web.GirlController.girlList(..))")
    public void httpAspect(){

    }
    @Before("httpAspect()")
    public void before(JoinPoint joinPoint){
        //接收到请求，记录请求内容
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //记录下请求内容
        this.logger.info("url:{}", request.getRequestURI());
        this.logger.info("http_method:{}", request.getMethod());
        this.logger.info("ip:{}", request.getRemoteAddr());
        this.logger.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        this.logger.info("args:{} ", Arrays.toString(joinPoint.getArgs()));
    }
}
