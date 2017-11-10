package com.yundongjia.oa.utils.httpsutils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/** * @author  作者WangLi: * @date 创建时间：2017年1月18日 下午1:52:21 * @version 1.0 * @parameter  * @since  * @return  */
public class SocketUtils {  
    public static void close(Socket s){  
        try {  
            s.shutdownInput();  
            s.shutdownOutput();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
  
  
    public static byte[] readBytes(DataInputStream in,int length) throws IOException {  
        int r=0;  
        byte[] data=new byte[length];  
        while(r<length){  
            r+=in.read(data,r,length-r);  
        }  
  
        return data;  
    }  
  
    public static void writeBytes(DataOutputStream out,byte[] bytes,int length) throws IOException{  
        out.writeInt(length);  
        out.write(bytes,0,length);  
        out.flush();  
    }  
}  
