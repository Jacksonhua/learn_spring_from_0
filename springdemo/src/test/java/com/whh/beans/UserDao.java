package com.whh.beans;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-26 14:54
 */
@Slf4j
public class UserDao {
    private int value = 1;

    private UserServiceV1 userServiceV1;

    public UserDao(UserServiceV1 userServiceV1) {
        this.userServiceV1 = userServiceV1;
    }

    public UserDao() {
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        userServiceV1.queryInfo();
        return super.toString();
    }
}
