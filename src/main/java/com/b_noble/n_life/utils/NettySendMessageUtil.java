package com.b_noble.n_life.utils;

import com.b_noble.n_life.model.RequestMessage;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：netty客户端发送命令类
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class NettySendMessageUtil {

	public static Object send(RequestMessage requestMessage) {
		
		Global.group.writeAndFlush(requestMessage);
		
		return "response time out!";
		
	}
}
