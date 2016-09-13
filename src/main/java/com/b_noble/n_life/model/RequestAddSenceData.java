package com.b_noble.n_life.model;

import java.util.List;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 添加场景实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestAddSenceData {

	private String senceName;
	
	private int totalDevices;
	
	private List<byte[]> uid;
	
	private int delayTime;

	public RequestAddSenceData(String senceName, int totalDevices, List<byte[]> uid, int delayTime) {
		super();
		this.senceName = senceName;
		this.totalDevices = totalDevices;
		this.uid = uid;
		this.delayTime = delayTime;
	}

	public RequestAddSenceData() {
		super();
	}

	public String getSenceName() {
		return senceName;
	}

	public void setSenceName(String senceName) {
		this.senceName = senceName;
	}

	public int getTotalDevices() {
		return totalDevices;
	}

	public void setTotalDevices(int totalDevices) {
		this.totalDevices = totalDevices;
	}

	public List<byte[]> getUid() {
		return uid;
	}

	public void setUid(List<byte[]> uid) {
		this.uid = uid;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}
	
	
}
