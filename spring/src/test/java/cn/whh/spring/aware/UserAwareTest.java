package cn.whh.spring.aware;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAwareTest {
    private final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("quickstart-byName.xml");

    @Test
    public void testAware(){
        UserAware whh = (UserAware) applicationContext.getBean("whh");
        System.out.println("whh = " + whh.toString());
        NormalUser bean = applicationContext.getBean(NormalUser.class);
        System.out.println("bean = " + bean.toString());


    }
}
