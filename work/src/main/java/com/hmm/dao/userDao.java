package com.hmm.dao;

import com.hmm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hmm
 * @Date 2021/9/8 19:07
 */
@Mapper
public interface userDao {
    User login(@Param("username") String username, @Param("password") String password);

    int register(@Param("username") String username, @Param("password") String password);

    User find(@Param("username") String name);

    List<User> query();

    Boolean save(User user);

    int delete(Integer id);
}
