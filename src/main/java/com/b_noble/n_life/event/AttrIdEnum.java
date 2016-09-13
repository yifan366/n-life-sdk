package com.b_noble.n_life.event;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：传感器分类枚举类
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public enum AttrIdEnum {

	/**
	 * 标准cie
	 */
	STANDARD_CIE(0X0000),
	
	/**
	 * 运动传感器(红外)
	 */
	MOTION_SENSOR(0X000d),
	
	/**
	 * 接触式传感器(门磁)
	 */
	CONTACK_SENSOR(0X0015),
	
	/**
	 * 火情传感器(烟雾)
	 */
	FIRE_SENSOR(0x0028),
	
	/**
	 * 水浸传感器
	 */
	WATER_SENSOR(0X002a),
	
	/**
	 * 空气传感器(燃气传感器)
	 */
	GAS_SENSOR(0X002b),
	
	/**
	 * (紧急按钮)
	 */
	PERSONAL_EMERGENCY(0x002c),
	
	/**
	 * 震动或移动传感器
	 */
	VIBRATION_MOVEMENT(0X002d),
	
	/**
	 * 远程控制
	 */
	REMOTE_CONTROL(0X010F),
	
	/**
	 * （多功能遥控器）
	 */
	KEY_FOB(0X0115),
	
	/**
	 * 键盘
	 */
	KET_PAD(0X021d),
	
	/**
	 * 标准的警报设备
	 */
	STANDARD_WARNING(0X0225),
	
	/**
	 * 鬼知道什么传感器
	 */
	CLASS_BREGLASS_BREAK_SENSOEAK_SENSOR(0x0226),
	
	/**
	 * 安全中继器
	 */
	SECURITY_REPEATER(0X0229),
	
	
	/**
	 * 一氧化碳传感器
	 */
	CO_SENSOR(-32767);
	
	
	
	
	private int v;
	
	private AttrIdEnum(int v) {

        this.v = v;
    }

    public int getVal() {
        return v;
    }

    public static AttrIdEnum valuesOf(int e) {
    	AttrIdEnum[] vs = AttrIdEnum.values();
        if (vs == null || vs.length == 0) {
            return null;
        }
        for (AttrIdEnum event : vs) {
            if (event.getVal() == e) {
                return event;
            }
        }
        return null;
    }
}
