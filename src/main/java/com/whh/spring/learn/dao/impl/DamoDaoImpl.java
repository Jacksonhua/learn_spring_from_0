package com.whh.spring.learn.dao.impl;

import com.whh.spring.learn.dao.DemoDao;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Artermus wang on 2021-04-15 11:37
 */
@Slf4j
public class DamoDaoImpl implements DemoDao {


    @Override
    public List<String> findAll() {
        //模拟数据库
        return Collections.singletonList("this is all");
    }
}
