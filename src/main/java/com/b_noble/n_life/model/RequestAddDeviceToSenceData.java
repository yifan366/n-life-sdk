package com.b_noble.n_life.model;

import java.util.List;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 添加设备到场景实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestAddDeviceToSenceData {

	private int sceneID;//sceneID
	
	private int totalAdddevices; //totalAdddevices
	
	private List<byte[]> uids; 
	
	private int delayTime;
	
	public RequestAddDeviceToSenceData() {
		super();
	}

	public RequestAddDeviceToSenceData(int sceneID, int totalAdddevices, List<byte[]> uids, int delayTime) {
		super();
		this.sceneID = sceneID;
		this.totalAdddevices = totalAdddevices;
		this.uids = uids;
		this.delayTime = delayTime;
	}

	public int getSceneID() {
		return sceneID;
	}

	public void setSceneID(int sceneID) {
		this.sceneID = sceneID;
	}

	public int getTotalAdddevices() {
		return totalAdddevices;
	}

	public void setTotalAdddevices(int totalAdddevices) {
		this.totalAdddevices = totalAdddevices;
	}

	public List<byte[]> getUids() {
		return uids;
	}

	public void setUids(List<byte[]> uids) {
		this.uids = uids;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}
	
	
}
