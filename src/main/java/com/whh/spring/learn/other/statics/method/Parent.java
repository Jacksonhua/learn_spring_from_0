package com.whh.spring.learn.other.statics.method;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-04-17 11:08
 */
@Slf4j
public class Parent {
    private static  String staticSting ;
    private String string1 ;
    static {
        staticSting = "staticSting";
        //Non-static field 'string1' cannot be referenced from a static context
//        string1 = "string1";
        System.out.println("父类中的static方法块,staticSting :" + staticSting);

    }
    static void test1(){
        System.out.println(" static 方法执行" );
    }
    {
        string1 = "Parent1";
        System.out.println("父类中的non_static方法块,staticSting :" + staticSting+",string1 : " + staticSting);
    }
    Parent(){
        this.string1 = "Parent";
        System.out.println("父类中的构造函数,staticSting : " + staticSting+",string1 :"+string1);
        System.out.println("===========");
    }



    public static void main(String[] args) {
        System.out.println("父类中的main函数");
        new Parent();
        new Parent();
    }

}
