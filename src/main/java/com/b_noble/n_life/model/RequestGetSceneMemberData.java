package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：获取场景中的成员实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestGetSceneMemberData {

	private int sceneID;

	public int getSceneID() {
		return sceneID;
	}

	public void setSceneID(int sceneID) {
		this.sceneID = sceneID;
	}

	public RequestGetSceneMemberData(int sceneID) {
		super();
		this.sceneID = sceneID;
	}

	public RequestGetSceneMemberData() {
		super();
	}
	
	
}
