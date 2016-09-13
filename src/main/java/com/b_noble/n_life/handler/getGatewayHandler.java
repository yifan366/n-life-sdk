package com.b_noble.n_life.handler;

import com.b_noble.n_life.utils.Global;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司 
 * 项目：智能家居 
 * 简述：UDP广播方式搜索网关handler 
 * 作者：zhangfan 
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public class getGatewayHandler extends SimpleChannelInboundHandler<DatagramPacket> {


	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket datagramPacket) throws Exception {
		// TODO Auto-generated method stub
		String req = datagramPacket.content().toString(CharsetUtil.UTF_8);

		System.out.println("客户端接收：" + req);

		Global.ips.put(datagramPacket.sender().getHostString(), req.split(":")[1]);
	}

}
