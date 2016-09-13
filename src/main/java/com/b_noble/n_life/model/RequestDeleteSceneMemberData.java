package com.b_noble.n_life.model;

import java.util.List;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 删除指定场景的成员实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestDeleteSceneMemberData {

	//sceneID
	private int sceneID;
	
	//sceneName
	private String sceneName;
	
	List<byte[]> uids;

	
	public RequestDeleteSceneMemberData() {
		super();
	}

	public RequestDeleteSceneMemberData(int sceneID, String sceneName, List<byte[]> uids) {
		super();
		this.sceneID = sceneID;
		this.sceneName = sceneName;
		this.uids = uids;
	}

	public int getSceneID() {
		return sceneID;
	}

	public void setSceneID(int sceneID) {
		this.sceneID = sceneID;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public List<byte[]> getUids() {
		return uids;
	}

	public void setUids(List<byte[]> uids) {
		this.uids = uids;
	}
	
	
}
