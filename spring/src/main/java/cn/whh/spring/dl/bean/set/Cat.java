package cn.whh.spring.dl.bean.set;

import cn.whh.spring.dl.bean.Person;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-04-17 16:05
 */
@Slf4j
@Data
public class Cat {
    private String name;
    private Integer age;
    private Person master;

}
