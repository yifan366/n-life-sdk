package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：设置设备色温实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestSetColorTemperatureData {

	private int addressMode = 0x02;  //地址模式
	
	private byte[] uid; //uid
	
	private int colorTemperature; //色温
	
	private int switchTime; //切换时间

	
	public RequestSetColorTemperatureData(byte[] uid, int colorTemperature, int switchTime) {
		super();
		this.uid = uid;
		this.colorTemperature = colorTemperature;
		this.switchTime = switchTime;
	}

	public RequestSetColorTemperatureData() {
		super();
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

	public int getColorTemperature() {
		return colorTemperature;
	}

	public void setColorTemperature(int colorTemperature) {
		this.colorTemperature = colorTemperature;
	}

	public int getSwitchTime() {
		return switchTime;
	}

	public void setSwitchTime(int switchTime) {
		this.switchTime = switchTime;
	}
	
	
}
