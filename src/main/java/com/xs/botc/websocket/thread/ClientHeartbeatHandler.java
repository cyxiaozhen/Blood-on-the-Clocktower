package com.xs.botc.websocket.thread;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 心跳管理
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/4 周四
 */
public class ClientHeartbeatHandler extends ChannelInboundHandlerAdapter{
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {// 超时事件
			IdleStateEvent event = (IdleStateEvent)evt;
            if (event.state() == IdleState.READER_IDLE) {
                System.out.println("Read   空闲");
                ctx.disconnect();
            }
            else if (event.state() == IdleState.WRITER_IDLE) {
                System.out.println("Write  空闲");
                ctx.writeAndFlush("HeartBeat");
            }
		}
		super.userEventTriggered(ctx, evt);
	}
	
}
