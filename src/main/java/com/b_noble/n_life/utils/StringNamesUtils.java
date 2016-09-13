package com.b_noble.n_life.utils;

import java.io.UnsupportedEncodingException;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 32位的字节数组转String帮助类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class StringNamesUtils {

	
	public static void main(String[] args) {
		
	}

	public static String byteToString(byte[] b){
		
		int size = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i]!=0) {
				size++;
			}
		}
		byte[] newb = new byte[size];
		
		for (int i = 0; i < newb.length; i++) {
			newb[i] = b[i]; 
		}
		String str = "";
		try {
			str = new String(newb, "gbk");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			str ="";
		}
		
		return str;
		
	}
}
