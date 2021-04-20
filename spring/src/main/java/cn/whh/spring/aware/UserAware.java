package cn.whh.spring.aware;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @description:
 * @author: Artermus wang on 2021-04-20 11:45
 */
@Slf4j
@ToString
public class UserAware implements BeanNameAware {
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public void setBeanName(String beanName) {
        this.id = name;
    }

}
