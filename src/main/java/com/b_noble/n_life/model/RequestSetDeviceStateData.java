package com.b_noble.n_life.model;
/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：设置设备开关状态实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestSetDeviceStateData {

	private int length = 0x0D;  //数据长度
	
	private int addressMode = 0x02;  //地址模式
	
	private byte[] uid ; 
	
	private int state; //开关状态

	public RequestSetDeviceStateData() {
		super();
	}

	public RequestSetDeviceStateData(byte[] uid, int state) {
		super();
		this.uid = uid;
		this.state = state;
	}



	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getAddressMode() {
		return addressMode;
	}

	public void setAddressMode(int addressMode) {
		this.addressMode = addressMode;
	}

	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}



	public byte[] getUid() {
		return uid;
	}


	public void setUid(byte[] uid) {
		this.uid = uid;
	}

	
	
	
}
