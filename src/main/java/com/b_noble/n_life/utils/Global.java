package com.b_noble.n_life.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import io.netty.buffer.ByteBuf;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：全局变量
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class Global {
	
	
	/**
	 * 全局channel
	 */
	public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	/**
	 * 判断链接是否建立或正在建立链接
	 */
	public static String buf = "";  
	
	/**
	 * 全局snid
	 */
	public static String sncode = "";
	
	/**
	 * 全局token
	 */
	public static String token = "";
	
	/**
	 * 全局用户名
	 */
	public static String loginName = "";
	
	
	/**
	 * 全局响应
	 */
	public static ConcurrentHashMap<String, LinkedBlockingQueue<Object>> responses = new ConcurrentHashMap<String, LinkedBlockingQueue<Object>>();
	
	/**
	 * 全局ip
	 */
	public static Map<String, String> ips = new HashMap<String, String>();
	
	/**
	 * 全局返回
	 */
	public static int result = 0;
	
}
