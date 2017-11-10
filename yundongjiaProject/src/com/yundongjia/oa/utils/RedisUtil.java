package com.yundongjia.oa.utils;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by ltlxy on 2016/9/7.
 */
public class RedisUtil {



    @Resource(name="jedisPool")
    private static JedisPool jedisPool;

    private static Logger LOG = Logger.getLogger(RedisUtil.class);
    /**
     * 获得redis连接池
     */
    static{
        jedisPool = (JedisPool) ContextUtil.getBean("jedisPool");
    }

    /**
     * @author liutao
     * 2016年6月28日  上午9:48:19
     * describe  :
     * 向redis添加一个map
     * @param mapKey
     * @param map
     * @return
     */
    public static String mapPut(String mapKey,Map<String,String> map){
        Jedis jedis=getJedis();
        String result = jedis.hmset(mapKey,map);
        System.out.println(result);

        return result;
    }

    /**
     * 向redis中添加一对key  value
     * @param key
     * @param value
     * @return
     */
    public static String set(String key,String value){
        Jedis jedis=getJedis();
        String result = jedis.set(key, value);
        returnResource(jedis);
        return result;
    }


    /**
     * 设置保存固定时间的key val
     * @param key
     * @param sec
     * @param value
     * @return
     */
    public static String setex(String key,int sec,String value){
        Jedis jedis=getJedis();
        String result = jedis.setex(key, sec,value);
        returnResource(jedis);
        return result;
    }



    /**
     * 从redis中删除
     * @param keys
     * @return
     */
    public static Long del(String keys){
        Jedis jedis=getJedis();
        Long result = jedis.del(keys);
        returnResource(jedis);
        return result;
    }

    /**
     * 获得缓存中的配置
     * @param key
     * @return
     */
    public static String get(String key){
        Jedis jedis=getJedis();
        if(jedis.exists(key)){
            String value = jedis.get(key);
            returnResource(jedis);
            return value;
        }else{
            returnResource(jedis);
            return null;
        }

    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public static boolean exists(String key){
        Jedis jedis=getJedis();
        boolean res = jedis.exists(key);
        returnResource(jedis);
        return res;
    }

    /**
     * 返回jedis连接
     * @param
     * @param redis
     */
    public static void returnResource( Jedis redis) {
        if(jedisPool == null){
            LOG.error("redis连接池为null");

        }
        if (redis != null) {
            jedisPool.returnResource(redis);
        }
    }



    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }






}
