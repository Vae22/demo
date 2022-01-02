package com.example.demo.controller;

import com.example.demo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liminghao.
 * @date 2021/12/4
 * @time 23:04
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello() {
        asyncService.hello();//停止三秒
        return "OK";
    }


}
