package com.yundongjia.oa.system;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ltlxy on 2016/9/8.
 *
 * 权限验证拦截器
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthorityHandlerMapping authorityHandlerMapping;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(HandlerMethod.class.equals(handler.getClass())){

            HandlerMethod  method = (HandlerMethod)handler;
            String uri = request.getServletPath();
            System.out.println("访问的地址是:  "+uri);
            System.out.println("匹配的结果是:  "+authorityHandlerMapping.hasAuthority(uri,new String[]{"hehe"}));
            System.out.println("---------------------------------------");
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    public AuthorityHandlerMapping getAuthorityHandlerMapping() {
        return authorityHandlerMapping;
    }

    public void setAuthorityHandlerMapping(AuthorityHandlerMapping authorityHandlerMapping) {
        this.authorityHandlerMapping = authorityHandlerMapping;
    }
}
