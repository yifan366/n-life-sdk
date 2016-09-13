package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 修改密码实体类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestModifyPwdData {

	private byte state;
	
	private byte pwdType;
	
	private String username;
	
	private String oldPwd;
	
	private String newPwd;

	
	
	public RequestModifyPwdData(byte state, byte pwdType, String username, String oldPwd, String newPwd) {
		super();
		this.state = state;
		this.pwdType = pwdType;
		this.username = username;
		this.oldPwd = oldPwd;
		this.newPwd = newPwd;
	}

	public RequestModifyPwdData() {
		super();
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public byte getPwdType() {
		return pwdType;
	}

	public void setPwdType(byte pwdType) {
		this.pwdType = pwdType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
}
