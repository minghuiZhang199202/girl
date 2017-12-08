package com.zmh.girl.web;

import com.zmh.girl.model.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author  zmh
 * date 2017-12-8 22:22:44
 * modified by
 */
@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello Spring Boot " + girlProperties.getContent();
    }
}
