package com.b_noble.n_life.handler;

import com.b_noble.n_life.handler.processing.EncoderProcessing;
import com.b_noble.n_life.model.RequestHead;
import com.b_noble.n_life.model.RequestMessage;
import com.b_noble.n_life.utils.Test16Binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居
 * 简述：请求消息编码类
 * 作者：zhangfan
 * 时间：2016-08-02
 * 版本：V0.0.1
 */
public class Encoder extends MessageToByteEncoder<Object> {

	
	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf buf) throws Exception {
		// TODO Auto-generated method stub

		RequestMessage requestMessage = (RequestMessage) msg;

		RequestHead head = requestMessage.getHeader();

		buf.writeByte(head.getHeader());
		
		buf.writeShort(head.getLength());

		buf.writeBytes(head.getSncode().getBytes());
		
		//自生成序列号
		buf.writeShort(head.getSeqNumber());
		
		buf.writeByte(head.getControlMark());

		buf.writeByte(head.getControlType());

		EncoderProcessing.processing(requestMessage, buf);
		
		//tbd 8 bytes
		for (int i = 0; i < 10; i++) {
			buf.writeByte(0x00);
		}
		
		/**
		 * 输出发送指令
		 */
		byte[] b = new byte[buf.readableBytes()];
		for (int i = 0; i < b.length; i++) {
			b[i] = buf.getByte(i);
		}
		System.out.println("发送指令：\n"+Test16Binary.bytes2hex03(b));
		
	}

}
