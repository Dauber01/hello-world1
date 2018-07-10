package com.wanxl.spring.cloud.initializrstart.domain;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Lucifer
 * @do 用于初步测试的用户bean
 * @date 2018/07/06 10:42
 */
public class User {

    public interface UserSimpleView{};

    public interface UserDetailView extends UserSimpleView{};

    private String username;

    private String password;

    private int age;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
