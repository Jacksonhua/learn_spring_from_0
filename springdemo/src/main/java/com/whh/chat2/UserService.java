package com.whh.chat2;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 15:10
 */
@Slf4j
@Getter
@Setter
public class UserService {



    public void queryInfo(){
        System.out.println("查询信息" + this);
    }


}
