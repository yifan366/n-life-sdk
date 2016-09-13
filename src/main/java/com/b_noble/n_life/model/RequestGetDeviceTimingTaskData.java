package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：获取设备定时任务实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestGetDeviceTimingTaskData {

	private byte[] uid;

	
	public RequestGetDeviceTimingTaskData() {
		super();
	}

	public RequestGetDeviceTimingTaskData(byte[] uid) {
		super();
		this.uid = uid;
	}

	public byte[] getUid() {
		return uid;
	}

	public void setUid(byte[] uid) {
		this.uid = uid;
	}
	
	
}
