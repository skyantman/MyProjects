package com.yundongjia.oa.realm;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;
/**
 * 
* Title:com.yundongjia.oa.realm 
* Description:处理多个reaml
* @author HuangJian
* @date 2016年11月9日
 */
public class ModularRealmAuthenticator extends org.apache.shiro.authc.pam.ModularRealmAuthenticator{

	
	@Override
	protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> realms, AuthenticationToken token) {
		
		AuthenticationStrategy strategy= getAuthenticationStrategy();
		
		AuthenticationInfo aggregate=strategy.beforeAllAttempts(realms, token);
		
		for(Realm realm:realms){
			aggregate  = strategy.beforeAttempt(realm, token, aggregate);
			if(realm.supports(token)){
				AuthenticationInfo info = null;  
                Throwable t = null;  
                try {  
                    info = realm.getAuthenticationInfo(token);  
                } catch (Throwable throwable) {  
                    t = throwable;  
                } 
                aggregate=strategy.afterAttempt(realm, token, info, aggregate, t);
             // dirty dirty hack  
                if (aggregate != null && !CollectionUtils.isEmpty(aggregate.getPrincipals())) {  
                    return aggregate;  
                }else{
                	
                }  
                // end dirty dirty hack 
                
                
			}else{
				
			}
		}
		aggregate=strategy.afterAllAttempts(token, aggregate);
		return aggregate;
	}
}
