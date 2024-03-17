package com.test.mysql.service.impl;

import com.test.mysql.dao.UserDao;
import com.test.mysql.entity.User;
import com.test.mysql.entity.UserTest;
import com.test.mysql.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public List<User> searchList(String keyword) {
        return userDao.searchList(keyword);
    }


    @Override
    public boolean addUsers(List<User> users) {
        return userDao.addUsers(users);
    }

    @Override
    public boolean updateById(User user) {
        Integer b = userDao.updateById(user);
        return false;
    }

    @Override
    public List<UserTest> getUserTest(Integer id) {
        List<UserTest> userTest = userDao.getUserTest(id);
        if (userTest != null && userTest.size() > 0) {
            UserTest test = userTest.get(0);
            String bizData = test.getUserName(); // null or exception？
            System.out.println(bizData);
        }
        return userDao.getUserTest(id);
    }
}
