package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：设置设备开关状态实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestSetDeviceLevelData {

	private int addressMode = 0x02;  //地址模式
	
	private byte[] uid; //uid
	
	private int levelValue; //亮度值
	
	private int switchTime; //切换时间1

	
	
	public RequestSetDeviceLevelData() {
		super();
	}



	public RequestSetDeviceLevelData(byte[] uid, int levelValue, int switchTime) {
		super();
		this.uid = uid;
		this.levelValue = levelValue;
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



	public int getLevelValue() {
		return levelValue;
	}



	public void setLevelValue(int levelValue) {
		this.levelValue = levelValue;
	}



	public int getSwitchTime() {
		return switchTime;
	}



	public void setSwitchTime(int switchTime) {
		this.switchTime = switchTime;
	}


	
	
	
}
