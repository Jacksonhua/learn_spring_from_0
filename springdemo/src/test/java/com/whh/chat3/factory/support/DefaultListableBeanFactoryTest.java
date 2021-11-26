package com.whh.chat3.factory.support;

import com.whh.beans.UserService;
import com.whh.beans.UserServiceV1;
import com.whh.chat3.factory.config.BeanDefinition;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class DefaultListableBeanFactoryTest {
    @Test
    public void test(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserServiceV1.class);
        factory.registerBeanDefinition("user",beanDefinition);
        UserServiceV1 bean = (UserServiceV1) factory.getBean("user", "wang");
        bean.queryInfo();
    }
    @Test
    public void test_no_agr() throws IllegalAccessException, InstantiationException {
        Class<UserService> baseClass = UserService.class;
        UserService o = baseClass.newInstance();
        o.queryInfo();

    }
    @Test
    public void test_agr() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<UserServiceV1> serviceV1Class = UserServiceV1.class;


        Constructor<UserServiceV1> declaredConstructor = serviceV1Class.getDeclaredConstructor(String.class);
        UserServiceV1 o = declaredConstructor.newInstance("wang");
        o.queryInfo();
        //获取所有构造器
        Constructor<?>[] declaredAnnotations = serviceV1Class.getDeclaredConstructors();
        Constructor<?> declaredAnnotation = declaredAnnotations[0];
        Constructor<UserServiceV1> declaredConstructor1 = serviceV1Class.getDeclaredConstructor(declaredAnnotation.getParameterTypes());
        declaredConstructor1.newInstance("wang1").queryInfo();

    }
    @Test
    public void cglib(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceV1.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        UserServiceV1 o = (UserServiceV1) enhancer.create(new Class[]{String.class}, new String[]{"whh"});
        o.queryInfo();

//        Enhancer enhancer1 = new Enhancer();
//        enhancer1.setSuperclass(UserService.class);
//        enhancer.setCallback(new NoOp() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//        });
//        UserService o1 = (UserService) enhancer1.create();
//        o1.queryInfo();

    }

}
