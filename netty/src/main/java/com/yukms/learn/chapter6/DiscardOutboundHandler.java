package com.yukms.learn.chapter6;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

@Sharable
public class DiscardOutboundHandler extends ChannelOutboundHandlerAdapter {
    /** 丢弃并释放出站消息 */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
        // 释放资源
        ReferenceCountUtil.release(msg);
        // 通知ChannelPromise数据已经被处理了
        promise.setSuccess();
    }
}