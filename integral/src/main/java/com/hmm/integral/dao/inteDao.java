package com.hmm.integral.dao;


import com.hmm.integral.entity.Inte;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author hmm
 * @Date 2021/9/17 18:38
 */
@Mapper
public interface inteDao {
    Inte query(@Param("username") String username);
    void change(@Param("number") Integer number,@Param("username") String username);
}
