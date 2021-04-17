package cn.whh.spring.dl.bean;

import cn.whh.spring.dl.bean.set.Cat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-04-17 15:23
 */
@Slf4j
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    //
    //循环依赖的发生
    //private Cat cat;
    public Person(String name, Integer age){
        this.age = age;
        this.name = name;
    }
}
