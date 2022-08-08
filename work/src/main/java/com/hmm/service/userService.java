package com.hmm.service;

import com.hmm.entity.User;

import java.util.List;

/**
 * @Author hmm
 * @Date 2021/9/8 16:17
 */
public interface userService {

    User login(String username, String password);

    int register(String username, String password);

    User find(String username);

    List<User> query();

    int delete(Integer id);

    Boolean save(User user);


}
