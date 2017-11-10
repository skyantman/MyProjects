package com.yundongjia.oa.utils;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class UtilHttpClient {

	// http get with HttpResponse
	public static String get(String url) {
		String strRet = "";
		HttpGet httpRequest = new HttpGet(url);
		try {
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				strRet = EntityUtils.toString(httpResponse.getEntity());
			} else {
				strRet = httpResponse.getStatusLine().toString();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strRet;
	}

	// http get with URLConnection
	public static String get(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);

			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();

			//Map<String, List<String>> map = connection.getHeaderFields();
			//for (String key : map.keySet()) {
			//	System.out.println(key);
			//}
			
			InputStream inputStream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
			in = new BufferedReader(reader);
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("excepiton on http get" + e);
			e.printStackTrace();
		}
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static String post(String url, String content){
		return post(url,content,"UTF-8");
	}
	
	// http get with URLConnection
	public static String post(String url, String content, String encode) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";

		try {
			URL realUrl = new URL(url);
			
	        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			conn.setDoOutput(true);
			conn.setDoInput(true);

			out = new PrintWriter(conn.getOutputStream());
			//out.print(content);
			out.flush();

			InputStream inputStream = conn.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream, encode);
			in = new BufferedReader(reader);
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			result = "";
			System.out.println("excepiton on http post" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	  /**
     * 接口调用  POST
     */
    public static String httpURLConnectionPOST (String POST_URL) {
    	 StringBuilder sb = new StringBuilder(); // 用来存储响应数据
        try {
            URL url = new URL(POST_URL);
           
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中
           
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);
           
            // 设置连接输入流为true
            connection.setDoInput(true);
           
            // 设置请求方式为post
            connection.setRequestMethod("POST");
           
            // post请求缓存设为false
            connection.setUseCaches(false);
           
            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);
           
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
           
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            connection.connect();
           
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            String parm = "storeId=" + URLEncoder.encode("32", "utf-8"); //URLEncoder.encode()方法  为字符串进行编码
           
            // 将参数输出到连接
            dataout.writeBytes(parm);
           
            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)
           
            System.out.println(connection.getResponseCode());
           
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
           
            // 循环读取流,若不到结尾处
            while ((line = bf.readLine()) != null) {
                sb.append(bf.readLine());
            }
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)
            connection.disconnect(); // 销毁连接
            System.out.println(sb.toString());
           
   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    
    public static String sendPost(String jsonStr, String path)
            throws IOException {
        byte[] data = jsonStr.getBytes();
        java.net.URL url = new java.net.URL(path);
        java.net.HttpURLConnection conn = 
        		(java.net.HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(5 * 1000);// 设置连接超时时间为5秒 
        conn.setReadTimeout(20 * 1000);// 设置读取超时时间为20秒 
        // 使用 URL 连接进行输出，则将 DoOutput标志设置为 true
        conn.setDoOutput(true);
      
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        //conn.setRequestProperty("Content-Encoding","gzip");
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));
        OutputStream outStream = conn.getOutputStream();// 返回写入到此连接的输出流
        outStream.write(data);
        outStream.close();//关闭流
        String msg = "";// 保存调用http服务后的响应信息
        // 如果请求响应码是200，则表示成功
        if (conn.getResponseCode() == 200) {
            // HTTP服务端返回的编码是UTF-8,故必须设置为UTF-8,保持编码统一,否则会出现中文乱码
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    (InputStream) conn.getInputStream(), "UTF-8"));
            msg = in.readLine();
            in.close();
        }
        conn.disconnect();// 断开连接
        return msg;
    }
	
}