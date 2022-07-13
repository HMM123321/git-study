package com.hmm.integral.service;

import com.hmm.integral.dao.inteDao;
import com.hmm.integral.entity.Inte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author hmm
 * @Date 2021/9/17 18:37
 */
@Service
@Transactional
public class inteServiceImpl implements inteService{

    @Autowired
    inteDao inteDao;

    @Override
    public Inte query(String username) {
        return inteDao.query(username);
    }

    @Override
    public void change(Integer number, String username) {
        inteDao.change(number,username);
    }
}
