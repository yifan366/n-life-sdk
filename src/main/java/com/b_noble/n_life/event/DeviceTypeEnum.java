package com.b_noble.n_life.event;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：设备类型枚举类
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public enum DeviceTypeEnum {

	/**
	 * 未知设备
	 */
	UNKNOWN(-1),
	/**
	 * 彩灯
	 */
	LIGTH(1),
	/**
	 * 传感器
	 */
	SENSOR(2),
	/**
	 * 温度湿度传感器
	 */
	TEMPERATURE_HUMIDITY(3),
	
	/**
	 * 门磁
	 *//*
	DoorLock(4),*/
	/**
	 * 电源插座
	 */
	MAINSPOWEROUTLET(5),
	/**
	 * 智能插座
	 */
	ZMAINSPOWEROUTLET(6),
	
	/**
	 * 机械手柄
	 */
	MECHANICALHANDLE(7)
	;
	
	private int v;
	
	private DeviceTypeEnum(int v) {

        this.v = v;
    }

    public int getVal() {
        return v;
    }

    public static DeviceTypeEnum valuesOf(int e) {
    	DeviceTypeEnum[] vs = DeviceTypeEnum.values();
        if (vs == null || vs.length == 0) {
            return null;
        }
        for (DeviceTypeEnum event : vs) {
            if (event.getVal() == e) {
                return event;
            }
        }
        return null;
    }
}
