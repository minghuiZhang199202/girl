package com.zmh.log;

import com.zmh.aspect.BaseAspect;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>@author minghuiZhang.</p>
 * <p>description：</p>
 * <p>date: created in 9:22 2017/12/13</p>
 * <p>modified By: </p>
 */
@Aspect
@Order(5)
@Component
public class WebLoggerAspect extends BaseAspect{



    @Pointcut("execution(public * com.*.web.*.*(..))")
    public void webLog(){
    }
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)throws Throwable{
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       //接收到请求，记录请求内容
        HttpServletRequest request = servletRequestAttributes.getRequest();

        //记录下请求内容
        //记录下请求内容
        this.logger.info("url:{}", request.getRequestURI());
        this.logger.info("http_method:{}", request.getMethod());
        this.logger.info("ip:{}", request.getRemoteAddr());
        this.logger.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        this.logger.info("args:{} ", Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret)throws Throwable{
        //处理完请求，返回内容
        this.logger.info("response:{}", ret);
        this.logger.info("cost time:{} ",(System.currentTimeMillis() - startTime.get()));
    }
    @After("webLog()")
    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
       this.logger.info("--后置通知--------  "+methodName+"方法执行结束");
    }
    @AfterThrowing(pointcut = "webLog()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        this.logger.info("调用方法"+methodName+"出现异常："+ ex);
    }
}
