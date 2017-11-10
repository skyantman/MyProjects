package com.yundongjia.oa.utils;

import java.lang.reflect.Field;

/**
 * Created by ltlxy on 2016/7/26.
 */
public class ClassUtil {


    /**
     * 通过属性的名字获得属性的值
     *
     * @return
     */
    public static String getFieldValue(Object obj, String fieldName) {
        String result = null;

        try {
            Class<?> objClass = obj.getClass();
            Field field = objClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            result = field.get(obj).toString();
        } catch (Exception e) {
        }
        return result;
    }


}
