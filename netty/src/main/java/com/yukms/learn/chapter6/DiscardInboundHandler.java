package com.yukms.learn.chapter6;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

@Sharable
public class DiscardInboundHandler extends ChannelInboundHandlerAdapter {
    /** 消费并释放入站消息 */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 释放资源
        ReferenceCountUtil.release(msg);
    }
}