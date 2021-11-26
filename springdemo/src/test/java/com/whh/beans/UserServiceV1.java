package com.whh.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 添加有参构造函数
 * @author: Artermus wang on 2021-11-15 15:10
 */
@Slf4j
@Getter
@Setter
public class UserServiceV1 {

    private String name;

    private UserDao userDao;


    public UserServiceV1(String name) {
        this.name = name;
    }

    public UserServiceV1() {
    }

    public void queryInfo(){
        System.out.println("查询信息, " + this.name+" "+this);
        System.out.println("userDao = " + userDao.getValue());
    }


}
