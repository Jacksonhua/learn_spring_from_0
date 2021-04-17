package cn.whh.spring.dao;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class PersonDaoTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("quickstart-byName.xml");

    @Test
    public void test(){
        Map<String, PersonDao> beansOfType = context.getBeansOfType(PersonDao.class);
        System.out.println("beansOfType = " + beansOfType);
        beansOfType.forEach((beanName, bean) ->
            System.out.println(beanName + " : " + bean.toString())
        );
    }

}
