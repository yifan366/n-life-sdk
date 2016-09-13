package com.b_noble.n_life.utils;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

import com.b_noble.n_life.handler.getGatewayHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：app搜索本地网关帮助类（UDP方式广播）
 * @作者：zhangfan 
 * @date：2016-08-04 
 * @版本：V0.0.1
 */
public class BroadcastUdpUtils extends Thread {

	private static CountDownLatch threadsSignal;
	
	public BroadcastUdpUtils(CountDownLatch threadsSignal) {
		super();
		this.threadsSignal = threadsSignal;
	}
	
	@Override  
	public void run() {  
		BroadcastUdp(); 
	}

	private void BroadcastUdp() {
		// TODO Auto-generated method stub
		final NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.channel(NioDatagramChannel.class);
			bootstrap.group(nioEventLoopGroup);
			bootstrap.handler(new getGatewayHandler());
			// 监听端口
			ChannelFuture sync = bootstrap.bind(0).sync();
			Channel udpChannel = sync.channel();

			String data = "ZTZF_Gateway\r\n";
			udpChannel.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(data.getBytes(Charset.forName("UTF-8"))),
					new InetSocketAddress("255.255.255.255", 9188)));

			threadsSignal.countDown();
			
			udpChannel.closeFuture().sync();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			nioEventLoopGroup.shutdownGracefully();
		}
	}  
}
