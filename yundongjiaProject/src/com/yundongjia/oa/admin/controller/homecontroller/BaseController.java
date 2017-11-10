package com.yundongjia.oa.admin.controller.homecontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.xml.internal.ws.developer.StreamingAttachment;
import com.yundongjia.app.user.service.AppConfigService;
import com.yundongjia.app.user.service.AppPayService;
import com.yundongjia.app.user.service.AppStudioConsumeOrderRecordService;
import com.yundongjia.app.user.service.PayOrderService;
import com.yundongjia.app.user.service.impl.AliPayPaymentServiceImpl;
import com.yundongjia.app.user.service.impl.WeChatPayServiceImpl;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TPrivateLessonTime;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.UserVo;
import com.yundongjia.oa.utils.RSAUtils;
import com.yundongjia.oa.utils.httpsutils.HttpsMockBase;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by ltlxy on 2016/9/22.
 */
public class BaseController extends HttpsMockBase {
	@Autowired
	private PayOrderService payOrderService; 
	@Autowired
    private  AppConfigService appConfigService;
	@Autowired
	private AppPayService appPayService;
	@Autowired
	private AliPayPaymentServiceImpl aliPayPaymentServiceImpl;
	@Autowired
	private WeChatPayServiceImpl weChatPayServiceImpl;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;

	protected SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwgjKVPAoi0bWrstMhKv2PXEdV8U//6EuH0qIsV+2M2LjFw7kO3Xly4DM4NoIP/N1H41Fw5fK6EGe928j3GNzBHpN4NNHWNejrxa5v2a19cBbIaFBdplex+erZKliXE+tBjJa2PrtkbFahYPdeetHXNqV/0rWTxF+fv/3mzvBQzQIDAQAB";
	protected static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALCCMpU8CiLRtauy0yEq/Y9cR1XxT//oS4fSoixX7YzYuMXDuQ7deXLgMzg2gg/83UfjUXDl8roQZ73byPcY3MEek3g00dY16OvFrm/ZrX1wFshoUF2mV7H56tkqWJcT60GMlrY+u2RsVqFg91560dc2pX/StZPEX5+//ebO8FDNAgMBAAECgYApNPwiIvYq0tKa1xC7OZIgmeZ9heyrTcv0VZROzehDbYUVhm/5rHLiAr1ybidHHD18vvEQbl6QWaweguUT6tX+THX00JvGCAJ2T2CO4Vz9V1ZkB0OsHdZR18c+lKa0RxbkZ8Q2wfYvX1Q25nK77saGVcZBw+0Yb/iNepnv73JqgQJBAOJgqvpk/uMJM7IKCEYSk8OqeC5OUqutmuqhFLT1OVwtVxQ0x/1D5iGOFWfrlZFnRn0oPAOmNqA9bjtHsICtvQUCQQDHmvzFbMwEOaGxJJnf1qJjvmC66qDfc2pIflVcEV0V205IUVtyLLZaQC1KvOdWvFU4cSiZeDvtTYngrkWtDs8pAkA//S03XCcETAyVzeoqzIOCMoSIKlGJ/6ejnOa6g/qzyIktyAGj4HaDk6MPXfNIR5YQOLhGG8yjHNo03X3R0cp1AkBoPq5yoR5vunWSoU3nlB3dP8ke9XitGobQc4I7Aip+Rrm8lRjQKT/XJJtC5CNhrhxHzPlqJVwO1CcE+58SAaD5AkEA2sBEjHId2JjT1E5gA/I2a9gRr7cVYfIxhodMH2GdL/wwEB2sJmF541nqyyQWhSiHrDWsaS/UFnpcvVYoEGLwmw==";

	public static final Integer PAGE_ROW = 20;
	public static final Integer PAGE_ROW_5 = 5;

	protected JSONObject jsonObject = new JSONObject();
	protected JSONObject jsonObject2 = new JSONObject();
	protected JSONArray jsonArray = new JSONArray();
	protected JSONArray jsonArray2 = new JSONArray();

	protected Integer getLogUserId() {
		UserVo userVo = (UserVo) session.getAttribute("userVo");
		return userVo.getUser().getBackuserid();
	}
	/**
	* Title: BaseController.java
	* Description: 获得企业ID
	* @return
	* @author HuangJian
	* @date 2017年4月18日
	*/
	protected Integer getEnterPriseId(){
		UserVo userVo = (UserVo) session.getAttribute("userVo");
		return userVo.getEnterpriseUser().getEnterpriseid();
	}
	@ModelAttribute
	public void initController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	protected void jsonclear() {
		jsonArray.clear();
		jsonObject.clear();
		jsonObject2.clear();
		jsonArray2.clear();
	}

	protected void writeJSONStr(String str) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = this.response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(str);
	}

	protected void writeJSONPStr(String str, String call) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.print("" + call + "(" + str + ")");
			out.flush();
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @Title: RSAprivatedecode @Description: TODO(私钥解密) @param @param
	 * str @param @return 设定文件 @return String 返回类型 @throws
	 */
	protected Map<String, Object> RSAprivatedecode(String str) {// 接收一个公钥加密的字符串，利用私钥进行解密
		str = str.replace(" ", "+");
		byte[] test = Base64.decode(str);
		byte[] decodedData = null;
		try {
			decodedData = RSAUtils.decryptByPrivateKey(test, privateKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String target = new String(decodedData);
		System.out.println("target=" + target);
		JSONObject jasonObject = JSONObject.fromObject(target);
		Map<String, Object> map = (Map<String, Object>) jasonObject;
		return map;// 解密后的文字
	}

	/**
	 * 
	 * @Title: RSAencode @Description: TODO(私钥加密) @param @param str 设定文件 @return
	 * void 返回类型 @throws
	 */
	protected void RSAprivateencode(String str) {// 接收一个字符串，利用私钥进行加密
		System.out.println("str=" + str);
		byte[] encodedData = null;
		try {
			encodedData = RSAUtils.encryptByPrivateKey(str.toString().getBytes(), privateKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(new String(encodedData));
		String reaStr = Base64.encode(encodedData);
		JSONObject json1 = new JSONObject();
		json1.put("str", reaStr);
		writeJSONStr(json1.toString());// 加密后的文字
	}

	/**
	 * 
	 * @Title: RSAprivatedecode @Description: TODO(公钥解密) @param @param
	 * str @param @return 设定文件 @return String 返回类型 @throws
	 */
	protected String RSApublicdecode(String str) {// 接收一个公钥加密的字符串，利用私钥进行解密
		str = str.replace(" ", "+");
		byte[] test = Base64.decode(str);
		byte[] decodedData = null;
		try {
			decodedData = RSAUtils.decryptByPublicKey(test, publicKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String target = new String(decodedData);
		return target;// 解密后的文字
	}

	/**
	 * 
	 * @Title: RSAencode @Description: TODO(公钥加密) @param @param str 设定文件 @return
	 * void 返回类型 @throws
	 */
	protected void RSApublicencode(String str) {// 接收一个字符串，利用私钥进行加密
		byte[] encodedData = null;
		try {
			encodedData = RSAUtils.encryptByPublicKey(str.toString().getBytes(), publicKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(encodedData));
		String reaStr = Base64.encode(encodedData);
		JSONObject json1 = new JSONObject();
		json1.put("str", reaStr);
		writeJSONStr(json1.toString());
		;// 加密后的文字
	}

	protected Map<String, String> findParam(String str) {
		String[] strs = str.split("\\|");
		Map<String, String> m = new HashMap<String, String>();
		for (String s : strs) {
			String[] ms = s.split("=");
			m.put(ms[0], ms[1]);
		}

		return m;
	}
    
	protected  String selectConfigVal(String str) {
		List<String> list = appConfigService.getConfigValueByName(str);
		String m = list.get(0);

		return m;
	}

}
