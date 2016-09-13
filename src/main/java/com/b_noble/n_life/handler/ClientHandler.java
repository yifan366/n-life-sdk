package com.b_noble.n_life.handler;

import com.b_noble.n_life.BaseApplication;
import com.b_noble.n_life.Serial;
import com.b_noble.n_life.handler.processing.HandlerProcessing;
import com.b_noble.n_life.utils.Global;
import com.b_noble.n_life.utils.Test16Binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：客户端handler
 * @作者：zhangfan @date：2016-08-02 @版本：V0.0.1
 */
public class ClientHandler extends ChannelInboundHandlerAdapter  {

	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

		
		Global.result = 1;
		Global.group.add(ctx.channel());

		Serial s = BaseApplication.getInstance();
		
		s.clientActive();
		
	
	
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) {

		ByteBuf buf = (ByteBuf) msg;

		int count = buf.readableBytes();
		System.out.println(count);
		byte[] b = new byte[count];
		
		if (count >= 4) {
			byte header = buf.readByte();
			short totalLength = buf.readShort();
			
			//sn
			byte[] sn = new byte[8];
			buf.readBytes(sn);
			//seqNumber
			buf.readShort();
			//controlFlag
			buf.readByte();
			
			int responseType = buf.readByte();

			if (totalLength == count && totalLength != 36 && totalLength != 37) {
				HandlerProcessing.processing(responseType, buf);
			}
			/**
			 * report new device返回
			 */
			else if (totalLength == 37) {

				HandlerProcessing.reportNewDevice(buf);

			}
			/**
			 * 传感器推送
			 */
			else if (totalLength == 36) {
				HandlerProcessing.sensorReport(buf);
			}
		}

		/**
		 * 接收原始指令
		 */
		byte[] yb = new byte[count];

		buf.resetReaderIndex();
		for (int i = 0; i < count; i++) {
			yb[i] = buf.readByte();
		}
		System.out.println("响应指令：\n" + Test16Binary.bytes2hex03(yb));

	}

	public void handlerRemoved(ChannelHandlerContext ctx) {

		System.out.println("handlerRemoved(链接关闭)");
		
		Global.buf = "";
		if (Global.group.size() > 0) {

			Global.group.close();
			Global.group.clear();
		}
		BaseApplication.getInstance().clientClose();

	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable throwable) {
		// 释放资源
		System.out.println("exceptionCaught:" + throwable.getMessage());

		Global.buf = "";
		if (Global.group.size() > 0) {
			Global.group.close();
			Global.group.clear();
		}

		ctx.close();
	}

}
