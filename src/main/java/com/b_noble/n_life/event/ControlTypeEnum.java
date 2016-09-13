package com.b_noble.n_life.event;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：控制类型枚举类
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public enum ControlTypeEnum {

	/**
	 * 获取当前所有设备
	 */
	GET_DEVICE(0x86),
	
	/**
	 * 发送心跳包
	 */
	SEND_HEARTBEAT(0X88),
	
	/**
	 * 设置指定设备开关状态
	 */
	SET_DEVICE_STATE(0x8E),
	
	/**
	 * 设置指定设备的亮度
	 */
	SET_DEVICE_LEVEL(0x90),
	
	/**
	 * 设置指定设备颜色
	 */
	SET_DEVICE_COLOR(0x92),
	
	/**
	 * 获取指定设备的开关状态
	 */
	GET_DEVICE_STATE(0x8F),
	
	/**
	 * 获取指定设备的亮度
	 */
	GET_DEVICE_LEVEL(0X91),
	
	/**
	 * 获取指定设备的色调
	 */
	GET_DEVICE_HUE(0X93),
	
	/**
	 * 获取指定设备的饱和度
	 */
	GET_DEVICE_SATURATION(0X88),
	
	/**
	 * 获取指定设备色温
	 */
	GET_DEVICE_COLORTEMPERATURE(0x95),
	
	/**
	 * 绑定设备
	 */
	BIND_DEVICE(0X89),
	
	/**
	 * 获取场景成员
	 */
	GET_SENCE_MEMBER(0XAF),
	
	/**
	 * 删除场景成员
	 */
	DELETE_SENCE_MEMBER(0XAC),
	
	/**
	 * 修改场景名称
	 */
	UPDATE_SENCE_NAME(0XB0),
	
	/**
	 * 获取组
	 */
	GET_GROUP(0X8E),
	
	/**
	 * 添加指定设备到组
	 */
	ADD_DEVICE_GROUP(0X8F),
	
	/**
	 * 获取场景
	 */
	GET_SENCE(0XAD),
	
	/**
	 * 添加场景
	 */
	ADD_SENCE(0XAA),
	
	/**
	 * 添加设备到场景
	 */
	ADD_DEVICE_SENCE(0xAB),
	
	/**
	 * 调用场景
	 */
	RECALL_SENCE(0XB7),
	
	/**
	 * 删除场景
	 */
	DELETE_SENCE(0XB1),
	
	/**
	 * 更改指定设备名
	 */
	UPDATE_DEVICE_NAME(0X8D),
	
	/**
	 * 删除指定设备
	 */
	DELETE_DEVICE(0X8C),
	
	/**
	 * 取消绑定
	 */
	UNBIND_DEVICE(0X96),
	
	/**
	 * 从组中删除指定设备
	 */
	DELTEE_DEVICE_GROUP(0X97),
	
	/**
	 * 获取组成员名单
	 */
	GET_GROUP_MEMBER(0X98),
	
	/**
	 * 获取定时任务
	 */
	GET_TIMERTASK(0X99),
	
	/**
	 * 添加定时任务
	 */
	ADD_TIMERTASK(0X9A),
	
	/**
	 * 获取指定场景的定时任务
	 */
	GET_TASK_SCENE(0XBD),
	
	/**
	 * 获取指定设备的联动任务
	 */
	GET_TASK_UID(0XBE),
	
	/**
	 * 删除定时任务
	 */
	DELETE_TIMERTASK(0X9B),
	
	/**
	 * 修改任务
	 */
	UPDATE_TASK(0XBB),
	
	/**
	 * 获取网关信息
	 */
	GET_GATEWAY_INFO(0X80),
	
	/**
	 * 设置传感器上报时间
	 */
	SET_SENSOR_TIME(0X9E),
	
	/**
	 * 允许入网
	 */
	ALLOW_NET(0X82),
	
	/**
	 * 打开/关闭在线查询
	 */
	UPDATE_NETQUERY_STATE(0XA0),
	
	/**
	 * 复位网关
	 */
	RESET_GATEWAY(0XA1),
	
	/**
	 * 0xA2 获取 RSSI
	 */
	GET_RSSI(0XA2),
	
	/**
	 * 增加任务
	 */
	ADD_TASK(0XB9),
	
	/**
	 * 删除任务
	 */
	DELETE_TASK(0XBA),
	
	/**
	 * 查看任务详情
	 */
	GET_TASK_INFO(0XBC),
	
	/**
	 * 获取所有任务
	 */
	GET_ALL_TASK(0XB8),
	
	/**
	 * 红外相关
	 */
	IR_RELEVANT(0XA7),
	
	/**
	 * 设置设备色温
	 */
	SET_COLOR_TEMPERATURE(0X96),
	
	/**
	 * 获取设备色温
	 */
	GET_COLOR_TEMPERATURE(0XA9),
	
	/**
	 * 对网关中一字符串信息操作
	 */
	OPER_GATEWAY_STRING(0XAB),
	
	/**
	 * cie相关指令
	 */
	CIE_RELEVANT(0XAC),
	
	/**
	 * 网关和 ZigBee 信息相关
	 */
	GATEWAY_ZIGBEE_RELEVANT(0XAE),
	
	/**
	 * 修改组名
	 */
	UPDATE_GROUP_NAME(0XAF),
	
	/**
	 * 添加设备定时任务
	 */
	ADD_TIMING_TASK(0XC1),
	
	/**
	 * 删除设备定时任务
	 */
	DELETE_TIMING_TASK(0XC2),
	
	/**
	 * 更新设备定时任务
	 */
	UPDATE_TIMING_TASK(0XC3),
	
	/**
	 * 获取设备定时任务
	 */
	GET_TIMING_TASK(0xC4),
	
	/**
	 * 登录验证指令
	 */
	LOGIN_VALODATE(0xDF),
	/**
	 * 验证管理密码
	 */
	VERIFICATION_MANAGERPWD(0xCB),
	/**
	 * 修改密码
	 */
	MODIFY_PASSWORD(0XCD),
	/**
	 * 局域网登录网关
	 */
	LOGIN_GA_LAN(0xCA);
	
	private int v;
	
	private ControlTypeEnum(int v) {

        this.v = v;
    }

    public int getVal() {
        return v;
    }

    public static ControlTypeEnum valuesOf(int e) {
    	ControlTypeEnum[] vs = ControlTypeEnum.values();
        if (vs == null || vs.length == 0) {
            return null;
        }
        for (ControlTypeEnum event : vs) {
            if (event.getVal() == e) {
                return event;
            }
        }
        return null;
    }
}
