package com.b_noble.n_life.model;
/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：设置设备颜色实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestSetDeviceColorData {

	private int addressMode = 0x02;  //地址模式
	
	private byte[] uid; //uid
	
	private int hue; //色调
	
	private int sat; //饱和度
	
	private int switchTime; //切换时间
	
	public RequestSetDeviceColorData() {
		super();
	}
	
	

	public RequestSetDeviceColorData(byte[] uid, int hue, int sat, int switchTime) {
		super();
		this.uid = uid;
		this.hue = hue;
		this.sat = sat;
		this.switchTime = switchTime;
	}



	public int getAddressMode() {
		return addressMode;
	}

	public void setAddressMode(int addressMode) {
		this.addressMode = addressMode;
	}

	public byte[] getUid() {
		return uid;
	}

	public void setUid(byte[] uid) {
		this.uid = uid;
	}

	public int getHue() {
		return hue;
	}

	public void setHue(int hue) {
		this.hue = hue;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}

	public int getSwitchTime() {
		return switchTime;
	}

	public void setSwitchTime(int switchTime) {
		this.switchTime = switchTime;
	}
	
	
	
	
	
	
}
