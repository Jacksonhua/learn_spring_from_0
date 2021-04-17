import cn.whh.spring.dl.bean.Person;
import cn.whh.spring.dl.bean.Student;
import cn.whh.spring.dl.bean.set.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Artermus wang on 2021-04-17 15:38
 */
@Slf4j
public class Test1 {
    private BeanFactory beanFactory = new ClassPathXmlApplicationContext("quickstart-byName.xml");

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

}
