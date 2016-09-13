package com.b_noble.n_life.utils;

/**
 * snid帮助类
 * @author zhangfan
 *
 */
public class SnidUtil {

	/**
	 * 获取snid
	 * @return 
	 */
	public static int[] getSnids(){
		
		String snid = Global.sncode;
		int sn1 = Test16Binary.hexStr2Bytes(snid)[0];
		int sn2 = Test16Binary.hexStr2Bytes(snid)[1];
		int sn3 = Test16Binary.hexStr2Bytes(snid)[2];
		int sn4 = Test16Binary.hexStr2Bytes(snid)[3];
		
		int[] snids = new int[4];
		
		snids[0]= sn4;
		snids[1]= sn3;
		snids[2]= sn2;
		snids[3]= sn1;
		
		return snids;
		
	}
	
	/**
	 * 获取sn1
	 */
	public static int getSnid1(){
		return getSnids()[0];
	}
	/**
	 * 获取sn2
	 */
	public static int getSnid2(){
		return getSnids()[1];
	}
	/**
	 * 获取sn3
	 */
	public static int getSnid3(){
		return getSnids()[2];
	}
	/**
	 * 获取sn4
	 */
	public static int getSnid4(){
		return getSnids()[3];
	}
}
