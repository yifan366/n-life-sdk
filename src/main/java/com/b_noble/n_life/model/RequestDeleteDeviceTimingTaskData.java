package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：删除设备定时任务
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestDeleteDeviceTimingTaskData {

	private byte timingID;
	
	private byte checkCode = 0x07;
	
	private byte CRC8 = 0x00;

	
	public RequestDeleteDeviceTimingTaskData() {
		super();
	}

	public RequestDeleteDeviceTimingTaskData(byte timingID) {
		super();
		this.timingID = timingID;
	}

	public byte getTimingID() {
		return timingID;
	}

	public void setTimingID(byte timingID) {
		this.timingID = timingID;
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
