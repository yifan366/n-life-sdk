package com.b_noble.n_life.model;


/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：验证网关管理密码请求实体
 * @作者：zhangfan 
 * @date：2016-08-31 
 * @版本：V0.0.1
 */
public class RequestVerificationManagerPwdData {

	private byte state;
	
	private String username;
	
	private String managerPwd;

	
	
	public RequestVerificationManagerPwdData() {
		super();
	}

	public RequestVerificationManagerPwdData(byte state, String username, String managerPwd) {
		super();
		this.state = state;
		this.username = username;
		this.managerPwd = managerPwd;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	
	
}
