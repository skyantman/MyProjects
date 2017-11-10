package com.yundongjia.oa.utils;

import java.text.SimpleDateFormat;
import java.text.ParseException;  
import java.util.Calendar;  
import java.util.Date;

public class DateFormatUtil {
	public static String dateToString(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = simpleDateFormat.format(date);
		return format;
	}
	/**  
     * 计算两个日期之间相差的天数  
     * @param stratdate 较小的时间 
     * @param enddate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date stratdate,Date enddate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        stratdate=sdf.parse(sdf.format(stratdate));  
        enddate=sdf.parse(sdf.format(enddate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(stratdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(enddate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
      
/** 
*字符串的日期格式的计算 
*/  
    public static int daysBetween(String stratdate,String enddate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(stratdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(enddate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    } 
    
    /**
     * @param SourceDate
     * @param day日期加天数返回日期
     * @return
     */
    public static Date addDate(Date d,long day) throws ParseException {
	  long time = d.getTime();
	  day = day*24*60*60*1000;
	  time+=day;
	  return new Date(time);
	} 
    
    /**
     * @param SourceDate
     * @param day日期减天数返回日期
     * @return
     */
    public static Date subDate(Date d,long day) throws ParseException {
	  long time = d.getTime();
	  day = day*24*60*60*1000;
	  time-=day;
	  return new Date(time);
	} 
    
    
    	 public static  String formateDate(Long leadTime){
    		 Calendar calendar = Calendar.getInstance();
    		 calendar.setTime(new Date(leadTime));
    		 if(calendar.get(Calendar.HOUR_OF_DAY)> 8 && calendar.get(Calendar.DAY_OF_MONTH) == 1){
    			 return (calendar.get(Calendar.HOUR_OF_DAY) - 8) + "小时前";
    		 }else if(calendar.get(Calendar.DAY_OF_MONTH)>1){
    			 return (calendar.get(Calendar.DAY_OF_MONTH)- 1) + "天前";
    		 }else if(calendar.get(Calendar.DAY_OF_MONTH) == 1 && calendar.get(Calendar.HOUR_OF_DAY) == 8 ){
    			 return calendar.get(Calendar.MINUTE) + "分钟前";
    		 }
    		 return "";
    	 }
}
