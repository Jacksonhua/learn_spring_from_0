package com.whh.spring.learn.service.impl;

import com.whh.spring.learn.dao.DemoDao;
import com.whh.spring.learn.dao.impl.DamoDaoImpl;
import com.whh.spring.learn.service.DemoService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @description:
 * @author: Artermus wang on 2021-04-15 16:11
 */
@Slf4j
public class DemoServiceImpl implements DemoService {

    private DemoDao demoDao = new DamoDaoImpl();

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
