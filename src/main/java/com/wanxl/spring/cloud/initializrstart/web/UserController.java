package com.wanxl.spring.cloud.initializrstart.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.wanxl.spring.cloud.initializrstart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Lucifer
 * @do user的操作接口
 * @date 2018/07/06 10:46
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Map helloService;

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> queryAllUser(){
        System.out.println(helloService);
        return Arrays.asList(new User(), new User(), new User());
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User queryOne(){
        return new User();
    }

}
