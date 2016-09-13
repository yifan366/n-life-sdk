package com.b_noble.n_life.test;

import com.b_noble.n_life.info.DeviceInfo;
import com.b_noble.n_life.utils.Test16Binary;

public class TestCrc {

	public static int Crc8Gen_smbus(byte[] b,int length){
		
		int crc8 = 0;

		for (int i = 0; i < length; i++) {
		
			crc8 = crc8 ^ b[i];
			for (int j = 0; j < 8; j++) {

				if((crc8&128) !=0)
					 crc8 = (crc8<<1)^0x07;
				 //本来应该是crc8 ^ 0x101
                //但是最高位都是1 异或必然得0 所以都吧开头的1去掉了
				else
	                crc8 <<= 1;
			}
		}
		
		return crc8 & 0xff;
		
	}
	
	public static void main(String[] args) {
		
		/*byte[] b = new byte[]{0x3A,0x00 ,0x18 ,0x5A ,0x54 ,0x5A ,0x46 ,0x31 ,0x30 ,0x30 ,0x30 ,(byte) 0xFE ,(byte) 0xBA ,0x1B}; 
		
		System.out.println(Integer.toHexString(Crc8Gen_smbus(b, b.length)));*/
		
		
	/*	byte[] byt1  = new byte[]{0x0c,0x0d};
		
		System.out.println(Test16Binary.byteToShort(byt1));
		*/
		
		System.out.println((double)1015/100.d);
		
	}
	
}
