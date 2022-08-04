package com.xs.botc.websocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理二进制消息 预留语言传输
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/4 周四
 */
public class BinaryWebSocketFrameHandler extends SimpleChannelInboundHandler<BinaryWebSocketFrame> {
    private static final Logger log = LoggerFactory.getLogger(BinaryWebSocketFrameHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BinaryWebSocketFrame msg) throws InterruptedException {
        log.info("服务器接收到二进制消息,消息长度:[{}]", msg.content().capacity());
        ByteBuf byteBuf = Unpooled.directBuffer(msg.content().capacity());
        // byteBuf.writeBytes(msg.content());
        // ctx.writeAndFlush(new BinaryWebSocketFrame(byteBuf));
    }
}
