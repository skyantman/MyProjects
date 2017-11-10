package com.yundongjia.oa.utils;

import java.text.DecimalFormat;

/**
 * Created by ltlxy on 2016/7/27.
 */
public class BodyfatUtil {

    /**
     * 计算肌肉量
     * @param weight
     * @param bodyfat
     * @param bone
     * @return
     */
    public static String calculateMm(String weight,String bodyfat,String bone){
        String result = "";
        DecimalFormat df = new DecimalFormat("0.0");
        result = df.format(Double.parseDouble(weight) - (Double.parseDouble(weight) * Double.parseDouble(bodyfat) * 0.01) - Double.parseDouble(bone)) + "";
        return result;
    }




}
