package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：更新场景名称实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestUpdateSceneNameData {

	private int sceneid;

	private String sceneName;

	public RequestUpdateSceneNameData() {
		super();
	}

	public RequestUpdateSceneNameData(int sceneid, String sceneName) {
		super();
		this.sceneid = sceneid;
		this.sceneName = sceneName;
	}

	public int getSceneid() {
		return sceneid;
	}

	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}
}
