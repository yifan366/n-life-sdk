package com.b_noble.n_life.model;

/**
 * app登录登录验证请求实体
 * @author Administrator
 *
 */
public class RequestLoginValidateData {

	private byte state;
	
	private String sn;
	
	private String token;

	private String loginName;
	
	public RequestLoginValidateData() {
		super();
	}

	
	
	public RequestLoginValidateData(byte state, String sn, String token, String loginName) {
		super();
		this.state = state;
		this.sn = sn;
		this.token = token;
		this.loginName = loginName;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	
}
