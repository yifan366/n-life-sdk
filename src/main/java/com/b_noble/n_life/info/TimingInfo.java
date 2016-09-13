package com.b_noble.n_life.info;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：设备定时任务详细信息实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class TimingInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private byte timingID;
	
	private String timingName;
	
	private byte[] uid;
	
	private TaskTimerAction taskTimerAction;
	
	private byte switchState;
	
	private byte brightness;
	
	private byte hue;
	
	private byte saturation;
	
	private byte colorTemperature;
	
	private byte enable;

	
	@Override
	public String toString() {
		return "TimingInfo [timingID=" + timingID + ", timingName=" + timingName + ", uid=" + Arrays.toString(uid)
				+ ", taskTimerAction=" + taskTimerAction.toString() + ", switchState=" + switchState + ", brightness=" + brightness
				+ ", hue=" + hue + ", saturation=" + saturation + ", colorTemperature=" + colorTemperature + ", enable="
				+ enable + "]";
	}

	public TimingInfo() {
		super();
	}

	public TimingInfo(byte timingID, String timingName, byte[] uid, TaskTimerAction taskTimerAction, byte switchState,
			byte brightness, byte hue, byte saturation, byte colorTemperature, byte enable) {
		super();
		this.timingID = timingID;
		this.timingName = timingName;
		this.uid = uid;
		this.taskTimerAction = taskTimerAction;
		this.switchState = switchState;
		this.brightness = brightness;
		this.hue = hue;
		this.saturation = saturation;
		this.colorTemperature = colorTemperature;
		this.enable = enable;
	}

	public byte getTimingID() {
		return timingID;
	}

	public void setTimingID(byte timingID) {
		this.timingID = timingID;
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

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}
	
	
}
