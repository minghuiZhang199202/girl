package com.zmh.girl.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author  zmh
 * date 2017-12-8 22:22:44
 * modified by
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello Spring Boot";
    }
}
