package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：获取设备亮度等值实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestGetDeviceLevelData {


	private int addressMode = 0x02; // 地址模式

	private byte[] uid ;

	
	public RequestGetDeviceLevelData() {
		super();
	}


	public RequestGetDeviceLevelData(byte[] uid) {
		super();
		this.uid = uid;
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

	
	

}
