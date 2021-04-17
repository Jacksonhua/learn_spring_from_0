package cn.whh.spring.dao;

import cn.whh.spring.dl.bean.Person;

import java.util.List;

/**
 * @description:
 * @author: Artermus wang on 2021-04-17 16:27
 */
public interface PersonDao {
    List<Person> findAll();
}
