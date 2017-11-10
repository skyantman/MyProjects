package com.yundongjia.app.wechatPay.Utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.yundongjia.app.user.service.impl.WeChatPayServiceImpl;

import net.sf.json.JSONObject;

/**
 * 微信支付签名
 * @author iYjrg_xiebin
 * @date 2015年11月25日下午4:47:07
 */
public class WXSignUtils {
	//http://mch.weixin.qq.com/wiki/doc/api/index.php?chapter=4_3
	//商户Key：改成公司申请的即可
	//32位密码设置地址：http://www.sexauth.com/  jdex1hvufnm1sdcb0e81t36k0d0f15nc
	private static String Key = WeChatPayServiceImpl.Key;//公众号f3d7c521452d442a2a19de0d97297475开放平台秘钥85361679bb8bc0aef6f79cb15ab2f92f商户号为1292632601API秘钥ahTk5908FHbvcy0824ASDqoi9222eaXZ商户号为1347229201 的API秘钥FF564096ghv5HBVPOK870056FVC76124
	public static String API_KEY=WeChatPayServiceImpl.API_KEY; // 
	/**
	 * 微信支付签名算法sign
	 * @param characterEncoding
	 * @param parameters
	 * @return
	 */
	public static String createSign(String characterEncoding,SortedMap<String,Object> parameters){  
        StringBuffer sb = new StringBuffer();  
        Set es = parameters.entrySet();  
        Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            Object v = entry.getValue();  
            if(null != v && !"".equals(v)  
                    && !"sign".equals(k) && !"key".equals(k)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
        sb.append("key=" + API_KEY);  
        System.out.println("字符串拼接后是："+sb.toString());  
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
        return sign;  
    }  

	
	
	 /**
     * 
    * @Title: createSignAgain 
    * @Description: TODO(获取prepay_id，二次签名发送结果给app) 
    * @param @param request
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static JSONObject createSignAgain(HttpServletRequest request,String prepayid,String noncestr){
		JSONObject jsonObject = new JSONObject();  
		SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();  
		parameterMap.put("appid", WeChatPayServiceImpl.APPID);  
		parameterMap.put("partnerid", WeChatPayServiceImpl.MCH_ID);  
		parameterMap.put("prepayid", prepayid);  
		parameterMap.put("package", "Sign=WXPay");  
		parameterMap.put("noncestr", noncestr);  
		parameterMap.put("timestamp", System.currentTimeMillis()/1000);  
		String sign = createSign("UTF-8", parameterMap);  
		parameterMap.put("sign", sign);  
		jsonObject.put("parameterMap",parameterMap);
		System.out.println("jsonObject=**"+jsonObject.toString());
		System.out.println("sign=**"+jsonObject.get("parameterMap"));
		JSONObject signtemp = (JSONObject) jsonObject.get("parameterMap");
		return signtemp;  
    } 
    
    
    /**
     * 
    * @Title: verifyWeixinNotify 
    * @Description: TODO(微信返回消息的签名验证) 
    * @param @param map
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
     */
    public boolean verifyWeixinNotify(Map<Object, Object> map) {  
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();  
        String sign = (String) map.get("sign");  
        for (Object keyValue : map.keySet()) {  
            if(!keyValue.toString().equals("sign")){  
                parameterMap.put(keyValue.toString(), map.get(keyValue));  
            }  
        }  
        String createSign = WXSignUtils.createSign("UTF-8", parameterMap);  
        if(createSign.equals(sign)){  
            return true;  
        }else{  
            return false;  
        }  
    }  
	

}
