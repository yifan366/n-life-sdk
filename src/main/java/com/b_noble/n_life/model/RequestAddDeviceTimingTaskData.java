package com.b_noble.n_life.model;

import com.b_noble.n_life.info.TaskTimerAction;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 添加设备定时任务
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestAddDeviceTimingTaskData {

	private String timingName;
	
	private byte[] uid;
	
	private TaskTimerAction taskTimerAction;
	
	private byte switchState;
	
	private byte brightness;
	
	private byte hue;
	
	private byte saturation;
	
	private byte colorTemperature;
	
	private byte isenable;

	
	
	public RequestAddDeviceTimingTaskData() {
		super();
	}

	public RequestAddDeviceTimingTaskData(String timingName, byte[] uid, TaskTimerAction taskTimerAction,
			byte switchState, byte brightness, byte hue, byte saturation, byte colorTemperature, byte isenable) {
		super();
		this.timingName = timingName;
		this.uid = uid;
		this.taskTimerAction = taskTimerAction;
		this.switchState = switchState;
		this.brightness = brightness;
		this.hue = hue;
		this.saturation = saturation;
		this.colorTemperature = colorTemperature;
		this.isenable = isenable;
	}

	public String getTimingName() {
		return timingName;
	}

	public void setTimingName(String timingName) {
		this.timingName = timingName;
	}

	public byte[] getUid() {
		return uid;
	}

	public void setUid(byte[] uid) {
		this.uid = uid;
	}

	public TaskTimerAction getTaskTimerAction() {
		return taskTimerAction;
	}

	public void setTaskTimerAction(TaskTimerAction taskTimerAction) {
		this.taskTimerAction = taskTimerAction;
	}

	public byte getSwitchState() {
		return switchState;
	}

	public void setSwitchState(byte switchState) {
		this.switchState = switchState;
	}

	public byte getBrightness() {
		return brightness;
	}

	public void setBrightness(byte brightness) {
		this.brightness = brightness;
	}

	public byte getHue() {
		return hue;
	}

	public void setHue(byte hue) {
		this.hue = hue;
	}

	public byte getSaturation() {
		return saturation;
	}

	public void setSaturation(byte saturation) {
		this.saturation = saturation;
	}

	public byte getColorTemperature() {
		return colorTemperature;
	}

	public void setColorTemperature(byte colorTemperature) {
		this.colorTemperature = colorTemperature;
	}

	public byte getIsenable() {
		return isenable;
	}

	public void setIsenable(byte isenable) {
		this.isenable = isenable;
	}
	
	
}
