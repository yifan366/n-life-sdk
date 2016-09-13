package com.b_noble.n_life.handler;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：消息解码类，主要是解决粘包/断包问题
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public class Decoder extends ByteToMessageDecoder{

	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

		int readable = in.readableBytes();
		
		in.markReaderIndex();  
		
		byte header = in.readByte();
		
		int frameLength = in.readShort();
		
		in.resetReaderIndex();
		if (readable < frameLength) {
			
			return;
		}
		
		ByteBuf frame = in.readBytes(frameLength);
		
		out.add(frame);
	}

}
