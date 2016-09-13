package com.b_noble.n_life.model;
/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：请求头实体，共占8个字节，其中包括 数据报长度（2字节），网关SN码（4字节），控制标示OxEF（1字节），控制类型（1字节）
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestHead {

	private byte header = (byte) 0xFE; //header
	
	private int length; //数据长度 
	
	private String sncode; //sn
	
	private short seqNumber; //自动生成序列号
	
	private int controlMark =  0x00; //控制标示
	
	private int controlType; //控制类型

	
	public RequestHead() {
		super();
	}


	public RequestHead(int length, String sncode, int controlType) {
		super();
		this.length = length;
		this.sncode = sncode;
		this.controlType = controlType;
	}


	public byte getHeader() {
		return header;
	}


	public void setHeader(byte header) {
		this.header = header;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public String getSncode() {
		return sncode;
	}


	public void setSncode(String sncode) {
		this.sncode = sncode;
	}


	public int getControlMark() {
		return controlMark;
	}


	public void setControlMark(int controlMark) {
		this.controlMark = controlMark;
	}


	public int getControlType() {
		return controlType;
	}


	public void setControlType(int controlType) {
		this.controlType = controlType;
	}


	@Override
	public String toString() {
		return "RequestHead [header=" + header + ", length=" + length + ", sncode=" + sncode + ", controlMark="
				+ controlMark + ", controlType=" + controlType + "]";
	}


	public short getSeqNumber() {
		return seqNumber;
	}


	public void setSeqNumber(short seqNumber) {
		this.seqNumber = seqNumber;
	}

	

	
	
	
	
}
