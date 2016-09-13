package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：获取任务详细实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestGetTaskInfoData {

	private int taskId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public RequestGetTaskInfoData(int taskId) {
		super();
		this.taskId = taskId;
	}

	public RequestGetTaskInfoData() {
		super();
	}
	
	
}
