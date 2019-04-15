package com.example.springbootexperiment05.controller;

import com.example.springbootexperiment05.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/index")
    public Map getIndex(){
        return Map.of("index","main");
    }
    //在控制组件中模拟一个users集合，模拟封装若干user对象
    private static List<User> create() {
        users = new ArrayList<>();
        User user = new User(1, "BO", "123456", "956");
        User user1 = new User(2, "ZhengDS", "12345678", "449");
        User user2 = new User(3, "HelloWorld", "558", "JAVA is best language");
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }
    private static List<User> users = create();
    //创建处理/users，get请求方法，返回map对象，封装users集合
    @GetMapping("/users")
    public Map getUsers(){
        return Map.of("users",users);
    }
    //创建处理/users/{uid}，get请求方法，获取请求地址user ID参数，基于参数从users集合中获取对象，封装到map返回。
    // 注意Map.of()不能添加null，因此需处理如果集合中没有指定ID对象的实现
    @GetMapping("/users/{uid}")
    public Map getUser(@PathVariable int uid) {
        log.debug("{}", uid);
        User user = users.stream()
                .filter(u -> u.getId() == uid)
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(user)
                .map(u -> Map.of("user", u))
                .orElse(Map.of());
    }

    //创建处理/users，post请求方法，将请求数据封装到User对象，作为参数注入方法，将对象添加到users集合
    @PostMapping("/users")
    public Map postUser(@RequestBody User user) {
        users.add(user);
        return Map.of("users", users);
    }

}
