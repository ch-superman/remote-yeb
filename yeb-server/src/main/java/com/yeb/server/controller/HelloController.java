package com.yeb.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 *
 * @Author:Ch
 * @Date:2021/03/02/13:50
 * @Description: 测试
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }


}
