package com.yundongjia.app.wechatPay.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.yundongjia.app.wechatPay.entity.UnifiedorderResult;
import com.yundongjia.app.wechatPay.entity.WXPayResult;

/**
 * 微信解析xml：带有CDATA格式的
 * @author iYjrg_xiebin
 * @date 2015年11月26日上午10:18:07
 */
public class JdomParseXmlUtils {
	
	/**
	 * 1、统一下单获取微信返回
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static UnifiedorderResult getUnifiedorderResult(String xml){
		UnifiedorderResult unifieorderResult = new UnifiedorderResult();
		try { 
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc;
			doc = (Document) sb.build(source);

			Element root = doc.getRootElement();// 指向根节点
			List<Element> list = root.getChildren();

			if(list!=null&&list.size()>0){
				for (Element element : list) {
					/*
					 * <xml>
						   <return_code><![CDATA[SUCCESS]]></return_code>
						   <return_msg><![CDATA[OK]]></return_msg>
						   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
						   <mch_id><![CDATA[10000100]]></mch_id>
						   <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>
						   <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>
						   <result_code><![CDATA[SUCCESS]]></result_code>
						   <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>
						   <trade_type><![CDATA[JSAPI]]></trade_type>
						</xml>
					 */
					System.out.println("key是："+element.getName()+"，值是："+element.getText());
					
					if("return_code".equals(element.getName())){
						unifieorderResult.setReturn_code(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						unifieorderResult.setReturn_msg(element.getText());
					}
					
					if("appid".equals(element.getName())){
						unifieorderResult.setAppid(element.getText());
					}
					
					
					if("mch_id".equals(element.getName())){
						unifieorderResult.setMch_id(element.getText());
					}
					
					if("nonce_str".equals(element.getName())){
						unifieorderResult.setNonce_str(element.getText());
					}
					
					if("sign".equals(element.getName())){
						unifieorderResult.setSign(element.getText());
					}
					
					if("result_code".equals(element.getName())){
						unifieorderResult.setResult_code(element.getText());
					}
					
					if("prepay_id".equals(element.getName())){
						unifieorderResult.setPrepay_id(element.getText());
					}
					
					if("trade_type".equals(element.getName())){
						unifieorderResult.setTrade_type(element.getText());
					}
				}
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return unifieorderResult;
	}
	
	
	/**
	 * 2、微信回调后参数解析
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static WXPayResult getWXPayResult(String xml){
		WXPayResult wXPayResult = new WXPayResult();
		try { 
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc;
			doc = (Document) sb.build(source);

			Element root = doc.getRootElement();// 指向根节点
			List<Element> list = root.getChildren();

			if(list!=null&&list.size()>0){
				for (Element element : list) {
					System.out.println("key是："+element.getName()+"，值是："+element.getText());
					
					if("return_code".equals(element.getName())){
						wXPayResult.setReturn_code(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					
					if("appid".equals(element.getName())){
						wXPayResult.setAppid(element.getText());
					}
					
					if("mch_id".equals(element.getName())){
						wXPayResult.setMch_id(element.getText());
					}
					
					if("nonce_str".equals(element.getName())){
						wXPayResult.setNonce_str(element.getText());
					}
					
					if("sign".equals(element.getName())){
						wXPayResult.setSign(element.getText());
					}
					
					if("result_code".equals(element.getName())){
						wXPayResult.setResult_code(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
					if("return_msg".equals(element.getName())){
						wXPayResult.setReturn_msg(element.getText());
					}
					
				}
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return wXPayResult;
	}

	
	//xml解析  
    public static Map doXMLParse(String strxml) throws JDOMException, IOException {  
          strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");  

          if(null == strxml || "".equals(strxml)) {  
              return null;  
          }  
            
          Map m = new HashMap();  
            
          InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));  
          SAXBuilder builder = new SAXBuilder();  
          Document doc = builder.build(in);  
          Element root = doc.getRootElement();  
          List list = root.getChildren();  
          Iterator it = list.iterator();  
          while(it.hasNext()) {  
              Element e = (Element) it.next();  
              String k = e.getName();  
              String v = "";  
              List children = e.getChildren();  
              if(children.isEmpty()) {  
                  v = e.getTextNormalize();  
              } else {  
                  v = getChildrenText(children);  
              }  
                
              m.put(k, v);  
          }  
            
          //关闭流  
          in.close();  
            
          return m;  
      }  
    public static String getChildrenText(List children) {  
        StringBuffer sb = new StringBuffer();  
        if(!children.isEmpty()) {  
            Iterator it = children.iterator();  
            while(it.hasNext()) {  
                Element e = (Element) it.next();  
                String name = e.getName();  
                String value = e.getTextNormalize();  
                List list = e.getChildren();  
                sb.append("<" + name + ">");  
                if(!list.isEmpty()) {  
                    sb.append(getChildrenText(list));  
                }  
                sb.append(value);  
                sb.append("</" + name + ">");  
            }  
        }  
          
        return sb.toString();  
    }  	

	
}
