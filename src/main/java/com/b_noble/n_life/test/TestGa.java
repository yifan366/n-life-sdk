package com.b_noble.n_life.test;

import com.b_noble.n_life.BaseApplication;
import com.b_noble.n_life.Serial;
import com.b_noble.n_life.handler.MyClientInitializer;
import com.b_noble.n_life.utils.Global;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * sdk测试网关
 * @author Administrator
 *
 */
public class TestGa {

	public static void connect(int port,String host) throws Exception{
		//配置客户端NIO线程组
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			Bootstrap b = new Bootstrap();
			b.group(group);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.TCP_NODELAY, true);
			b.handler(new MyClientInitializer());
			
			
			//发起异步连接操作
			ChannelFuture f= b.connect(host, port).sync();
			
			if (f.isSuccess()) {
				System.out.println("建立成功链接");
				Global.group.add(f.channel());
			}
			//等待服务端监听端口关闭
			f.channel().closeFuture().sync();
		} finally{
			//优雅退出，释放资源
			group.shutdownGracefully();
		}
		
	}
	
	public static void main(String[] args)  {
		
		Serial s  = BaseApplication.getInstance();
		//s.connectLANZllByIp("ztzf.uicp.net", "ZTZF1001",15171);
		
		//s.connectLANZllByIp("192.168.1.118", "ZTZF1000",8009);
		
		//s.getGatewayIps();
		
		//System.out.println(s.getGatewayIps());
		
		System.out.println(s.connectRemoteZll("ztzf", "ztzf1234"));
		
	}
}
