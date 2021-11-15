package com.whh.chat1;

import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test_register(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        //2
        beanFactory.registerBeanDefinition("user1",beanDefinition);
        UserService bean = (UserService) beanDefinition.getBean();
        bean.queryInfo();
    }

}
