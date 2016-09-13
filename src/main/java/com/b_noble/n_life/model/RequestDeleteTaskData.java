package com.b_noble.n_life.model;
/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：删除指定任务实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestDeleteTaskData {

	private int taskid;//taskid
	
	private byte checkCode = 0x07;
	
	private byte CRC8 ;

	
	public RequestDeleteTaskData(int taskid, byte cRC8) {
		super();
		this.taskid = taskid;
		CRC8 = cRC8;
	}

	public RequestDeleteTaskData() {
		super();
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public byte getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(byte checkCode) {
		this.checkCode = checkCode;
	}

	public byte getCRC8() {
		return CRC8;
	}

	public void setCRC8(byte cRC8) {
		CRC8 = cRC8;
	}
	
	
}
