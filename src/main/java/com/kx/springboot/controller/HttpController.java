package com.kx.springboot.controller;

import com.kx.springboot.service.impl.RedisService;
import com.kx.springboot.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("httpdemo")
public class HttpController {
    @Autowired
    private RedisService redisService ;

    //taskType=security
    @RequestMapping(value = "/security/test",method = RequestMethod.GET)
    @ResponseBody
    public void httpTest(String taskId){
        String url = "https://api.51datakey.com/security/v1/result";
        String param = taskId;
        String result = HttpUtil.sendGet(url,param);
        redisService.set(taskId,result);
    }

    @RequestMapping(value = "/security/status",method = RequestMethod.GET)
    @ResponseBody
    public String statusTest(String taskId){
        String url = "https://api.51datakey.com/security/v1/tasks";
        String param = taskId+"/status";
        String result = HttpUtil.sendGet(url,param);
        return result;
    }

    @RequestMapping(value = "/security/get",method = RequestMethod.POST)
    @ResponseBody
    public  String   get(String taskId){
        return (String)redisService.get(taskId);

    }


    @RequestMapping(value = "/security/ui",method = RequestMethod.GET)
    @ResponseBody
    public String httpUI(){
        String url = "https://api.51datakey.com/h5/importV3/index.html#/securityList?apiKey=30f300e314bf44c2a767ea9f94e1c70a&userId=341225199007018974&backUrl=http%3A%2F%2Flocalhost:8080/httpdemo/security/test&themeColor=FF0000";
        return url;
    }


    @RequestMapping(value = "/security/report",method = RequestMethod.POST)
    @ResponseBody
    public String securityReport(String result){
        return result;
    }

    //zmscore
    @RequestMapping(value = "/zmscore/test",method = RequestMethod.GET)
    @ResponseBody
    public void zmscoreTest(String taskId){
        String url = "https://api.51datakey.com/gateway/zmscore/v1/data";
        String param = taskId;
        String result = HttpUtil.sendGet(url,param);
        redisService.set(taskId,result);
    }


    @RequestMapping(value = "/zmscore/ui",method = RequestMethod.GET)
    @ResponseBody
    public String zmscoreUI(){
        String url = "https://api.51datakey.com/h5/importV3/index.html#/zmscore?apiKey=30f300e314bf44c2a767ea9f94e1c70a&userId=341225199007018974&backUrl=http%3A%2F%2Flocalhost:8080/httpdemo/zmscore/test&themeColor=FF0000";
        String param = "";
        String result = HttpUtil.sendGet(url,param);
        return result;
    }
}
