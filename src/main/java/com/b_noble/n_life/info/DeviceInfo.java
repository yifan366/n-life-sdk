package com.b_noble.n_life.info;

import java.io.Serializable;

import com.b_noble.n_life.utils.DeviceTypeUtils;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：设备终端实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class DeviceInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deviceSnid;
	private String deviceName;
	private byte deviceStatus;// 设备是否在线；
	private byte deviceState; // 设备状态（灯:开、关)
	private byte[] uId ; //uid为设备的短地址 即为网关中设备的唯一标示
	private byte[] deviceId;
	private byte[] ProfileId;
	private short atrrId;
	private byte[] recentValue; //查询列表时设备的最近上报值
	
	public int type ; //设备类型  

	private int Sensordata = 0;// 用来存储传感器设备上传的数据
	private short clusterId;
	private short attribID;
	// 设备类型详细
	public byte hasColourable = 0;  //是否可调色
	public byte hasDimmable = 0; //是否可调光
	public byte hasSwitchable = 0; //是否可开关
	public byte hasThermometer = 0; //是否温度计
	public byte hasPowerUsage = 0; //是否有电量
	public byte hasOutSwitch = 0; //是否输出开关
	public byte hasSensor = 0; // 是传感器
	public byte issmartplug = 0; // 是智能开关
	
	public short zoneType = 0;
	private byte[] IEEE = new byte[8];
	public DeviceInfo() {
	
	}
	public DeviceInfo(String deviceName, byte[] uId, byte[] deviceId,
			byte[] profileId, byte hasColourable, byte hasDimmable,
			byte hasSwitchable, byte hasThermometer, byte hasPowerUsage,
			byte hasOutSwitch,  byte hasSensor, byte issmartplug, short zoneType) {
		super();
		this.deviceName = deviceName;
		this.uId = uId;
		this.deviceId = deviceId;
		ProfileId = profileId;
		this.hasColourable = hasColourable;
		this.hasDimmable = hasDimmable;
		this.hasSwitchable = hasSwitchable;
		this.hasThermometer = hasThermometer;
		this.hasPowerUsage = hasPowerUsage;
		this.hasOutSwitch = hasOutSwitch;
		this.hasSensor = hasSensor;
		this.issmartplug = issmartplug;
		this.zoneType = zoneType;
	}

	public DeviceInfo(byte[] uId, int data, short clusterId, short attribID,String deviceName) {
		// TODO Auto-generated constructor stub
		this.uId = uId;
		this.Sensordata = data;
		this.clusterId = clusterId;
		this.attribID = attribID;
		this.deviceName = deviceName;
	}
	public String getDeviceName() {
		if (deviceName == null) {
			return "";
		}
		return deviceName;
	}
	public String getDeviceSnid() {
		return deviceSnid;
	}
	public void setDeviceSnid(String deviceSnid) {
		this.deviceSnid = deviceSnid;
	}
	public byte getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(byte deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public byte getDeviceState() {
		return deviceState;
	}
	public void setDeviceState(byte deviceState) {
		this.deviceState = deviceState;
	}
	public byte[] getuId() {
		return uId;
	}
	public void setuId(byte[] uId) {
		this.uId = uId;
	}
	public byte[] getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(byte[] deviceId) {
		this.deviceId = deviceId;
	}
	public byte[] getProfileId() {
		return ProfileId;
	}
	public void setProfileId(byte[] profileId) {
		ProfileId = profileId;
	}
	public int getType() {
		
		return DeviceTypeUtils.getDeviceType(deviceId, ProfileId);
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSensordata() {
		return Sensordata;
	}
	public void setSensordata(int sensordata) {
		Sensordata = sensordata;
	}
	public short getClusterId() {
		return clusterId;
	}
	public void setClusterId(short clusterId) {
		this.clusterId = clusterId;
	}
	public short getAttribID() {
		return attribID;
	}
	public void setAttribID(short attribID) {
		this.attribID = attribID;
	}
	public byte getHasColourable() {
		return hasColourable;
	}
	public void setHasColourable(byte hasColourable) {
		this.hasColourable = hasColourable;
	}
	public byte getHasDimmable() {
		return hasDimmable;
	}
	public void setHasDimmable(byte hasDimmable) {
		this.hasDimmable = hasDimmable;
	}
	public byte getHasSwitchable() {
		return hasSwitchable;
	}
	public void setHasSwitchable(byte hasSwitchable) {
		this.hasSwitchable = hasSwitchable;
	}
	public byte getHasThermometer() {
		return hasThermometer;
	}
	public void setHasThermometer(byte hasThermometer) {
		this.hasThermometer = hasThermometer;
	}
	public byte getHasPowerUsage() {
		return hasPowerUsage;
	}
	public void setHasPowerUsage(byte hasPowerUsage) {
		this.hasPowerUsage = hasPowerUsage;
	}
	public byte getHasOutSwitch() {
		return hasOutSwitch;
	}
	public void setHasOutSwitch(byte hasOutSwitch) {
		this.hasOutSwitch = hasOutSwitch;
	}
	
	public byte getHasSensor() {
		return hasSensor;
	}
	public void setHasSensor(byte hasSensor) {
		this.hasSensor = hasSensor;
	}
	public byte getIssmartplug() {
		return issmartplug;
	}
	public void setIssmartplug(byte issmartplug) {
		this.issmartplug = issmartplug;
	}
	public short getZoneType() {
		return zoneType;
	}
	public void setZoneType(short zoneType) {
		this.zoneType = zoneType;
	}
	public byte[] getIEEE() {
		return IEEE;
	}
	public void setIEEE(byte[] iEEE) {
		IEEE = iEEE;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public short getAtrrId() {
		return atrrId;
	}
	public void setAtrrId(short atrrId) {
		this.atrrId = atrrId;
	}
	public byte[] getRecentValue() {
		return recentValue;
	}
	public void setRecentValue(byte[] recentValue) {
		this.recentValue = recentValue;
	}

	
	
}
