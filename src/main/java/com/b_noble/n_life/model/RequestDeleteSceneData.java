package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 删除场景请求实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestDeleteSceneData {

	private int sceneid;
	
	private String sceneName;
	
	public RequestDeleteSceneData() {
		super();
	}

	public RequestDeleteSceneData(int sceneid, String sceneName) {
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
