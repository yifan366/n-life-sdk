package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：添加任务请求实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestAddTaskData {

	private int taskType = 0x02; //任务类型
	
	private String taskName; // 任务名称
	
	private int sceneId; //触发场景id
	
	private int enable; // 0x01 enable scene, 0x00, stop scene
	
	private int alarm; //是否警报任务
	
	private byte[] uid; // 包括shortAddress endPoint 3个字节
	
	private byte[] deviceId; // deviceID
	
	private int Condition1; //条件1 ：0x00 none 0x01 person; 0x00 close, 0x01open door
	
	private int value1; //Value1
	
	private int Condition2;//条件2 ：:0x00 smaller, 0x01 equal 0x02 bigger 
	
	private int value2; //Value2

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getAlarm() {
		return alarm;
	}

	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	public byte[] getUid() {
		return uid;
	}

	public void setUid(byte[] uid) {
		this.uid = uid;
	}

	public byte[] getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(byte[] deviceId) {
		this.deviceId = deviceId;
	}

	public int getCondition1() {
		return Condition1;
	}

	public void setCondition1(int condition1) {
		Condition1 = condition1;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getCondition2() {
		return Condition2;
	}

	public void setCondition2(int condition2) {
		Condition2 = condition2;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}
	
	
	
}
