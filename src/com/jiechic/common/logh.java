package com.jiechic.common;

import android.util.Log;

public class logh {
    /**
     * 私有构造函数
     */
	private logh(){}
	/**
	 * 详细级别的日志信息
	 * @param msg
	 */	 	
	public static void v(String msg)
	{
	       Log.v("System.out", msg);
	}
	/**
	 * 详细级别的日志信息
	 * @param tag
	 * @param msg
	 */	 	
	public static void v(String tag,String msg)
	{
	       Log.v(tag, msg);
	}
	/**
	 * Info级别的日志信息
	 * @param msg
	 */
	public static void i(String msg)
	{
	       Log.i("System.out", msg);
	}
	/**
	 * Info级别的日志信息
	 * @param tag
	 * @param msg
	 */
	public static void i(String tag,String msg)
	{
	       Log.i(tag, msg);
	}
	
	/**
	 * 调式级别的日志信息
	 * @param msg
	 */
	public static void d(String msg)
	{
	       Log.d("System.out", msg);
	}
	/**
	 * 调式级别的日志信息
	 * @param tag
	 * @param msg
	 */
	public static void d(String tag,String msg)
	{
	       Log.d(tag, msg);
	}
	/**
	 * 错误级别的日志信息
	 * @param msg
	 */
	public static void e(String msg)
	{
	       Log.e("System.out", msg);
	}
	/**
	 * 错误级别的日志信息
	 * @param tag
	 * @param msg
	 */
	public static void e(String tag,String msg)
	{
	       Log.e(tag, msg);
	}
	/**
	 * 警告级别的日志信息
	 * @param msg
	 */
	public static void w(String msg)
	{
	       Log.w("System.out", msg);
	}
	/**
	 * 警告级别的日志信息
	 * @param tag
	 * @param msg
	 */
	public static void w(String tag,String msg)
	{
	       Log.w(tag, msg);
	}
	
}
