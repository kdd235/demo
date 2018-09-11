package com.kx.springboot.controller;

import com.kx.springboot.service.TestInterFace;
import com.kx.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestBootController {
    @Autowired
    private TestInterFace testInterFace;

    @RequestMapping(value = "/num",method =RequestMethod.POST)
    @ResponseBody
    int home() {
        int i = testInterFace.testInterFace();
        return i;
    }

    @RequestMapping(value = "/get",method =RequestMethod.POST)
    @ResponseBody
    User getUser() {
        return testInterFace.testUser();
    }
}
