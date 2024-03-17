package com.test.mysql.controller;

import com.test.mysql.entity.UserTest;
import com.test.mysql.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.*;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/list")
    public List<UserTest> getUserList() {
        return userService.getUserTest(1);
    }
}
