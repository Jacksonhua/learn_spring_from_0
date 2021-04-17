package cn.whh.spring.dao.impl;

import cn.whh.spring.dl.bean.Person;
import cn.whh.spring.dao.PersonDao;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * @description: 假装他是个Oracle
 * @author: Artermus wang on 2021-04-17 16:28
 */
@Slf4j
public class PersonOracleDaoImpl implements PersonDao {

    @Override
    public List<Person> findAll() {
        return Collections.singletonList(new Person("Oracle",18));
    }
}
