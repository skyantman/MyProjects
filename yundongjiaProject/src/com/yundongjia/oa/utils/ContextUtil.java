package com.yundongjia.oa.utils;

import org.springframework.context.ApplicationContext;

/**
 * Created by ltlxy on 2016/9/7.
 */
public class ContextUtil {

    private static ApplicationContext applicationContext;


    public static void setApplicationContext(ApplicationContext app){
        applicationContext = app;
//        System.out.println("我在contextutil中被执行了");
    }

    public static Object getBean(String name){

        return applicationContext.getBean(name);
    }

    public static Object getBean(String name,Class clazz){

        return applicationContext.getBean(name,clazz);
    }

}
