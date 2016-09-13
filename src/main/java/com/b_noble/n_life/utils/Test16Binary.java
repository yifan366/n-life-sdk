package com.b_noble.n_life.utils;

import java.io.UnsupportedEncodingException;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 16进制与10进制互转帮助类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class Test16Binary {

	public static void main(String[] args) throws UnsupportedEncodingException {

	
	
	System.out.println(Test16Binary.bytes2hex03("ZTZF1000".getBytes()));
	
	}
	
	public static byte[] intToByte(int i)
	{
	    byte[] bytes = new byte[4];
	    bytes[0] = (byte)(0xff & i);
	    bytes[1] = (byte)((0xff00 & i) >> 8);
	    bytes[2] = (byte)((0xff0000 & i) >> 16);
	    bytes[3] = (byte)((0xff000000 & i) >> 24);
	    return bytes;
	}
	
	public static int byte2int(byte[] res) {   
		// 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000   
		  
		int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | 表示安位或   
		| ((res[2] << 24) >>> 8) | (res[3] << 24);   
		return targets;   
		} 
	

	// 转化字符串为十六进制编码
	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;

		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	public static String bytes2hex03(byte[] bytes) {
		final String HEX = "0123456789abcdef";
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		int h = 0;
		for (byte b : bytes) {
			h++;
			// 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
			sb.append(HEX.charAt((b >> 4) & 0x0f));
			// 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
			sb.append(HEX.charAt(b & 0x0f));
			sb.append(" ");
			if (h == 8) {
				sb.append("  ");
			}else if(h ==16){
				h=0;
				sb.append("\n");
			}
		}

		return sb.toString();
	}
	
	
	/** 
	 * bytes转换成十六进制字符串 
	 */  
	public static byte[] hexStr2Bytes(String src) {  
	    int m = 0, n = 0;  
	    int l = src.length() / 2;  
	    byte[] ret = new byte[l];  
	    for (int i = 0; i < l; i++) {  
	        m = i * 2 + 1;  
	        n = m + 1;  
	        ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));  
	    }  
	    return ret;  
	} 
	
	private static byte uniteBytes(String src0, String src1) {  
	    byte b0 = Byte.decode("0x" + src0).byteValue();  
	    b0 = (byte) (b0 << 4);  
	    byte b1 = Byte.decode("0x" + src1).byteValue();  
	    byte ret = (byte) (b0 | b1);  
	    return ret;  
	}  
	
	 /** 
     * 注释：字节数组到short的转换！ 
     * 
     * @param b 
     * @return 
     */ 
    public static short byteToShort(byte[] b) { 
        short s = 0; 
        short s0 = (short) (b[0] & 0xff);// 最低位 
        short s1 = (short) (b[1] & 0xff); 
        s1 <<= 8; 
        s = (short) (s0 | s1); 
        return s; 
    }

}
