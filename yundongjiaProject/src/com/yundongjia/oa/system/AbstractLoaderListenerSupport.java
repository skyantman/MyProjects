package com.yundongjia.oa.system;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


public abstract class AbstractLoaderListenerSupport implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public final void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = (ApplicationContext) event.getSource();
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource)context.getBean("dataSource");
        try {
            initMapping(context);
            System.out.println("=======================初始化c3p0========================");
            comboPooledDataSource.getConnection();
            System.out.println("======================初始化c3p0完成======================");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        onApplicationEventStart(event);
        showLogo();
    }


    private void initMapping(ApplicationContext context) throws AuthorityInitializeException {
        System.out.println("==================初始化handlerMapping===================");
        List<HandlerMapping> handlerMappings = null;
        RequestMappingHandlerMapping requestMappingHandlerMapping = null;
        Map ex = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, HandlerMapping.class, true, false);
        if(!ex.isEmpty()) {
            handlerMappings = new ArrayList(ex.values());
            OrderComparator.sort(handlerMappings);
            for (HandlerMapping hm:handlerMappings){
                if(hm.getClass().equals(RequestMappingHandlerMapping.class)){
                    requestMappingHandlerMapping = (RequestMappingHandlerMapping)hm;
                }
            }
            createAuthorityHandlerMapping(requestMappingHandlerMapping,context);
        }
        System.out.println("================初始化handlerMapping完成=================");
    }


    private void createAuthorityHandlerMapping(RequestMappingHandlerMapping requestMappingHandlerMapping,ApplicationContext context) throws AuthorityInitializeException {
        AuthorityHandlerMapping authorityHandlerMapping = (AuthorityHandlerMapping)context.getBean("authorityHandlerMapping");
        authorityHandlerMapping.initAuthorityURLMapping(requestMappingHandlerMapping,context);
    }

    protected abstract void onApplicationEventStart(ContextRefreshedEvent event);


    private void showLogo(){
        InputStream in = null;
        try {
             in = AbstractLoaderListenerSupport.class.getClassLoader().getResource("logo.txt").openStream();
            IOUtils.copy(in,System.out);
        } catch (IOException e) {

        }finally {
            IOUtils.closeQuietly(in);
        }

    }
}