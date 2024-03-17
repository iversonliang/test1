package com.test.mysql.service;

import com.test.mysql.entity.User;
import com.test.mysql.entity.UserTest;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    List<User> searchList(String keyword);

    boolean addUsers(List<User> users);

    boolean updateById(User user);

    List<UserTest> getUserTest(Integer id);
}
