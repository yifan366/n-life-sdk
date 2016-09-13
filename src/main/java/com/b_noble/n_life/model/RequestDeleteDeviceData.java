package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：删除指定设备
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestDeleteDeviceData {

	private int addressMode = 0x02;  //地址模式
	
	private byte[] uid ;
	
	private byte[] ieeeAddress;
	
	private byte checkCode =0x07;
	
	private byte CRC8;
	
	public RequestDeleteDeviceData(byte[] uid, byte[] ieeeAddress,  byte cRC8) {
		super();
		this.uid = uid;
		this.ieeeAddress = ieeeAddress;
		CRC8 = cRC8;
	}

	public RequestDeleteDeviceData() {
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

	public byte[] getIeeeAddress() {
		return ieeeAddress;
	}

	public void setIeeeAddress(byte[] ieeeAddress) {
		this.ieeeAddress = ieeeAddress;
	}

	public byte getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(byte checkCode) {
		this.checkCode = checkCode;
	}

	public byte getCRC8() {
		return CRC8;
	}

	public void setCRC8(byte cRC8) {
		CRC8 = cRC8;
	}
	
	
}
