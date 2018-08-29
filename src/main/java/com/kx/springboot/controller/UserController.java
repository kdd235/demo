package com.kx.springboot.controller;

import com.kx.springboot.service.TestInterFace;
import com.kx.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private TestInterFace testInterFace;

    @RequestMapping("/get")
    @ResponseBody
    User getUser() {
        return testInterFace.testUser();
    }
}
