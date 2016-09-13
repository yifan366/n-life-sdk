package com.b_noble.n_life;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述： 初始化类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class BaseApplication {
	
	public static Serial getInstance(){
		Serial serial =  new SerialSub();
		return serial;
	} 
}

