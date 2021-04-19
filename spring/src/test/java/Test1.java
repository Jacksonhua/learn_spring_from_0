import cn.whh.spring.dl.bean.Person;
import cn.whh.spring.dl.bean.Student;
import cn.whh.spring.dl.bean.annotation.Color;
import cn.whh.spring.dl.bean.set.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @description:
 * @author: Artermus wang on 2021-04-17 15:38
 */
@Slf4j
public class Test1 {
    private BeanFactory beanFactory = new ClassPathXmlApplicationContext("quickstart-byName.xml");
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("quickstart-byName.xml");

    /**
     * 使用别名getBean
     */
    @Test
    public void readConfigCreateBean(){

        Person person = (Person) beanFactory.getBean("person");

        System.out.println("person = " + person);
    }

    /**
     * 使用类名get bean
     */
    @Test
    public void readConfigCreateBeanWithoutConvert(){

        Student student = beanFactory.getBean(Student.class);
        System.out.println("student = " + student);
    }
    /**
     * 使用类名get bean
     */
    @Test
    public void readConfigCreateBeanWithSet(){

        Person master = beanFactory.getBean(Person.class);
        Cat cat = beanFactory.getBean(Cat.class);
        log.info("master :{}",master);
        log.info("cat :{}",cat);
    }
    /**
     * 使用注解 get bean
     *
     * s = cn.whh.spring.dl.bean.annotation.Red@4206a205
     * s = cn.whh.spring.dl.bean.annotation.Black@29ba4338
     */
    @Test
    public void readConfigCreateBeanWithAnnotation(){

        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Color.class);
        beansWithAnnotation.forEach(((s, o) ->
            System.out.println("s = " + o)
        ));
    }
    /**
     * 获取所有bean
     */
    @Test
    public void getAllBeans(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
    /**
     * 查看是否包含bean
     */
    @Test
    public void findContainBean(){
        boolean student = applicationContext.containsBean("student");
        System.out.println("student = " + student);
    }

}
