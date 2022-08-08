package com.hmm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hmm
 * @Date 2021/9/8 16:19
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer integralNumber;
    private String number;



}
