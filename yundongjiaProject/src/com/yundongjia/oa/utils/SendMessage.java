package com.yundongjia.oa.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class SendMessage {

	private static String ip ;
	private static String username ;
	private static String userpass ;
	
	static{
		ip = "http://115.28.112.245:8082/SendMT/SendMessage";
		username = "gouheng";
		userpass = "goheng0824";
	}

	public static void getPro(){
		ip = "http://115.28.112.245:8082/SendMT/SendMessage";
		username = "gouheng";
		userpass = "goheng0824";

    }
	
	//以get方式发送验证码
	public static String httpGetSend(String snedUrl,String encoded){
		String urlPath = snedUrl;
		StringBuffer sbf = new StringBuffer("");
		BufferedReader reader = null;
		HttpURLConnection uc = null;

		try {
			URL url = new URL(urlPath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setConnectTimeout(30000);
			uc.setReadTimeout(30000);
			uc.setRequestMethod("GET");
			uc.setDoOutput(true);
			uc.setDoInput(true);

			uc.connect();
			reader = new BufferedReader(new InputStreamReader(
					uc.getInputStream())); // 读取服务器响应信息
			String line;
			while ((line = reader.readLine()) != null) {
				sbf.append(line);
			}
			reader.close();
			uc.disconnect();
			return sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public static String sendMessage(String mobilePhoneNo, String vercode, Integer codeType) {
        getPro();
		String data = "";
		String s = "";
		try {
			//尊敬的用户，您的验证码123445，本验证码5分钟内有效，感谢您的使用
			switch (codeType) {
			case 1://用户注册验证码
				s = "【"+ vercode +"】（运动+ 注册验证码，请勿泄露）有效期5分钟。";
				break;
			case 2://登录
				s = "【"+ vercode +"】（运动+ 登录验证码，请勿泄露）有效期5分钟。";
				break;
			case 3://找回密码
				s = "【"+ vercode +"】（您正在手机找回运动+密码，请勿泄露）有效期5分钟。";
				break;
			default:
				break;
			}
			String content = s; // 发送内容
			String mobile = mobilePhoneNo; // 手机号
			String Subid = ""; // 扩展号
			content = URLEncoder.encode(content, "UTF-8");

			data = httpGetSend(ip + "?" + "UserName=" + username + "&UserPass="
					+ userpass + "&Content=" + content + "&Mobile=" + mobile
					+ "&Subid=" + Subid, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
	
	public static String sendAppointmentMessage(String mobilePhoneNo, String message) {
        getPro();
		String data = "";
		try {
			String s = new String(message);
			/*
			 IP = "http://115.28.112.245:8081/SendMT/SendMessage";
			 UserName = "gouheng"; // 用户名
			 UserPass = "gh123456"; // 密码
			 */
			String content = s; // 发送内容
			String mobile = mobilePhoneNo; // 手机号
			String Subid = ""; // 扩展号
			content = URLEncoder.encode(content, "UTF-8");
			data = httpGetSend(ip + "?" + "UserName=" + username + "&UserPass="
					+ userpass + "&Content=" + content + "&Mobile=" + mobile
					+ "&Subid=" + Subid, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	
}
