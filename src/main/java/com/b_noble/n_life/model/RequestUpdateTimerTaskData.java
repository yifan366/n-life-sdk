package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：更新定时任务实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestUpdateTimerTaskData {

	private int taskType = 0x01; // 任务类型

	private String taskName; // 任务名称
	
	private int taskId; //任务id

	private int sceneId; // 触发场景id

	private int enable; // 0x01 enable scene, 0x00, stop scene

	private int alarm; // 是否警报任务
	
	private int week;//星期几
	private int hour;//时
	private int minute;//分
	private int Second; //秒
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
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return Second;
	}
	public void setSecond(int second) {
		Second = second;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
}
