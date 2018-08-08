package com.wanxl.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello controller
 *
 * @author Lucifer
 * @date 2018／02／03 13:41
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWord() {
        return "Hello World!";
    }

}
