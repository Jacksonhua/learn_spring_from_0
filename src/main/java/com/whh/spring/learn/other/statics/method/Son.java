package com.whh.spring.learn.other.statics.method;

import com.whh.spring.learn.other.statics.method.Parent;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-04-17 11:36
 */
@Slf4j
public class Son extends Parent {
    private static final String staticSting ;
    private String string1 ;
    static {
        staticSting = "staticSting";
        //Non-static field 'string1' cannot be referenced from a static context
//        string1 = "string1";
        log.info("子类中的static方法块,staticSting :{}",staticSting);
    }
    {
//        staticSting = "non_static_string";
        string1 = "Son";
        log.info("子类中的non_static方法块,staticSting :{},string1 :{}",staticSting,string1);
    }
    Son(){
//        super();
        this.string1 = "Son";
        log.info("子类中的构造函数,staticSting :{},string1 :{}",staticSting,string1);
        System.out.println(" ========= ");
    }

    public static void main(String[] args) {
        Parent.test1();
        Parent.test1();
//        new Son();
//        new Son();
    }

}
