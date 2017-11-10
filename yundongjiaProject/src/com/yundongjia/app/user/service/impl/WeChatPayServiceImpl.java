package com.yundongjia.app.user.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.wechatPay.Utils.HttpXmlUtils;
import com.yundongjia.app.wechatPay.Utils.ParseXMLUtils;
import com.yundongjia.app.wechatPay.Utils.RandCharsUtils;
import com.yundongjia.app.wechatPay.Utils.WXSignUtils;
import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.po.TConfigExample;

import net.sf.json.JSONObject;

/**
 * 
* @ClassName: PayCommonUtil 
* @Description: TODO(微信app支付--已投入使用) 
* @author 王立
* @date 2016年7月4日 下午1:39:39 
*
 */
@Service
public class WeChatPayServiceImpl{
	//微信参数配置  
    public static String API_KEY="FF564096ghv5HBVPOK870056FVC76124";  
    public static String APPID="wx8bb5fb9e632a6a92";  
    public static String MCH_ID="1347229201";  
	public static String Key = "FF564096ghv5HBVPOK870056FVC76124";//公众号f3d7c521452d442a2a19de0d97297475开放平台秘钥85361679bb8bc0aef6f79cb15ab2f92f商户号为1292632601API秘钥ahTk5908FHbvcy0824ASDqoi9222eaXZ商户号为1347229201 的API秘钥FF564096ghv5HBVPOK870056FVC76124
    
    
    @Autowired
    private TConfigMapper tConfigMapper;
    /**
     * @throws UnsupportedEncodingException 
     * 
    * @Title: weixinPrePay 
    * @Description: TODO(统一下单) 
    * @param @param sn  订单号
    * @param @param totalAmount 支付金额
    * @param @param description 产品描述
    * @param @param request
    * @param @return    设定文件 
    * @return Map<String,String>    返回类型 
    * @throws
     */
    public  String weixinPrePay(Map<String, Object> param ) throws UnsupportedEncodingException {  
		Map<String, Object> amap = new HashMap<String, Object>();
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>(); 
        //----------------------------- -----业务代码---------------------------------------------------
        HttpServletRequest request = (HttpServletRequest) param.get("request");
        String orderNum = (String) param.get("orderNum");//订单编号
        String description = (String)param.get("description");
        int totalAmount = (int)((Double)param.get("realPrice")*100);
			parameterMap.put("appid", WeChatPayServiceImpl.APPID);  
	        parameterMap.put("mch_id", WeChatPayServiceImpl.MCH_ID); 
	        String noncestrtemp = RandCharsUtils.getRandomString(32);
	        parameterMap.put("nonce_str", noncestrtemp);  
	        parameterMap.put("body",  description); 
	        parameterMap.put("out_trade_no", orderNum);  
	        parameterMap.put("fee_type", "CNY"); 
	        int total = totalAmount;
        TConfigExample tConfigExample = new TConfigExample();
        tConfigExample.createCriteria().andCnameEqualTo("WECHAT_SUCCESS_RETURN_FUNCTION").andStatEqualTo(1);
        String backUrl = tConfigMapper.selectByExample(tConfigExample).get(0).getCvalue();
        java.text.DecimalFormat df=new java.text.DecimalFormat("0");  
        parameterMap.put("total_fee", df.format(total));  
        parameterMap.put("spbill_create_ip", request.getRemoteAddr());  
        parameterMap.put("notify_url", backUrl);  
        parameterMap.put("trade_type", "APP"); 
        String sign = WXSignUtils.createSign("UTF-8", parameterMap);  
        parameterMap.put("sign", sign);
        String requestXML = ParseXMLUtils.getRequestXml(parameterMap);  
        String result = HttpXmlUtils.httpsRequest("https://api.mch.weixin.qq.com/pay/unifiedorder", "POST", requestXML);  
        JSONObject json = new JSONObject();
        json = ParseXMLUtils.jdomParseXml(result);
        long timestamp = System.currentTimeMillis();
        json.put("timestamp", timestamp+"");
      //二次签名开始=======================================================================
        String prepayid = json.get("prepayid").toString();
        String noncestr = json.getString("noncestr");
        JSONObject json1 = WXSignUtils.createSignAgain(request,prepayid,noncestr);
        if(json1.isEmpty()){ 
			json1.put("status", "1");
			json1.put("orderNum", param.get("orderNum"));
			json1.put("payType", param.get("payType"));
			json1.put("message", "失败");
		}else{
			json1.put("status", "0");
			json1.put("orderNum", param.get("orderNum"));
			json1.put("payType", param.get("payType"));
			json1.put("message", "成功");
		}
			return json1.toString();

    }
   
    
}
