package com.b_noble.n_life.utils;

import java.util.concurrent.CountDownLatch;

import com.b_noble.n_life.BaseApplication;
import com.b_noble.n_life.handler.MyClientInitializer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @公司：深圳市中泰智丰物联网科技有限公司
 * @项目：智能家居
 * @简述：netty客户端连接帮助类
 * @作者：zhangfan @date：2016-08-04 @版本：V0.0.1
 */
public class SocketUtil extends Thread {

	private static NioEventLoopGroup group;

	String host;
	int port;

	private static CountDownLatch threadsSignal;

	public SocketUtil() {
		super();
	}

	public SocketUtil(String host, int port, CountDownLatch threadsSignal) {
		super();
		this.host = host;
		this.port = port;
		this.threadsSignal = threadsSignal;
	}

	@Override
	public void run() {
		connected(host, port);
	}

	// 连接到Socket服务端
	public static void connected(final String host, final int port) {

		if (Global.buf.equals("")) {

			Global.buf = "linking";

			if (Global.group.size() > 0) {
				Global.group.close();
				Global.group.clear();
			}

			// 配置客户端NIO线程组
			EventLoopGroup group = new NioEventLoopGroup();

			try {
				Bootstrap b = new Bootstrap();
				b.group(group);
				b.channel(NioSocketChannel.class);
				b.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
				b.option(ChannelOption.TCP_NODELAY, true);
				b.handler(new MyClientInitializer());
				// 发起异步连接操作
				ChannelFuture f = b.connect(host, port).sync();

				if (f.isSuccess()) {
					System.out.println("建立链接成功");
					Global.group.add(f.channel());
					threadsSignal.countDown();// 线程结束时计数器减1
				}
				// 等待服务端监听端口关闭
				f.channel().closeFuture().await();
			} catch (Exception e) {
				threadsSignal.countDown();// 线程结束时计数器减1
				System.out.println("链接异常");
				Global.buf = "";
				BaseApplication.getInstance().clientClose();
			} finally {
				// 优雅退出，释放资源
				group.shutdownGracefully();
			}
		}

	}
}
