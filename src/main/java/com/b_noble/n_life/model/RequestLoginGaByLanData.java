package com.b_noble.n_life.model;

/**
 * 局域网登录网关实体
 * @author Administrator
 *
 */
public class RequestLoginGaByLanData {

	private byte state;
	
	private String userName;
	
	private String passWord;

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public RequestLoginGaByLanData() {
		super();
	}

	public RequestLoginGaByLanData(byte state, String userName, String passWord) {
		super();
		this.state = state;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
}
