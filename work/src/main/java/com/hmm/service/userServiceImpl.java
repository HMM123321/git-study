package com.hmm.service;

import com.hmm.dao.userDao;
import com.hmm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author hmm
 * @Date 2021/9/8 16:18
 */
@Service
@Transactional
public class userServiceImpl implements userService {

    @Autowired
    userDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public int register(String username, String password) {
        return userDao.register(username, password);
    }

    @Override
    public User find(String username) {
        return userDao.find(username);
    }

    @Override
    public List<User> query() {
        return userDao.query();
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public Boolean save(User user){
        return userDao.save(user);
    }
}
