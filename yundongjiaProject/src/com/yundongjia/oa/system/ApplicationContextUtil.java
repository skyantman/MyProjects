package com.yundongjia.oa.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.yundongjia.oa.utils.ContextUtil;

/**
 * Created by ltlxy on 2016/9/7.
 */
@Repository
@Scope
public class ApplicationContextUtil implements ApplicationContextAware {




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtil.setApplicationContext(applicationContext);
//        System.out.println("我在aware中被执行了");
    }



}
