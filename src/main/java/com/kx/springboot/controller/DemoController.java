package com.kx.springboot.controller;


import com.kx.springboot.service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private RedisService redisService ;


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public String demoTest(){
        return "123123";
    }

    @RequestMapping(value = "/gettest",method = RequestMethod.POST)
    @ResponseBody
    public String demoGetTest(){
       String r = String.valueOf(redisService.get("kdd"));
        return r;
    }

    @Cacheable(value = "uuiijijjjkjkj",key="#p0")
    @RequestMapping(value = "/testKdd",method = RequestMethod.POST)
    @ResponseBody
    public List<String>  kdd(String j){
        List<String> list = new ArrayList<String>();
        for(int i=0;i<100;i++){
            list.add(String.valueOf(i));
        }
        return list;
    }

}