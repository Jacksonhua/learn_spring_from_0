package com.whh.chat4.beans.factory.support;

import com.whh.beans.UserDao;
import com.whh.beans.UserServiceV1;

import com.whh.chat4.beans.PropertyValue;
import com.whh.chat4.beans.PropertyValues;
import com.whh.chat4.beans.factory.config.BeanDefinition;
import com.whh.chat4.beans.factory.config.BeanReference;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultListableBeanFactoryTest {
    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    @Test
    public void test_1(){


        // 1.bean definition
        BeanDefinition beanDefinition = new BeanDefinition(UserServiceV1.class);
        //2. register beanDefinition
        factory.registerBeanDefinition("user",beanDefinition);

        UserServiceV1 user = (UserServiceV1) factory.getBean("user", "whh");
        UserServiceV1 user2 = (UserServiceV1) factory.getBean("user");
        assertEquals(user,user2);
    }
    @Test
    public void test_reference(){
        // 1.bean definition
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name","whh"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        BeanDefinition daoBeanDefinition = new BeanDefinition(UserDao.class);
        BeanDefinition serviceBeanDefinition = new BeanDefinition(UserServiceV1.class,propertyValues);
        //2. register beanDefinition
        factory.registerBeanDefinition("service",serviceBeanDefinition);
        factory.registerBeanDefinition("userDao",daoBeanDefinition);

        UserServiceV1 service = (UserServiceV1) factory.getBean("service");

        UserDao dao = (UserDao) factory.getBean("userDao");
        assertEquals(service.getUserDao(),dao);
        service.queryInfo();



    }
}
