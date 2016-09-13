package com.b_noble.n_life.event;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：响应类型枚举类
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public enum ResponseTypeEnum {

	/**
	 * 获取当前所有设备响应
	 */
	RESPONSE_GET_DEVICE(0x26),
	
	/**
	 * 设置设备开关状态响应类型
	 */
	RESPONSE_SET_DEVICE_STATE(0x2E),
	
	/**
	 * 删除指定设备响应类型
	 */
	RESPONSE_DELETE_DEVICE(0x2C),
	
	/**
	 * 更新设备名称响应类型
	 */
	RESPONSE_UPDATE_DEVICENAME(0x2D),
	
	/**
	 * 获取设备的开关状态响应类型
	 */
	RESPONSE_GET_DEVICE_STATE(0x2F),
	
	/**
	 * 心跳响应类型
	 */
	RESPONSE_SEND_HEARTBEAT(0x28),
	
	/**
	 * 获取设备亮度相应类型
	 */
	RESPONSE_GET_DEVICE_LEVEL(0x31),
	
	/**
	 * 设置设备亮度响应类型
	 */
	RESPONSE_SET_DEVICE_LEVEL(0x30),
	
	/**
	 * 获取设备色调与饱和度响应类型
	 */
	RESPONSE_GET_DEVICE_HUE(0x33),
	
	/**
	 * 设置设备色调响应类型
	 */
	RESPONSE_SET_DEVICE_HUE(0x32),
	
	/**
	 * 获取设备色温响应类型
	 */
	RESPONSE_GET_DEVICE_COLORTEMPERATURE(0x35),
	
	/**
	 * 设置设备色温响应类型
	 */
	RESPONSE_SET_COLOR_TEMPERATURE(0x36),
	
	
	/**
	 * 获取组响应类型
	 */
	RESPONSE_GET_GROUP(0x0C),
	
	/**
	 * 添加指定设备到组响应类型
	 */
	REPOSNE_ADD_DEVICE_GROUP(0x0B),
	
	/**
	 * 从组中删除指定设备相应类型
	 */
	REPONSE_DELETE_DEVICE_GROUP(0x0F),
	
	/**
	 * 获取组成员名单响应类型
	 */
	REPONSE_GET_GROUP_MEMBER(0X10),
	
	/**
	 * 获取场景响应类型
	 */
	RESPONSE_GET_SENCE(0x4D),
	
	/**
	 * 添加/修改场景响应类型
	 */
	RESPONSE_ADD_SENCE(0x4A),
	
	/**
	 * 添加设备到场景
	 */
	REPOSNE_ADD_DEVICE_SENCE(0x4B),
	
	/**
	 * 获取场景成员详细信息响应类型
	 */
	RESPONSE_GET_SENCE_DETAILED(0x4F),
	
	/**
	 * 删除场景中的指定成员响应类型
	 */
	RESPONSE_DELETE_SENCE_MEMBER(0x4C),
	
	/**
	 * 更新场景名称响应类型
	 */
	RESPONSE_UPDATE_SCENENAME(0x50),
	
	/**
	 * 调用场景返回
	 */
	RESPONSE_RECALL_SCENE(0X4E),
	
	/**
	 * 删除场景返回
	 */
	RESPONSE_DELETE_SCENE(0X51),
	
	/**
	 * 获取定时任务响应类型
	 */
	RESPONSE_GET_TIMERTASK(0x11),
	
	/**
	 * 获取所有任务
	 */
	REPOSNE_GET_ALL_TASK(0x58),
	
	/**
	 * 添加定时任务响应类型
	 */
	RESPONSE_ADD_TASK(0x59),
	
	/**
	 * 获取任务详细
	 */
	REPOSNE_GET_TASKINFO(0x5C),
	
	/**
	 * 获取指定场景定时任务
	 */
	RESPONSE_TASK_SCENE(0x5D),
	
	/**
	 * 获取指定设备的联动任务
	 */
	RESPONSE_TASK_UID(0x5E),
	
	/**
	 * 删除定时任务响应类型
	 */
	RESPONSE_DELETE_TIMERTASK(0x13),
	
	/**
	 * 更新任务响应类型
	 */
	RESPONSE_UPDATE_TASK(0x5B),
	
	/**
	 * 获取网关信息响应类型
	 */
	RESPONSE_GET_GATE_INFO(0x20),
	
	/**
	 * 获取 RSSI响应类型
	 */
	RESPONSE_GET_RSSI(0x16),
	
	/**
	 * 获取所有任务响应类型
	 */
	RESPONSE_GET_ALL_TASK(0x25),
	
	/**
	 * 删除任务响应类型
	 */
	RESPONSE_DELETE_TASK(0x5A),
	
	/**
	 * 查看指定任务详情响应类型
	 */
	RESPONSE_GET_TASKDETAILED(0x24),
	
	/**
	 * 获取指定设备的色温响应类型
	 */
	RESPONSE_GET_TEMPERATURE(0x27),
	
	/**
	 * 对网关中一字符串信息操作响应类型
	 */
	RESPONSE_GATEWAY_STRING(0x28),
	
	/**
	 * 组改名响应类型
	 */
	RESPONSE_UPDATE_GROUPNAME(0xAF),
	
	/**
	 * 节点主动上报响应类型
	 */
	REPSONSE_NODE_REPORT(0xA1),
	
	/**
	 * 添加指定设备定时任务
	 */
	RESPONSE_ADD_TIMING_TASK(0x61),
	/**
	 * 删除指定设备定时任务
	 */
	RESPONSE_DELETE_TIMING_TASK(0x62),
	/**
	 * 更新设备定时任务
	 */
	RESPONSE_UPDATE_TIMING_TASK(0x63),
	
	/**
	 * 获取设备定时任务
	 */
	RESPONSE_GET_TIMING_TASK(0x64),
	
	/**
	 * 验证管理密码
	 */
	RESPONSE_VERIFICATION_MANAGERPWD(0X6B),
	
	/**
	 * 修改密码
	 */
	RESPONSE_MODIFY_PWD(0X6D),
	/**
	 * 局域网登录网关
	 */
	RESPONSE_LOGIN_LAN(0X6A)
	;
	
	private int v;

	private ResponseTypeEnum(int v) {

        this.v = v;
    }

	public int getVal() {
		return v;
	}

	public static ResponseTypeEnum valuesOf(int e) {
		ResponseTypeEnum[] vs = ResponseTypeEnum.values();
		if (vs == null || vs.length == 0) {
			return null;
		}
		for (ResponseTypeEnum event : vs) {
			if (event.getVal() == e) {
				return event;
			}
		}
		return null;
	}
}
