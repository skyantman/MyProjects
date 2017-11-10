package com.yundongjia.app.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
	public static String seller = "goheng@hydfkj.com";
	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088121018228685";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
		public static String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMEiU6iUG2LFlDP3AXDwuhB0/TBEc97lr3vBdptgWdkoyq+xmz7S+7FP/U3alSON07EJLf+HM4O5sMv+I0xTwcmnqvHVSSabYA0fU/YzO17D0bvBlSQVqjv8HBmMDLkOaR6YG4YCAlPzSzQuKnxa4CjsfHDa2DdaLvzLMZSl63jxAgMBAAECgYAV/7v5ws0PxiOoe6U9YR5Ai6LfYZy1MgJ4HUROVH5Hfx7/PkLJuCyVOOBIgvJj9166lqoXpiXXBkq+IbeRlSTIic75L5QOj7LvZoOqJpoBoQo3/jlOZK3LlpgfMZhDar1kBAfrWWKLuYQhww0B9B/St5a7oi614lYGhAHieCfIQQJBAOegLEPE1YxSzDak1q6Te2ds8D1CMQX3WppG7ulO0HS4hzypj+/EJnzK4TPZwQpZMEhhg3A5dXxJ5XCcQ8gw1dkCQQDVdTfzwlBzK9/GUeQUIkXz6DS/gQ2JS+wr1KAIGOw8PznKWiYJiTUtQWupqk5KmiWNHPo199CcgCL6aTLBU1TZAkBHVQ2sxTaa43jerz8qPmM3w9Xsl7DvTHELqCK1mT8bYyTK6tFYHslXj0dxp3MK09LJx7Yp3pgu8bcGSimZwmhpAkAkhKVJ4ph426yw9RmcCDEHhVZg3Oc/8ek5pmqqd/kSZY6xe7K+NucOEv8kS6qRQMXj2m1EBl1+KL3TMWQphuQhAkAfQ46/FunKYaNiKXPyAefbj36dOFvAsKg9gAgnaRKimsFH94LwSYzZzP1S/VMwkfqSMfM9Q1uCxjtp3I7oP3/+";
		
		//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
		public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

		//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="C://";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}

