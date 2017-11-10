package com.yundongjia.oa.utils;

import java.util.Comparator;

import net.sf.json.JSONObject;
/**
 * 
 * json按某个字段排序
 * **/
public class JSONSort implements Comparator<JSONObject>{

		  
		  String dateName = "";
		  public JSONSort(String dateName){
		    this.dateName = dateName;
		  }
		  @Override
		  public int compare(JSONObject json1, JSONObject json2){
		    String date1 = json1.optString(dateName);
		    String date2 = json2.optString(dateName);
		    if(date1.compareTo(date2) < 0){
		      return -1;
		    }else if(date1.compareTo(date2) >0){
		      return 1;
		    }
		    return 0;
		  }
		}


