package com.yundongjia.oa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.internal.fastinfoset.algorithm.BASE64EncodingAlgorithm;

/**
 * 
 * Title:com.yundongjia.oa.utils Description:导出Excel
 * 
 * @author HuangJian
 * @date 2016年11月7日
 */
public class FtpUtil {  
    /**  
     * Description: 向FTP服务器上传文件  
     * @param host FTP服务器hostname  
     * @param port FTP服务器端口  
     * @param username FTP登录账号  
     * @param password FTP登录密码  
     * @param basePath FTP服务器基础目录 
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath 
     * @param filename 上传到FTP服务器上的文件名  
     * @param input 输入流  
     * @return 成功返回true，否则返回false  
     */    
    @SuppressWarnings("finally")
	public static String uploadFile(MultipartFile file,String filePath) { 
    	InputStream input = null;
    	String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf("."));
        String newName = System.currentTimeMillis()+extName;
    	 try {
    		 String ip = InetAddress.getLocalHost().getHostAddress();
    		 System.out.println(ip);
    		 input = file.getInputStream();
             FTPClient ftp = new FTPClient();  
             ftp.connect("103.235.254.237", 21);  
               
             boolean isLogin = ftp.login("wlftp", "wl123456");  
               
             System.out.println("登录："+isLogin);  
               
             ftp.setFileType(FTP.BINARY_FILE_TYPE); 
             ftp.changeWorkingDirectory(filePath); 
             ftp.setFileType(FTPClient.BINARY_FILE_TYPE); //文件类型为二进制文件
             boolean isStore = ftp.storeFile(filePath+newName, input);  
             System.out.println("上传："+isStore);  
             ftp.logout();
               
         } catch (Exception e) {  
             e.printStackTrace();  
         } finally{
        	 return filePath.replace("/opt/tomcat-ydj/Images/webapps/", "")+newName;
         }
    	
    }  
      
    /**  
     * Description: 从FTP服务器下载文件  
     * @param host FTP服务器hostname  
     * @param port FTP服务器端口  
     * @param username FTP登录账号  
     * @param password FTP登录密码  
     * @param remotePath FTP服务器上的相对路径  
     * @param fileName 要下载的文件名  
     * @param localPath 下载后保存到本地的路径  
     * @return  
     */    
    public static boolean downloadFile(String host, int port, String username, String password, String remotePath,  
            String fileName, String localPath) {  
        boolean result = false;  
        FTPClient ftp = new FTPClient();  
        try {  
            int reply;  
            ftp.connect(host, port);  
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
            ftp.login(username, password);// 登录  
            reply = ftp.getReplyCode();  
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();  
                return result;  
            }  
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录  
            FTPFile[] fs = ftp.listFiles();  
            for (FTPFile ff : fs) {  
                if (ff.getName().equals(fileName)) {  
                    File localFile = new File(localPath + "/" + ff.getName());  
  
                    OutputStream is = new FileOutputStream(localFile);  
                    ftp.retrieveFile(ff.getName(), is);  
                    is.close();  
                }  
            }  
  
            ftp.logout();  
            result = true;  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                }  
            }  
        }  
        return result;  
    }  
    
    
    
    
    
    
    

      
        public static void main(String[] args) throws IOException {  
//                 
            	 
            	
                FTPClient ftp = new FTPClient();  
                  
                ftp.connect("103.235.254.237", 21);  
                boolean isLogin = ftp.login("wlftp", "wl123456");  
                  
                System.out.println("登录："+isLogin);
                  
                ftp.setFileType(FTP.BINARY_FILE_TYPE); 
                ftp.changeWorkingDirectory("/opt/tomcat-ydj/Images/webapps/static/images/goodImages"); 
                ftp.setFileType(FTPClient.BINARY_FILE_TYPE); //文件类型为二进制文件
                boolean isStore = ftp.storeFile("note.txt", new FileInputStream("d:/1.jpg"));  
                  
              
                
                System.out.println("上传："+isStore);  
                  
        	
//        	String ip = InetAddress.getLocalHost().getHostAddress();
//        	System.out.println(ip);
//        	
//        	FTPClient ftp = new FTPClient();  
//            ftp.connect("103.235.254.237", 21);  
//            ftp.login("wangli", "wangli123456");  
//            boolean flag = false;  
//            if( ftp!=null ){  
//                try {  
//                    flag = ftp.deleteFile("images/goodsImages1488261052365.png");  
//                } catch (IOException e) {  
//                     if(ftp.isConnected()){  
//                	 ftp.logout();  
//                	 ftp.disconnect();  
//                }  
//            }  
//            }
        	
        	
              
              
    }  
    
    
    
    
        /** 
         *  
         * <p>删除ftp上的文件</p> 
         * @author tangw 2010-12-26 
         * @param srcFname 
         * @return true || false 
         * @throws IOException 
         * @throws SocketException 
         */  
        public static boolean removeFile(String srcFname){
        	 boolean flag = false;  
        	FTPClient ftp = new FTPClient();  
            try {
				ftp.connect("103.235.254.237", 21);
				ftp.login("wlftp", "wl123456");  
				 if( ftp!=null ){  
		                	 String ip = InetAddress.getLocalHost().getHostAddress();
		                    flag = ftp.deleteFile("/opt/tomcat-ydj/Images/webapps/"+srcFname); 
		                		ftp.logout();
								ftp.disconnect(); 
		            }
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
           
           
            return flag;  
       } 
        
}
    
    
    
    
    
    
    
    
    
    
