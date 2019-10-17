package com.yukms.learn.chapter3;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

public class NettyOioServer {
    public void server(int port) throws Exception {
        final ByteBuf msg = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi!\r\n", StandardCharsets.UTF_8));
        // 使用OioEventLoopGroup以允许阻塞模式
        EventLoopGroup group = new OioEventLoopGroup();
        try {
            // 创建ServerBootstrap
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)//
                .channel(OioServerSocketChannel.class)//
                .localAddress(new InetSocketAddress(port))//
                // 指定ChannelInitializer，对于每个已接受的连接都调用它
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel socketChannel) throws Exception {
                        // 添加一个ChannelInboundHandlerAdapter以拦截和处理事件
                        socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                // 将消息写到客户端，并添加ChannelFutureListener，以便消息一被写完就关闭连接
                                ctx.writeAndFlush(msg.duplicate()).addListener(ChannelFutureListener.CLOSE);
                            }
                        });
                    }
                });
            // 绑定服务器已接受连接
            ChannelFuture future = bootstrap.bind().sync();
            future.channel().closeFuture().sync();
        } finally {
            // 释放所有的资源
            group.shutdownGracefully().sync();
        }
    }
}

