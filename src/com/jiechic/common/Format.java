package com.jiechic.common;

import android.annotation.SuppressLint;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

//import android.annotation.SuppressLint;

public class Format {
	private final static String TAG = "Format";
	
	/**
	 * 日期时间转字符串
	 *
	 * @param DateTime
	 * @return String
	 */
	
	@SuppressLint("SimpleDateFormat")
	public static String DateTime_to_String(Date date) {
		if (date==null){
			return "";
		}else{
			SimpleDateFormat formatter;
		    formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		    String ctime = formatter.format(date);
		    logh.d(TAG, "datetime_to_String:" +ctime);
		    return ctime;
		}
	}
	

	@SuppressLint("SimpleDateFormat")
	public static Date String_to_DateTime(String time) {
		if ((time==null)||("".equals(time))){
			return null;
		}else{
			SimpleDateFormat formatter;
		    int tempPos=time.indexOf("AD") ;
		    time=time.trim() ;
		    formatter = new SimpleDateFormat ("yyyy.MM.dd G 'at' hh:mm:ss z");
		    if(tempPos>-1){
		      time=time.substring(0,tempPos)+
		           "公元"+time.substring(tempPos+"AD".length());//china
		      formatter = new SimpleDateFormat ("yyyy.MM.dd G 'at' hh:mm:ss z");
		    }
		    tempPos=time.indexOf("-");
		    if(tempPos>-1&&(time.indexOf(" ")<0)){
		      formatter = new SimpleDateFormat ("yyyyMMddHHmmssZ");
		    }
		    else if((time.indexOf("/")>-1) &&(time.indexOf(" ")>-1)){
		      formatter = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
		    }
		    else if((time.indexOf("-")>-1) &&(time.indexOf(" ")>-1)){
		      formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		    }
		    else if((time.indexOf("/")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){
		      formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a");
		    }
		    else if((time.indexOf("-")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){
		      formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a");
		    }
		    ParsePosition pos = new ParsePosition(0);
		    Date ctime = formatter.parse(time, pos);
		    return ctime; 
		}
		
	}
	
	/**
	 * 日期时间转字符串
	 *
	 * @param DateTime
	 * @return String
	 */
	
	@SuppressLint("SimpleDateFormat")
	public static String Date_to_String(Date date) {
		if (date==null){
			return "";
		}else{
			SimpleDateFormat formatter;
		    formatter = new SimpleDateFormat ("yyyy-MM-dd");
		    String ctime = formatter.format(date);
		    logh.d(TAG, "date_to_String:" +ctime);
		    return ctime;
		}
	}
	

	@SuppressLint("SimpleDateFormat")
	public static Date String_to_Date(String time) {
		if (time==""){
			return null;
		}else{
			SimpleDateFormat formatter;
		    int tempPos=time.indexOf("AD") ;
		    time=time.trim() ;
		    formatter = new SimpleDateFormat ("yyyy.MM.dd");
		    if(tempPos>-1){
		      time=time.substring(0,tempPos)+
		           "公元"+time.substring(tempPos+"AD".length());//china
		      formatter = new SimpleDateFormat ("yyyy.MM.dd");
		    }
		    tempPos=time.indexOf("-");
		    if(tempPos>-1&&(time.indexOf(" ")<0)){
		      formatter = new SimpleDateFormat ("yyyyMMdd");
		    }
		    else if((time.indexOf("/")>-1) &&(time.indexOf(" ")>-1)){
		      formatter = new SimpleDateFormat ("yyyy/MM/dd");
		    }
		    else if((time.indexOf("-")>-1) &&(time.indexOf(" ")>-1)){
		      formatter = new SimpleDateFormat ("yyyy-MM-dd");
		    }
		    else if((time.indexOf("/")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){
		      formatter = new SimpleDateFormat ("yyyy-MM-dd");
		    }
		    else if((time.indexOf("-")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){
		      formatter = new SimpleDateFormat ("yyyy-MM-dd");
		    }
		    ParsePosition pos = new ParsePosition(0);
		    Date ctime = formatter.parse(time, pos);
		    return ctime; 
		}
		
	}
	
}
