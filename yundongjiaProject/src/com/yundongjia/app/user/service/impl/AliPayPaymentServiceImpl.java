package com.yundongjia.app.user.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yundongjia.app.alipay.config.AlipayConfig;
import com.yundongjia.app.alipay.util.AlipayCore;
import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.po.TConfigExample;

import net.sf.json.JSONObject;

/**
 * 
* @ClassName: AliPayPaymentAction 
* @Description: TODO(支付宝支付) 
* @author Wangli
* @date 2016年11月15日 下午5:15:41 
*
 */
@Service
public class AliPayPaymentServiceImpl {
		
	  protected HttpServletRequest request;

	    protected HttpServletResponse response;

	    protected HttpSession session;
	    @Autowired
	    private TConfigMapper tConfigMapper;
	    
	/**
     * @throws UnsupportedEncodingException 
     * 
    * @Title: aliPay 
    * @Description: TODO(统一下单) 
    * @param @param orderNum  订单号
    * @param @param realPrice 支付金额
    * @param @param description 产品描述
   	*
    * @param @return    设定文件 
    * @return Map<String,String>    返回类型 
    * @throws
     */
    public  String aliPay(Map<String, Object> param) throws UnsupportedEncodingException {  
    	response = (HttpServletResponse) param.get("response");
    	JSONObject jsonObject = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");
        String out_trade_no = (String) param.get("orderNum");//商户订单号
        String  totalAmount = ((Double) param.get("realPrice")).toString();//充值金额
        String description = (String)param.get("description");//订单描述8
        TConfigExample tConfigExample = new TConfigExample();
        tConfigExample.createCriteria().andCnameEqualTo("ALIPAY_SUCCESS_RETURN_FUNCTION").andStatEqualTo(1);
        String backUrl = tConfigMapper.selectByExample(tConfigExample).get(0).getCvalue();
        // String pageInfoUrl = (String) param.get("pageInfoUrl");支付后更新订单状态为APP提供通知的url
        String orderInfo = AlipayCore.getOrderInfo("支付宝支付",description, totalAmount,out_trade_no,backUrl);
        //生成签名
		String sign = AlipayCore.sign(orderInfo, AlipayConfig.private_key);
		// 仅需对sign 做URL编码
		sign = URLEncoder.encode(sign, "UTF-8");
		//生成预付单发送给app
		String linkString = orderInfo + "&sign=\"" + sign + "\"&"+ AlipayCore.getSignType();
		  jsonObject.put("status", "0");
		  jsonObject.put("message", "成功");
		  jsonObject.put("orderNum", param.get("orderNum"));
		  jsonObject.put("payType", param.get("payType"));
		  jsonObject.put("parameterMap", linkString);
		//--------------------------------业务代码----------------------------------------------预付订单在之前已存入数据库
		//--------------------------------业务代码----------------------------------------------
		return jsonObject.toString();

    }
    
    
    
   /* public void notifyapp(){
    			JSONObject json = new JSONObject();
    	        Map<String, Object> param = getParameters();
                Map<String, Object> amap = new HashMap<String, Object>();
                String out_trade_no = (String) param.get("outtradeno");//商户订单号 
                String status = "0";
                String message = "充值成功";
                amap.put("operator", out_trade_no);
                ChargingVo cv = (ChargingVo) this.service.load(
    					"WeiXin_AppCharging.select", amap);
                if(cv != null){
                		switch (cv.getAccountType()) {
						case "01":
							status = "0";
	                		message = "充值成功";
							break;
						case "000":
							status = "1";
	                		message = "充值成功，余额更新失败，点击余额旁边的圈可以重新更新";
							break;
						case "8000":
							status = "1";
	                		message = "正在处理当中，有可能已经支付成功,请联系前台查看公司支付宝是否到账";
	                		break;
						case "4000":
							status = "1";
							message = "订单处理失败,尝试重新请求支付";
							break;
						case "5000":
							status = "1";
							message = "请不要重复请求";
							break;
						case "6001":
							status = "1";
							message = "中途取消了操作，若要充值请重试！";
							break;
						case "6002":
							status = "1";
							message = "网络连接出错,请重试";
							break;
						case "6004":
							status = "1";
							message = "支付结果未知,有可能已经支付成功,请联系前台查看公司支付宝是否到账";
						default:
							status = "1";
							message = "充值失败";
							break;
						}
                	
                	
                }else{
                	status = "1";
                	message = "用户订单异常,请到前台查询用户信息是否已经完善";
                }
                
                json.put("status", status);
                json.put("message", message);
                this.writeJSONStr(json.toString());
    }*/
    
    
    
    
}
