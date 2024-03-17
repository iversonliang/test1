package com.test.mysql.dao;

import com.test.mysql.entity.User;
import com.test.mysql.entity.UserTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    List<User> searchList(@Param("keyword") String keyword);

    boolean addUsers(List<User> users);

    Integer updateById(User user);

    List<UserTest> getUserTest(@Param("id") Integer id);
}