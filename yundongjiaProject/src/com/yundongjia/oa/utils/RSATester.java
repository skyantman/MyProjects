package com.yundongjia.oa.utils;

import java.util.Map;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;

/** * @author  作者WangLi: * @date 创建时间：2017年1月16日 下午5:01:04 * @version 1.0 * @parameter  * @since  * @return  */
public class RSATester {

	
    static String publicKey;  
    static String privateKey;  
  
    static {  
        try {  
            Map<String, Object> keyMap = RSAUtils.genKeyPair();  
            publicKey = RSAUtils.getPublicKey(keyMap);  
            privateKey = RSAUtils.getPrivateKey(keyMap);  
            System.err.println("公钥: \n\r" + publicKey);  
            System.err.println("私钥： \n\r" + privateKey);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void main(String[] args) throws Exception {  
        test();  
        testSign();  
    }  
  
    static void test() throws Exception {  
        System.err.println("公钥加密——私钥解密");  
        String source = "6L+Z5piv5LiA6KGM5rKh5pyJ5Lu75L2V5oSP5LmJ55qE5paH5a2X77yM5L2g55yL5a6M5LqG562J5LqO5rKh55yL77yM5LiN5piv5ZCX77yf";  
        System.out.println("\r加密前文字：\r\n" + source);  
        byte[] data = source.getBytes();  
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwgjKVPAoi0bWrstMhKv2PXEdV8U//6EuH0qIsV+2M2LjFw7kO3Xly4DM4NoIP/N1H41Fw5fK6EGe928j3GNzBHpN4NNHWNejrxa5v2a19cBbIaFBdplex+erZKliXE+tBjJa2PrtkbFahYPdeetHXNqV/0rWTxF+fv/3mzvBQzQIDAQAB");  
        System.out.println("加密后文字：\r\n" + new String(encodedData));  
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALCCMpU8CiLRtauy0yEq/Y9cR1XxT//oS4fSoixX7YzYuMXDuQ7deXLgMzg2gg/83UfjUXDl8roQZ73byPcY3MEek3g00dY16OvFrm/ZrX1wFshoUF2mV7H56tkqWJcT60GMlrY+u2RsVqFg91560dc2pX/StZPEX5+//ebO8FDNAgMBAAECgYApNPwiIvYq0tKa1xC7OZIgmeZ9heyrTcv0VZROzehDbYUVhm/5rHLiAr1ybidHHD18vvEQbl6QWaweguUT6tX+THX00JvGCAJ2T2CO4Vz9V1ZkB0OsHdZR18c+lKa0RxbkZ8Q2wfYvX1Q25nK77saGVcZBw+0Yb/iNepnv73JqgQJBAOJgqvpk/uMJM7IKCEYSk8OqeC5OUqutmuqhFLT1OVwtVxQ0x/1D5iGOFWfrlZFnRn0oPAOmNqA9bjtHsICtvQUCQQDHmvzFbMwEOaGxJJnf1qJjvmC66qDfc2pIflVcEV0V205IUVtyLLZaQC1KvOdWvFU4cSiZeDvtTYngrkWtDs8pAkA//S03XCcETAyVzeoqzIOCMoSIKlGJ/6ejnOa6g/qzyIktyAGj4HaDk6MPXfNIR5YQOLhGG8yjHNo03X3R0cp1AkBoPq5yoR5vunWSoU3nlB3dP8ke9XitGobQc4I7Aip+Rrm8lRjQKT/XJJtC5CNhrhxHzPlqJVwO1CcE+58SAaD5AkEA2sBEjHId2JjT1E5gA/I2a9gRr7cVYfIxhodMH2GdL/wwEB2sJmF541nqyyQWhSiHrDWsaS/UFnpcvVYoEGLwmw==");  
        String target = new String(decodedData);  
        System.out.println("解密后文字: \r\n" + target);  
    }  
  
    static void testSign() throws Exception {  
        System.err.println("私钥加密——公钥解密");  
        String source = "这是一行测试RSA数字签名的无意义文字";  
        System.out.println("原文字：\r\n" + source);  
        byte[] data = source.getBytes();  
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);  
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);  
        String target = new String(decodedData);  
        System.out.println("解密后: \r\n" + target);  
        System.err.println("私钥签名——公钥验证签名");  
        String sign = RSAUtils.sign(encodedData, privateKey);  
        System.err.println("签名:\r" + sign);  
        boolean status = RSAUtils.verify(encodedData, publicKey, sign);  
        System.err.println("验证结果:\r" + status);  
    }  
	
}
