package com.b_noble.n_life.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：handler初始化类
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast("encoder", new Encoder());
		pipeline.addLast("decoder", new Decoder());
		pipeline.addLast("handler",new ClientHandler());
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println("---channelRead--- msg="+msg);
		super.channelRead(ctx, msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("---channelReadComplete---");
		super.channelReadComplete(ctx);
	}
	
}
