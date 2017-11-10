package com.yundongjia.other.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TLineActivityCount;
import com.yundongjia.oa.utils.CommonUtil;
import com.yundongjia.oa.utils.GetWxOrderno;
import com.yundongjia.oa.utils.RequestHandler;
import com.yundongjia.oa.utils.SendMessage;
import com.yundongjia.oa.utils.Sha1Util;
import com.yundongjia.oa.utils.TenpayUtil;
import com.yundongjia.other.service.LineactivitycountService;

import net.sf.json.JSONObject;


@Controller
public class WeChartActivity170308 extends BaseController{
	@Autowired
	private LineactivitycountService lineactivitycountService;
	/**
	 * @param request
	 * 获取用户微信授权
	 * @throws IOException 
	 */
	@RequestMapping("ydj/other/wechartImpower")
	public void wechartImpower(HttpServletRequest request , HttpServletResponse response) throws IOException{
		Cookie cookie = new Cookie("loginHTMLStatus", "1");
        response.addCookie(cookie);
		//共账号及商户相关参数
		String appid = "wx650fbf09c81332f2";
		//String backUri ="http://192.168.1.105:8020/ydjActive_2/index.html";
		String backUri = "http://www.goheng.com/ad/gohengpages/leagueweixin/ydjActive_2/index.html";
		//授权后要跳转的链接所需的参数一般有会员号，金额，订单号之类，
		//最好自己带上一个加密字符串将金额加上一个自定义的key用MD5签名或者自己写的签名,
		//比如 Sign = %3D%2F%CS% 
		String orderNo=appid+Sha1Util.getTimeStamp();
		//URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
		backUri = URLEncoder.encode(backUri);
		//scope 参数视各自需求而定，这里用scope=snsapi_base 不弹出授权页面直接授权目的只获取统一支付接口的openid
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
				"appid=" + appid+
				"&redirect_uri=" +
				 backUri+
				"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		response.sendRedirect(url);
	}
	
	@RequestMapping("ydj/other/wechartOrder")
	@ResponseBody
	public void wechartOrder(HttpServletRequest request , HttpServletResponse response , Integer buynum , String phone , String orderNo , String price , String code , String name){
		  //将报名活动的手机号存入数据库
		  TLineActivityCount tLineActivityCount = new TLineActivityCount();
		  tLineActivityCount.setMobilephonenos(phone);
		  tLineActivityCount.setPrices(Double.parseDouble(price));
		  tLineActivityCount.setPaytype("00");
		  tLineActivityCount.setActivityname("三月绿色版本高端健身趴");
		  tLineActivityCount.setStatus(0);
		  tLineActivityCount.setBuynum(buynum);
		  tLineActivityCount.setMembername(name);
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  tLineActivityCount.setCreatedate(simpleDateFormat.format(new Date()));
		  tLineActivityCount.setPrices(Double.parseDouble(price));
		  Map<String ,Object>  mapParam = new HashMap<String ,Object>();
		  Integer linId = 0;
		  try{
			  Integer resultinfo = lineactivitycountService.insertSelective(tLineActivityCount);
			  System.out.println(resultinfo);
			  if(resultinfo != 0){
				  linId = resultinfo;
			  }
		  }catch(Exception e){
			  e.printStackTrace();
			  mapParam.put("result", false);
			  mapParam.put("message", "报名活动手机号存储异常！");
			  this.writeJSONPStr(new Gson().toJson(mapParam), "callback");
		  }
		  //商户相关资料 
		  	String appid2 = "";
		  	String timestamp = "";
		  	String nonceStr2 = "";
		  	String prepay_id2 = "";
		  	String packages = "";
		  	String finalsign = "";
		  	int sessionmoney = 1;
			String appid = "wx650fbf09c81332f2";
			String appsecret = "f3d7c521452d442a2a19de0d97297475";
			String openid = "";
			try {
						String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
						System.out.println("appid--------------------------------" + appid);
						System.out.println("secret--------------------------------" + appsecret);
						System.out.println("code--------------------------------" + code);
						JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
					if (null != jsonObject ) {
						if( jsonObject.containsKey("openid")){
							 openid = jsonObject.getString("openid");
							 request.getSession().setAttribute("openid", openid);
						}else{
							openid = request.getSession().getAttribute("openid").toString();
						}
						
					}
					     
					//金额转化为分为单位
					sessionmoney = (int) (Float.parseFloat(price) * 100);
					//商户相关资料 
					String partner = "1292632601";
					String partnerkey = "123qweQHJGCB698091asdbcnAAQQdcou";
					//获取openId后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder
					String currTime = TenpayUtil.getCurrTime();
					//8位日期
					String strTime = currTime.substring(8, currTime.length());
					//四位随机数
					String strRandom = TenpayUtil.buildRandom(4) + "";
					//10位序列号,可以自行调整。
					String strReq = strTime + strRandom;
					
					
					//商户号
					String mch_id = partner;
					//子商户号  非必输
					//String sub_mch_id="";
					//设备号   非必输
					String device_info="";
					//随机数 
					String nonce_str = strReq;
					//商品描述
					//String body = describe;
					
					//商品描述根据情况修改
					String body = "运动+ 高端健身趴";
					//附加数据
					String attach = "";
					//商户订单号
					String out_trade_no = orderNo;
					//总金额以分为单位，不带小数点
					int total_fee = sessionmoney;
					//订单生成的机器 IP
					String spbill_create_ip = request.getRemoteAddr();
					//订 单 生 成 时 间   非必输
//							String time_start ="";
					//订单失效时间      非必输
//							String time_expire = "";
					//商品标记   非必输
//							String goods_tag = "";
					
					//这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
					String notify_url ="http://www.1jkt.com/notifyServlet";
					
					String trade_type = "JSAPI";
					//非必输
//							String product_id = "";
					SortedMap<String, String> packageParams = new TreeMap<String, String>();
					packageParams.put("appid", appid);  
					packageParams.put("mch_id", mch_id);  
					packageParams.put("nonce_str", nonce_str);  
					packageParams.put("body", body);  
					packageParams.put("attach", attach);  
					packageParams.put("out_trade_no", out_trade_no);  
					
					
					//这里写的金额为1 分到时修改
					//packageParams.put("total_fee", "1");  
					packageParams.put("total_fee", sessionmoney+"");  
					packageParams.put("spbill_create_ip", spbill_create_ip);  
					packageParams.put("notify_url", notify_url);  
					
					packageParams.put("trade_type", trade_type);  
					packageParams.put("openid", openid);  
					
					// RequestHandler：微信支付服务器签名支付请求请求类
					RequestHandler reqHandler = new RequestHandler(request, response);
					reqHandler.init(appid, appsecret, partnerkey);
					
					// 创建md5摘要
					String sign = reqHandler.createSign(packageParams);
					String xml="<xml>"+
							"<appid>"+appid+"</appid>"+
							"<mch_id>"+mch_id+"</mch_id>"+
							"<nonce_str>"+nonce_str+"</nonce_str>"+
							"<sign>"+sign+"</sign>"+
							"<body><![CDATA["+body+"]]></body>"+
							"<attach>"+attach+"</attach>"+
							"<out_trade_no>"+out_trade_no+"</out_trade_no>"+
							//金额，这里写的1 分到时修改
							//"<total_fee>"+1+"</total_fee>"+
							"<total_fee>"+sessionmoney+"</total_fee>"+
							"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
							"<notify_url>"+notify_url+"</notify_url>"+
							"<trade_type>"+trade_type+"</trade_type>"+
							"<openid>"+openid+"</openid>"+
							"</xml>";
					System.out.println(xml);
					String allParameters = "";
					try {
						// 获取package的签名包
						allParameters =  reqHandler.genPackage(packageParams);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 统一支付接口url
					String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
					String prepay_id="";
					try {
						prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
						if(prepay_id.equals("")){
							request.setAttribute("ErrorMsg", "统一支付接口获取预支付订单出错");
							response.sendRedirect("error.jsp");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					SortedMap<String, String> finalpackage = new TreeMap<String, String>();
					appid2 = appid;
					// 获取当前时间戳
					timestamp = Sha1Util.getTimeStamp();
					// 随机数
					nonceStr2 = nonce_str;
					// 预支付ID
					prepay_id2 = "prepay_id="+prepay_id;
					packages = prepay_id2;
					finalpackage.put("appId", appid2);  
					finalpackage.put("timeStamp", timestamp);  
					finalpackage.put("nonceStr", nonceStr2);  
					finalpackage.put("package", packages);  
					// 签名类型
					finalpackage.put("signType", "MD5");
					finalsign = reqHandler.createSign(finalpackage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}finally {
				mapParam.put("lineid", linId);
				mapParam.put("result", true);
				mapParam.put("message", "支付成功！");
				mapParam.put("appid", appid2);
				mapParam.put("timeStamp", timestamp);
				mapParam.put("nonceStr", nonceStr2);
				mapParam.put("package", packages);
				mapParam.put("sign", finalsign);
				mapParam.put("orderNo", orderNo);
				mapParam.put("money", sessionmoney);
				this.writeJSONPStr(new Gson().toJson(mapParam), "callback");
			}
	  }
	
	@RequestMapping("ydj/other/updatePayStatus")
	@ResponseBody
	public void updatePayStatus(Integer lineid ){
		TLineActivityCount tLineActivityCount = new TLineActivityCount();
		tLineActivityCount.setLineid(lineid);
		tLineActivityCount.setStatus(1);
		int result = lineactivitycountService.updateByPrimaryKeySelective(tLineActivityCount);
		Map<String, Object> map = new HashMap<String, Object>();
		if(result == 0){
			map.put("result", false);
			map.put("message", "支付成功后更新支付状态失败!【lineid】");
			this.writeJSONPStr(new Gson().toJson(map), "callback");
		}else if(result > 0){
			map.put("result",true);
			map.put("message", "支付成功");
			this.writeJSONPStr(new Gson().toJson(map), "callback");
		}else{
			map.put("result", false);
			map.put("message", "支付成功后更新支付状态失败!【lineid】");
			this.writeJSONPStr(new Gson().toJson(map), "callback");
		}
	}
	
	@RequestMapping("ydj/other/lineActiveInsert")
	@ResponseBody
	public void lineActiveInsert(String company , String phone , String name , String joinType ,String activityName , Double prices,
			String payType , Integer buyNum , Integer type){
		TLineActivityCount tLineActivityCount = new TLineActivityCount();
		tLineActivityCount.setMobilephonenos(phone);
		tLineActivityCount.setMembername(name);
		tLineActivityCount.setPrices(prices);
		tLineActivityCount.setPaytype(payType);
		tLineActivityCount.setCreatedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		tLineActivityCount.setActivityname(activityName);
		tLineActivityCount.setBuynum(buyNum);
		tLineActivityCount.setCompanyname(company);
		tLineActivityCount.setJointype(joinType);
		tLineActivityCount.setType(type);
		tLineActivityCount.setStatus(0);
		int result = lineactivitycountService.insertSelective(tLineActivityCount);
		Map<String, Object> map = new HashMap<String, Object>();
		if(result == 0){
			map.put("result", false);
			map.put("message", "系统异常，请稍后尝试！");
			this.writeJSONPStr(new Gson().toJson(map), "callback");
		}else{
			map.put("result", true);
			map.put("message", "恭喜您，报名成功！");
			List<TLineActivityCount> sum = lineactivitycountService.selectSumInfo(2,0);
			int san = 0;
			int wu = 0;
			for (TLineActivityCount tl : sum) {
				if("5V5".equals(tl.getJointype())){
					wu++;
				}
				if("3V3".equals(tl.getJointype())){
					san++;
				}
			}
			SendMessage.sendAppointmentMessage("18610924981","篮球对抗赛----新增报名企业【"+ company +"】,报名者信息【"+name+"-"+phone+"】,目前报名3v3企业有"+san+"家，报名5v5企业有"+wu+"家。");
			this.writeJSONPStr(new Gson().toJson(map), "callback");
		}
	}
}
