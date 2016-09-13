package com.b_noble.n_life.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：日期帮助类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class DateHelp {

	public static String getTime(){
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("HH:mm:ss");
		String s = simple.format(date);
		return s;
	}
	
	
	public static String getNowDate(){
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = simple.format(date);
		return s;
	}
	
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String s = simple.format(date);
		return s;
	}
	
	//获取当前时间，并且返回时间(年月日时分秒毫秒)
	public static String getTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms");
		String photoName = sdf.format(new Date());
		return photoName ;
	}
	
	//获取当天日期
	public static String getDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String photoName = sdf.format(new Date());
		return photoName ;
	}
	
	public static void main(String[] args) {
		System.out.println(getNowDate());
	}
	
	//获取当前时间，并且返回时间(2014年12月29日)
	public static String getnianyueri() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String photoName = sdf.format(new Date());
		return photoName ;
	}
}
