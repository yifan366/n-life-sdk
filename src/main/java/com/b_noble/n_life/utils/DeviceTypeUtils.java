package com.b_noble.n_life.utils;

import com.b_noble.n_life.event.DeviceTypeEnum;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：设备类型帮助类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class DeviceTypeUtils {

	public static int getDeviceType(byte[] deviceId, byte[] ProfileId) {
		String did = Test16Binary.bytes2hex03(deviceId).replaceAll(" ", "");

		String fid = Test16Binary.bytes2hex03(ProfileId).replaceAll(" ", "");

		/**
		 * ligth灯
		 */
		if (fid.equals("c05e") && (did.equals("0000") || did.equals("0010")
				|| did.equals("0100") || did.equals("0110") || did.equals("0200")
				|| did.equals("0210") || did.equals("0220"))) {
			return DeviceTypeEnum.LIGTH.getVal();
		}

		/**
		 * 传感器
		 */
		  if (fid.equals("0104") && did.equals("0402")) { 
			  return  DeviceTypeEnum.SENSOR.getVal(); 
		  }
		 
		/**
		 * 插座
		 */
		if (fid.equals("0104") && did.equals("0009")) {
			return DeviceTypeEnum.MAINSPOWEROUTLET.getVal();
		}
		
		/**
		 * 智能插座
		 */
		if (fid.equals("0104") && did.equals("0051")) {
			return DeviceTypeEnum.ZMAINSPOWEROUTLET.getVal();
		}
		
		/**
		 * 温度湿度传感器
		 */
		if (fid.equals("0104") && did.equals("0302")) {
			return DeviceTypeEnum.TEMPERATURE_HUMIDITY.getVal();
		}
		/**
		 * 机械手柄
		 */
		if (fid.equals("0104") && did.equals("0002")) {
			return DeviceTypeEnum.MECHANICALHANDLE.getVal();
		}
		
		/**
		 * 未知设备
		 */
		else {
			return DeviceTypeEnum.UNKNOWN.getVal();
		}

	}
}
