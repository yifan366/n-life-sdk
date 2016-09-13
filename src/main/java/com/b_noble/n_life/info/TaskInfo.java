package com.b_noble.n_life.info;

import java.io.Serializable;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：任务实体类，包括场景定时任务、联动任务
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class TaskInfo implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 任务id。it can only get from gateway ,don't modify it
    private short taskId;
    // 任务名
    private String taskName;
    //第一个动作类型
    private byte taskType;
    //判断该任务触发时，是否会报警
    private byte isAlarm;
    //使能位
    private byte isAble;

    private TaskTimerAction taskTimerAction;
    
    private TaskDeviceAction taskDeviceAction;
    
    private byte sceneId;
    
    public TaskInfo() {
		super();
	}

    
    
	public TaskInfo(short taskId, String taskName, byte taskType, byte isAlarm, byte isAble,
			TaskDeviceAction taskDeviceAction,byte sceneId) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskType = taskType;
		this.isAlarm = isAlarm;
		this.isAble = isAble;
		this.taskDeviceAction = taskDeviceAction;
		this.sceneId = sceneId;
	}



	public TaskInfo(short taskId, String taskName, byte taskType, byte isAlarm, byte isAble,
			TaskTimerAction taskTimerAction) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskType = taskType;
		this.isAlarm = isAlarm;
		this.isAble = isAble;
		this.taskTimerAction = taskTimerAction;
	}

	@Override
	public String toString() {
		return "TaskInfo [taskId=" + taskId + ", taskName=" + taskName + ", taskType=" + taskType + ", isAlarm="
				+ isAlarm + ", isAble=" + isAble + "]" +taskTimerAction.toString();
	}
	
	public String toString1() {
		return "TaskInfo [taskId=" + taskId + ", taskName=" + taskName + ", taskType=" + taskType + ", isAlarm="
				+ isAlarm + ", isAble=" + isAble + "]";
	}
	
	public String toTaskDeviceActionString() {
		return "TaskInfo [taskId=" + taskId + ", taskName=" + taskName + ", taskType=" + taskType + ", isAlarm="
				+ isAlarm + ", isAble=" + isAble + "]" +taskDeviceAction.toString();
	}

	public short getTaskId()
    {
        return taskId;
    }

    public void setTaskId(short taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public byte getTaskType()
    {
        return taskType;
    }

    public void setTaskType(byte taskType)
    {
        this.taskType = taskType;
    }

    public byte getIsAlarm()
    {
        return isAlarm;
    }

    public void setIsAlarm(byte isAlarm)
    {
        this.isAlarm = isAlarm;
    }
	
		public byte getIsAble() {
		return isAble;
	}

	public void setIsAble(byte isAble) {
		this.isAble = isAble;
	}

	public TaskTimerAction getTaskTimerAction() {
		return taskTimerAction;
	}

	public void setTaskTimerAction(TaskTimerAction taskTimerAction) {
		this.taskTimerAction = taskTimerAction;
	}

	public TaskDeviceAction getTaskDeviceAction() {
		return taskDeviceAction;
	}

	public void setTaskDeviceAction(TaskDeviceAction taskDeviceAction) {
		this.taskDeviceAction = taskDeviceAction;
	}



	public byte getSceneId() {
		return sceneId;
	}



	public void setSceneId(byte sceneId) {
		this.sceneId = sceneId;
	}
	
	
}
