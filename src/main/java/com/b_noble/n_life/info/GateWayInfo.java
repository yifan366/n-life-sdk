package com.b_noble.n_life.info;

import java.io.Serializable;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：网关信息实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class GateWayInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String version;
	
	private String sn;
	
	private String user;
	
	private String passwrd;
	
	private byte totalDevices;
	
	private byte totalGroup;
	
	private byte totalTimers;
	
	private byte totalScenes;
	
	private byte totalTasks;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public byte getTotalDevices() {
		return totalDevices;
	}

	public void setTotalDevices(byte totalDevices) {
		this.totalDevices = totalDevices;
	}

	public byte getTotalGroup() {
		return totalGroup;
	}

	public void setTotalGroup(byte totalGroup) {
		this.totalGroup = totalGroup;
	}

	public byte getTotalTimers() {
		return totalTimers;
	}

	public void setTotalTimers(byte totalTimers) {
		this.totalTimers = totalTimers;
	}

	public byte getTotalScenes() {
		return totalScenes;
	}

	public void setTotalScenes(byte totalScenes) {
		this.totalScenes = totalScenes;
	}

	public byte getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(byte totalTasks) {
		this.totalTasks = totalTasks;
	}

	@Override
	public String toString() {
		return "GateWayInfo [version=" + version + ", sn=" + sn + ", user=" + user + ", passwrd=" + passwrd
				+ ", totalDevices=" + totalDevices + ", totalGroup=" + totalGroup + ", totalTimers=" + totalTimers
				+ ", totalScenes=" + totalScenes + ", totalTasks=" + totalTasks + "]";
	}
	
	
}
