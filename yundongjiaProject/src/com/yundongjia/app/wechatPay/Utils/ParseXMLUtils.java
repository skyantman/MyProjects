package com.yundongjia.app.wechatPay.Utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class ParseXMLUtils {

	/**
	 * 1、DOM解析
	 */
	@SuppressWarnings("rawtypes")
	public static void beginXMLParse(String xml){
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML

			Element rootElt = doc.getRootElement(); // 获取根节点smsReport

			System.out.println("根节点是："+rootElt.getName());

			Iterator iters = rootElt.elementIterator("sendResp"); // 获取根节点下的子节点sms

			while (iters.hasNext()) {
				Element recordEle1 = (Element) iters.next();
				Iterator iter = recordEle1.elementIterator("sms");

				while (iter.hasNext()) {
					Element recordEle = (Element) iter.next();
					String phone = recordEle.elementTextTrim("phone"); // 拿到sms节点下的子节点stat值

					String smsID = recordEle.elementTextTrim("smsID"); // 拿到sms节点下的子节点stat值

					System.out.println(phone+":"+smsID);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2、DOM4j解析XML（支持xpath）
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	public static void xpathParseXml(String xml){
		try { 
			StringReader read = new StringReader(xml);
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(read);
			String xpath ="/xml/appid";
			System.out.print(doc.selectSingleNode(xpath).getText());  
		} catch (DocumentException e) {
			e.printStackTrace();
		}  
	}

	/**
	 * 3、JDOM解析XML
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject jdomParseXml(String xml){
		JSONObject json = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		try { 
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			org.jdom.Document doc;
			doc = (org.jdom.Document) sb.build(source);

			org.jdom.Element root = doc.getRootElement();// 指向根节点
			List<org.jdom.Element> list = root.getChildren();

			if(list!=null&&list.size()>0){
				for (org.jdom.Element element : list) {
//					else if("sign".equals(element.getName())){
//                    	json.put("sign", element.getText());
//                    }
					if("appid".equals(element.getName())){
                    	json.put("appid", element.getText());
                    }else if("mch_id".equals(element.getName())){
                    	json.put("partnerid", element.getText());
                    }else if("prepay_id".equals(element.getName())){
                    	json.put("prepayid", element.getText());
                    }else if("nonce_str".equals(element.getName())){
                    	json.put("noncestr", element.getText());
                    }else if("trade_type".equals(element.getName())){
                    	json.put("package", "Sign=WXPay");
                    }else if("nonce_str".equals(element.getName())){
                    	json.put("noncestr", element.getText());
                    }else if("err_code_des".equals(element.getName())){
                    	String des = element.getText();
                    	json.put("err_code_des", des);
                    }
					System.out.println("key是："+element.getName()+"，值是："+element.getText());
					
					/*try{
						methodName =  element.getName();
						Method m = v.getClass().getMethod("set" + methodName, new Class[] { String.class });
						if(parseInt(methodName)){
							m.invoke(v, new Object[] { Integer.parseInt(element.getText()) });
						}else{
							m.invoke(v, new Object[] { element.getText() });
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}*/

				}
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	public static boolean parseInt(String key){
		if(!StringUtils.isEmpty(key)){
			if(key.equals("total_fee")||key.equals("cash_fee")||key.equals("coupon_fee")||key.equals("coupon_count")||key.equals("coupon_fee_0")){
				return true;
			}
		}

		return false;
	}
	//请求xml组装  
    public static String getRequestXml(SortedMap<String,Object> parameters){  
          StringBuffer sb = new StringBuffer();  
          sb.append("<xml>");  
          Set es = parameters.entrySet();  
          Iterator it = es.iterator();  
          while(it.hasNext()) {  
              Map.Entry entry = (Map.Entry)it.next();  
              String key = (String)entry.getKey();  
              String value = (String)entry.getValue();  
              if ("attach".equalsIgnoreCase(key)||"body".equalsIgnoreCase(key)||"sign".equalsIgnoreCase(key)) {  
                  sb.append("<"+key+">"+"<![CDATA["+value+"]]></"+key+">");  
              }else {  
                  sb.append("<"+key+">"+value+"</"+key+">");  
              }  
          }  
          sb.append("</xml>");  
          return sb.toString();  
      } 


}
