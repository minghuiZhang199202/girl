package com.zmh.aspect;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * <p>@author minghuiZhang.</p>
 * <p>description：</p>
 * <p>date: created in 10:25 2017/12/13</p>
 * <p>modified By: </p>
 */
@Component
public class BaseAspect {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ThreadLocal<Long> startTime = new ThreadLocal <Long>();

}
