package com.example.springbootexperiment06.controller;

import com.example.springbootexperiment06.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import javax.validation.constraints.Size;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@Validated//校验注解
public class UserController {
    @RequestMapping("/api")
    public Map postUser(@Valid @RequestBody User user){
        return Map.of("user",user);
    }
    @GetMapping("/users/{username}")
    public void getViolationException(
            @Size(min=2,max=6, message="用户参数信息错误")
            @PathVariable String username){}
}
