package com.zmh.girl.web;

import com.zmh.girl.model.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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


    /**
     *
     * @param name
     * @return
     */
    //{name}的位置可以放在/hello/{name}或者/{name}/hello/
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String helloP(@PathVariable("name") String name){

        return "Hello " + name;
    }
    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "Hello " + name;
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloR(@RequestParam(value = "name",defaultValue = "zmh") String name){
        return "Hello " + name;
    }

    @RequestMapping(value = {"/hello/Page","/hi"},method = RequestMethod.GET)
    public String helloPage(){
        return "index";
    }
}
