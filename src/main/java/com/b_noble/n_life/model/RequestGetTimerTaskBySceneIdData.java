package com.b_noble.n_life.model;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：获取场景定时任务实体
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class RequestGetTimerTaskBySceneIdData {

	private int sceneId;

	
	public RequestGetTimerTaskBySceneIdData(int sceneId) {
		super();
		this.sceneId = sceneId;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	
	
}
