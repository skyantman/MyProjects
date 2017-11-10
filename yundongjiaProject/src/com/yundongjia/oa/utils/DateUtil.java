package com.yundongjia.oa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class DateUtil {

	public static String getTimeByCalendar() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);// 获取年份
		int month = cal.get(Calendar.MONTH) + 1;// 获取月份
		int day = cal.get(Calendar.DATE);// 获取日
		int hour = cal.get(Calendar.HOUR);// 小时
		int minute = cal.get(Calendar.MINUTE);// 分
		int second = cal.get(Calendar.SECOND);// 秒
		return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":"
				+ second;
	}

	public static String format(Date date, String formatStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
		String strTime = dateFormat.format(date);
		return strTime;
	}

	public static Date stringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getTime(String user_time) {
		String re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		Date d;
		try {

			d = sdf.parse(user_time);
			long l = d.getTime();
			String str = String.valueOf(l);
			re_time = str.substring(0, 10);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return re_time;
	}

	public static Date timeStampToDate(long timeStamp) {
		long javaTimeStamp = Long.valueOf(timeStamp) * 1000;
		Date date = new Date(javaTimeStamp);
		return date;
	}

	public static String getYear(long time) {
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		long lcc_time = Long.valueOf(time);
		re_StrTime = sdf.format(new Date(lcc_time));
		return re_StrTime;
	}

	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long javaTimeStamp = System.currentTimeMillis() * 1000;
		String strTime = sdf.format(new Date(javaTimeStamp));
		return strTime;
	}
	public static String getCurrentTimeMM() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		long javaTimeStamp = System.currentTimeMillis() * 1000;
		String strTime = sdf.format(new Date(javaTimeStamp));
		return strTime;
	}
	public static String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String dateString="";
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyyMMdd");
       dateString = formatter.format(currentTime);
		return dateString;
	}
	public static String getCurrentTimeByCalendar() {
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int day = ca.get(Calendar.DATE);
		int hour = ca.get(Calendar.HOUR);
		int mm = ca.get(Calendar.MINUTE);
		int ss = ca.get(Calendar.SECOND);
		return year + "-" + month + "-" + day + " " + hour + ":" + mm + ":"
				+ ss;
	}

	public static String timeStamp2Date(String timestampString) {
		Long timestamp = Long.parseLong(timestampString) * 1000;
		String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new java.util.Date(timestamp));
		return date;
	}
	


	public static String getWeek(String dateString) {
		int year = 0;
		int month = 0;
		int date = 0;
		String[] dates = dateString.split("-");
		year = Integer.parseInt(dates[0]);
		month = Integer.parseInt(dates[1]);
		date = Integer.parseInt(dates[2]);
		GregorianCalendar gc = new GregorianCalendar();
		final char[] kor_week = { '日', '一', '二', '三', '四', '五', '六' };
		gc.set(year, month - 1, date);
		char week = kor_week[gc.get(Calendar.DAY_OF_WEEK) - 1];
		String S = "星期" + week;
		return S;
	}
		
	
	public static String getWeekM(String dateString) {
		int year = 0;
		int month = 0;
		int date = 0;
		
		year = Integer.parseInt(dateString.substring(0, 4));
		month = Integer.parseInt(dateString.substring(4, 6));
		date = Integer.parseInt(dateString.substring(6, 8));
		GregorianCalendar gc = new GregorianCalendar();
		final char[] kor_week = { '0', '1', '2', '3', '4', '5', '6' };
		gc.set(year, month - 1, date);
		char week = kor_week[gc.get(Calendar.DAY_OF_WEEK) - 1];
		String S = week+"";
		return S;
	}
	
		
	public static String getMonthDay(String dateString) {
        int day=0;
		int month = 0;
		String[] dates = dateString.split("-");
	
		month = Integer.parseInt(dates[1]);
		day = Integer.parseInt(dates[2]);
		return  month + "月"+day ;
	}



public static String getDateTime() {
	SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	String dateString="";
	Date currentTime = new Date();
	
   dateString = dateFormat.format(currentTime);
	return dateString;
}


/***
 * 
 * 已知当前时间，返回当前时的的前一天，后一天
 * 
 * **************/
	public static String getDateByDay(Date date, int day) {
		Date dBefore = new Date();

		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(date);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, day); // 设置为前一天
		dBefore = calendar.getTime(); // 得到前一天的时间

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		String defaultStartDate = sdf.format(dBefore); // 格式化前一天

		return defaultStartDate;
	}
	
	
	public static List<String> getDate(String date1, String date2) {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			Calendar c = Calendar.getInstance();
			c.setTime(d1);

			System.out.println(sdf.format(c.getTime()));// 打出第一天的
			do {
				c.add(Calendar.DATE, 1);// 日期加1
				System.out.println(sdf.format(c.getTime()));
				list.add(sdf.format(c.getTime()));
			} while (!c.getTime().equals(d2));// 直到和第二个日期相等，跳出循环
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static String getWeekNum(String dateString) {
		int year = 0;
		int month = 0;
		int date = 0;
		String[] dates = dateString.split("-");
		year = Integer.parseInt(dates[0]);
		month = Integer.parseInt(dates[1]);
		date = Integer.parseInt(dates[2]);
		GregorianCalendar gc = new GregorianCalendar();
		final char[] kor_week = { '7', '1', '2', '3', '4', '5', '6' };
		gc.set(year, month - 1, date);
		char week = kor_week[gc.get(Calendar.DAY_OF_WEEK) - 1];
		String S =  week+"";
		return S;
	}
	
	public static boolean CompareDateTime(String time1, String time2) {
		boolean isFirstBig = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date date1 = dateFormat.parse(time1);
			Date date2 = dateFormat.parse(time2);
			//System.out.println("date1==" + date1.getTime());
			//System.out.println("date2==" + date2.getTime());
			// Method 1
			if (date1.getTime() > date2.getTime()) {
				//System.out.println("M1--date1在date2后");
				isFirstBig = true;
			} else if (date1.getTime() < date2.getTime()) {
				//System.out.println("M1--date1在date2前");
				isFirstBig = false;
			}
			// Method 2
			if (date1.compareTo(date2) == 1) {
				//System.out.println("M2--date1在date2后");
				isFirstBig = true;
			} else if (date1.getTime() < date2.getTime()) {
				//System.out.println("M2--date1在date2前");
				isFirstBig = false;
			}
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(date1);
			cal2.setTime(date2);
			if (cal1.after(cal2)) {
				//System.out.println("M3--date1在date2后");

			} else {
				//System.out.println("M3--date1在date2前");
			}
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return isFirstBig;

	}
	
	/**
	 * @author liutao
	 * 2016年5月17日  上午11:39:36
	 * describe  :
	 * 获得n个月内的开始时间字符串
	 * @param n
	 * @param bol    true:包含时分秒,    false: 不包含时分秒
	 * @return
	 */
	public static String getLastMonthStartStr(int n,Boolean bol){
		String format2=null;
		try {
			Calendar cal=Calendar.getInstance();
			cal.setTime( new Date());
			cal.add(Calendar.MONTH, -(n-1));
			Date d1=cal.getTime();
			String format = new SimpleDateFormat("yyyy-MM").format(d1); 
			cal.setTime( new SimpleDateFormat("yyyy-MM-dd").parse(format+"-01"));
			cal.add(Calendar.DATE, -1);
			Date d2=cal.getTime();
			format2 = new SimpleDateFormat("yyyy-MM-dd").format(d2); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(bol){
			return format2+" 0:0:0";
		}else{
			return format2;
		}
	}

	/**
	 * @author liutao
	 * 2016年5月17日  上午11:40:45
	 * describe  :
	 * 获得当前月结尾的时间字符串
	 * @param bol  true:包含时分秒,    false: 不包含时分秒
	 * @return
	 */
	public static String getNowMonthStartStr(Boolean bol){
		Date d1=new Date();
		String format=new SimpleDateFormat("yyyy-MM-dd").format(d1);
		if(bol){
			return format+" 0:0:0"; 
		}else{
			return format;
		}		
	}

	
	/**
	 * @author liutao
	 * 2016年5月17日  下午3:06:10
	 * describe  :
	 * 获得num个月内的字符串数组
	 * @param num
	 * @return 格式  yyyy-MM
	 */
	public static List<String> getMonthsList(int num){
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM");
		Date now=new Date();
		List<String> list=new ArrayList<String>();
		for(int i=0;i<num;i++){
			Date d=dateTimeAdd(now, Calendar.MONTH, -i);
			String format=s2.format(d);
			list.add(format);
		}
		return list;
	}
	
	/**
	 * @author liutao
	 * 2016年5月17日  下午3:03:30
	 * describe  :
	 * 时间加减指定数量
	 * @param _dateTime
	 * @param _field
	 * @param _amount
	 * @return
	 */
	public static Date dateTimeAdd(Date _dateTime, int _field, int _amount) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(_dateTime);
		cal.add(_field, _amount);
		return cal.getTime();
	}
	
	/**
	 * @author liutao
	 * 2016年5月17日  下午3:19:14
	 * describe  :
	 * 根据日期字符串返回 yyyy-MM 格式的字符串
	 * @param str
	 * @param bol true:包含时分秒 , false:不包含时分秒
	 * @return
	 */
	public static String getYMStr(String str,boolean bol){
		String result=null;
		try {
			if(bol){
				SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM");
				Date d1=s1.parse(str);
				result=s2.format(d1);
			}else{
				SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM");
				Date d1=s1.parse(str);
				result=s2.format(d1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @author liutao
	 * 2016年5月17日  下午5:53:02
	 * describe  :
	 * 根据date 返回yyyy-MM 类型字符串
	 * @param date
	 * @return
	 */
	public static String getYMStrByDate(Date date){
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM");
		return s2.format(date);
	}
	
	public static String getYMDStrByDate(Date date){
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");
		return s2.format(date);
	}
	
	/**
	 * 判断时间是否超过当前时间
	 * @param d1
	 * @return
	 */
	public static String comWithNow(String d1){
		String result = "1";
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date dt1 = df.parse(d1);
			Date dt2 = new Date();
			if (dt1.getTime() < dt2.getTime()){
				result = "0";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}


    /**
     * 返回yyyy-MM-dd 时间  now的
     * @return
     */
	public static String getDateStr(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(new Date());
        return format;

    }




	
}
