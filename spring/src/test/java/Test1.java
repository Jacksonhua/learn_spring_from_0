import cn.whh.spring.dl.bean.Person;
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
    @Test
    public void readConfigCreateBean(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("quickstart-byName.xml");
        Person person = (Person) beanFactory.getBean("person");
        System.out.println("person = " + person);
    }

}
