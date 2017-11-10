package com.yundongjia.oa.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;

/**
 * Created by ltlxy on 2016/9/18.
 */
@Repository
@Scope("singleton")
public class LoaderListener extends AbstractLoaderListenerSupport {

    @Autowired
    private JedisPool jedisPool;

    @Override
    protected void onApplicationEventStart(ContextRefreshedEvent event) {
        System.out.println("======================初始化系统配置======================");
        System.out.println(jedisPool);
        System.out.println("====================初始化系统配置完成====================");
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
