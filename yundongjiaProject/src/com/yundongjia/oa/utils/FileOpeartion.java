/**
* @author HuangJian
* @date 2017年2月21日
*/
package com.yundongjia.oa.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FileOpeartion {

	public static String write(String context, String fileName) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String path = "images/html/" + fileName + ".html";
		StringBuffer sb = new StringBuffer("");
		sb.append("<!DOCTYPE html lang='zh-CN'>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta charset='utf-8'>");
	  //sb.append("<meta name='viewport' content='width=100%,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no' />");
		
		sb.append("<meta name='viewport' content='user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0' />");
		sb.append("<meta name='apple-mobile-web-app-capable' content='yes' /> ");
		sb.append("<meta name='apple-mobile-web-app-status-bar-style' content='black' />");
		
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8>' ");
		sb.append("<title>");
		sb.append("");
		sb.append("</title>");
		sb.append("<style type='text/css'>");
		//sb.append("body{text-align: center}");
		sb.append("img { display: inline  ; }");
		
		sb.append("</style>");
		sb.append("<script type='text/javascript'>");
		//sb.append(" window.onload = function() { ");
		//sb.append("var u = navigator.userAgent;");
		//sb.append("var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1;");
		//sb.append("var isiOS = !!u.match(/\\(i[^;]+;( U;)? CPU.+Mac OS X/);");
		//sb.append("alert('是否是Android：'+isAndroid);");
		//sb.append(" alert('是否是iOS：'+isiOS);");
		//sb.append("if(isAndroid){");
		//sb.append("document.getElementById('mainBody').setAttribute('style', 'font-size:16px;');");
		//sb.append("}");
		//sb.append(" if(isiOS){");
		//sb.append("document.getElementById('mainBody').setAttribute('style', 'font-size:32px;');");
		//sb.append("}");
		
		//sb.append("};");
		sb.append("</script>");
		sb.append("<head>");
		sb.append("<body>");
		sb.append("<div id='mainBody'>");
		sb.append(context);
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");

		try {
			String temp = "webapps/"+path;
			URL url = new URL("ftp://wlftp:wl123456@103.235.254.237/"+temp); 
			
			OutputStream out = url.openConnection().getOutputStream();
			 
			PrintWriter pw;//= new PrintWriter(url.openConnection().getOutputStream());
			pw = new PrintWriter(out);
			pw.write(sb.toString());
			
			pw.flush();
			pw.close();
			System.out.println("写入数据成功!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			 e.printStackTrace();
		}
		/*
		 * try { FileOutputStream out = new FileOutputStream(path);
		 * 
		 * ObjectOutputStream os = new ObjectOutputStream(out);
		 * os.writeObject(sb.toString());
		 * 
		 * System.out.println("写入数据成功!");
		 * 
		 * os.flush(); os.close(); out.close(); } catch (FileNotFoundException
		 * e) {
		 * 
		 * e.printStackTrace(); } catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		//String vPath = "html/" + fileName + ".html";
		System.out.println("虚拟路径：" + path);
		return path;
	}
	
	public static void main(String[] args) {
		String temp = "images/html/information/100.html";
		URL url;
		try {
			url = new URL("ftp://wlftp:wl123456@103.235.254.237/"+temp);
			//url = new URL("ftp://uftp:hj@192.168.1.119/node.txt");
			System.out.println(url.getPath());
			System.out.println(url.getFile());
			System.out.println(url.getUserInfo());
			System.out.println(url.openConnection());
			System.out.println(url.openConnection().getOutputStream());
			OutputStream out = url.openConnection().getOutputStream();
			
			PrintWriter pw;//= new PrintWriter(url.openConnection().getOutputStream());
			pw = new PrintWriter(out);
			pw.write("abc");
			
			pw.flush();
			pw.close();
			System.out.println("写入数据成功!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("out");
			e.printStackTrace();
		} 
		
	}
	
}
