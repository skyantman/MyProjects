package com.yundongjia.oa.system;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

/**
 * Created by ltlxy on 2016/9/18.
 */
@Repository("authorityHandlerMapping")
public class AuthorityHandlerMapping {



    private Map<String,List<String>> authorityURIMapping = new HashMap<String, List<String>>();

    private Logger LOG = Logger.getLogger(AuthorityHandlerMapping.class);

    /**
     * 初始化映射对象  authorityURLMapping
     * @param RequestMappingHandlerMapping
     * @param context
     * @throws AuthorityInitializeException
     */
    public void initAuthorityURLMapping(RequestMappingHandlerMapping RequestMappingHandlerMapping, ApplicationContext context) throws AuthorityInitializeException {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = RequestMappingHandlerMapping.getHandlerMethods();
        for (RequestMappingInfo key : handlerMethods.keySet()){
            HandlerMethod method = handlerMethods.get(key);
            //拿到了url的集合,但是不知道为什么是set,难道一个方法可以对应好几个映射???
            Set<String> patterns = key.getPatternsCondition().getPatterns();
            if (patterns.isEmpty()){
                throw new AuthorityInitializeException("initError : when get url of the method"+method+",the url is empty");
            }
            Iterator<String> iterator = patterns.iterator();
            String url = iterator.next();
            Authority methodAnnotation = method.getMethodAnnotation(Authority.class);
            if (methodAnnotation != null){
                String[] value = methodAnnotation.value();
                List<String> an = new ArrayList<String>();
                for (String s:value){
                    an.add(s);
                }
                this.authorityURIMapping.put(url,an);
                LOG.info("init authority : " + url +"--->"+an);

            }
        }
    }


    public List<String> getAuthorities(String uri){
        return this.authorityURIMapping.get(uri);
    }

    public boolean hasAuthority(String uri,String[] userAuthorities){
        List<String> need = authorityURIMapping.get(uri);
        if(need == null || need.size() == 0){
            return true;
        }
        for (String s : userAuthorities){
            if (need.contains(s)){
                return true;
            }
        }
        return false;
    }


}
