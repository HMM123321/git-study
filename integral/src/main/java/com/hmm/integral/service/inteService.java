package com.hmm.integral.service;

import com.hmm.integral.entity.Inte;

/**
 * @Author hmm
 * @Date 2021/9/17 18:37
 */
public interface inteService {
    Inte query(String username);
    void change(Integer number,String username);
}
